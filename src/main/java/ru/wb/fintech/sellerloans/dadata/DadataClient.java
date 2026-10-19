package ru.wb.fintech.sellerloans.dadata;

import ru.wb.fintech.sellerloans.dadata.domain.BasicRequest;
import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.Suggestion;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import ru.wb.fintech.sellerloans.dadata.domain.address.Address;
import ru.wb.fintech.sellerloans.dadata.domain.address.AddressRequest;
import ru.wb.fintech.sellerloans.dadata.domain.address.GeolocateRequest;
import ru.wb.fintech.sellerloans.dadata.domain.address.IplocateResponse;
import ru.wb.fintech.sellerloans.dadata.domain.bank.Bank;
import ru.wb.fintech.sellerloans.dadata.domain.bank.BankRequest;
import ru.wb.fintech.sellerloans.dadata.domain.court.Court;
import ru.wb.fintech.sellerloans.dadata.domain.court.CourtRequest;
import ru.wb.fintech.sellerloans.dadata.domain.delivery.Delivery;
import ru.wb.fintech.sellerloans.dadata.domain.email.Email;
import ru.wb.fintech.sellerloans.dadata.domain.fio.Fio;
import ru.wb.fintech.sellerloans.dadata.domain.fio.FioRequest;
import ru.wb.fintech.sellerloans.dadata.domain.fms.FmsUnit;
import ru.wb.fintech.sellerloans.dadata.domain.fms.FmsUnitRequest;
import ru.wb.fintech.sellerloans.dadata.domain.fns.FnsUnit;
import ru.wb.fintech.sellerloans.dadata.domain.fns.FnsUnitRequest;
import ru.wb.fintech.sellerloans.dadata.domain.okpd2.Okpd2;
import ru.wb.fintech.sellerloans.dadata.domain.organization.FindOrganizationByIdRequest;
import ru.wb.fintech.sellerloans.dadata.domain.organization.Organization;
import ru.wb.fintech.sellerloans.dadata.domain.organization.OrganizationRequest;
import ru.wb.fintech.sellerloans.dadata.domain.postal.PostalOffice;
import ru.wb.fintech.sellerloans.dadata.domain.postal.PostalOfficeRequest;
import ru.wb.fintech.sellerloans.dadata.exception.DadataException;
import ru.wb.fintech.sellerloans.dadata.exception.ErrorDetails;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Should be build using {@link DadataClientBuilder}
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class DadataClient {

    private static final String SUGGESTION_PREFIX = "/suggest";
    private static final String GEOLOCATE_PREFIX = "/geolocate";
    private static final String FIND_BY_ID_PREFIX = "/findById";

    private final WebClient webClient;

    public Flux<Suggestion<Organization>> suggestOrganization(OrganizationRequest request) {
        return suggest(SuggestionTypes.ORGANIZATION, request);
    }

    public Flux<Suggestion<Address>> suggestAddress(AddressRequest request) {
        return suggest(SuggestionTypes.ADDRESS, request);
    }

    public Flux<Suggestion<Bank>> suggestBank(BankRequest request) {
        return suggest(SuggestionTypes.BANK, request);
    }

    public Flux<Suggestion<Fio>> suggestFio(FioRequest request) {
        return suggest(SuggestionTypes.FIO, request);
    }

    public Flux<Suggestion<Email>> suggestEmail(BasicRequest request) {
        return suggest(SuggestionTypes.EMAIL, request);
    }

    public Flux<Suggestion<FmsUnit>> suggestFmsUnit(FmsUnitRequest request) {
        return suggest(SuggestionTypes.FMS, request);
    }

    public Flux<Suggestion<FnsUnit>> suggestFnsUnit(FnsUnitRequest request) {
        return suggest(SuggestionTypes.FNS, request);
    }

    public Flux<Suggestion<PostalOffice>> suggestPostalOffice(PostalOfficeRequest request) {
        return suggest(SuggestionTypes.POSTAL_OFFICE, request);
    }

    public Flux<Suggestion<Court>> suggestCourt(CourtRequest request) {
        return suggest(SuggestionTypes.COURT, request);
    }

    public Mono<Suggestion<Address>> findAddressById(String id) {
        return findById(SuggestionTypes.ADDRESS, new BasicRequest(id));
    }

    public Mono<Suggestion<Bank>> findBankById(String id) {
        return findById(SuggestionTypes.BANK, new BasicRequest(id));
    }

    public Mono<Suggestion<Organization>> findOrganizationById(String id) {
        return findById(SuggestionTypes.ORGANIZATION, new BasicRequest(id));
    }

    public Mono<Suggestion<Organization>> findOrganizationById(FindOrganizationByIdRequest request) {
        return findById(SuggestionTypes.ORGANIZATION, request);
    }

    /**
     * @param id Fms unit code. Format: 'XXX-XXX'
     * @return mono object
     */
    public Mono<Suggestion<FmsUnit>> findFmsUnitById(String id) {
        return findById(SuggestionTypes.FMS, new BasicRequest(id));
    }

    /**
     * @param id Fns unit code or inn
     * @return mono object
     */
    public Mono<Suggestion<FnsUnit>> findFnsUnitById(String id) {
        return findById(SuggestionTypes.FNS, new BasicRequest(id));
    }

    /**
     * @param index Postal office index
     * @return mono object
     */
    public Mono<Suggestion<PostalOffice>> findPostalOfficeById(String index) {
        return findById(SuggestionTypes.POSTAL_OFFICE, new BasicRequest(index));
    }

    /**
     * @param id Court code
     * @return mono object
     */
    public Mono<Suggestion<Court>> findCourtById(String id) {
        return findById(SuggestionTypes.COURT, new BasicRequest(id));
    }

    /**
     * @param id City kladr id
     * @return mono object
     */
    public Mono<Suggestion<Delivery>> findDeliveryById(String id) {
        return findById(SuggestionTypes.DELIVERY, new BasicRequest(id));
    }

    /**
     * @param code okpd2 code
     * @return mono object
     */
    public Mono<Suggestion<Okpd2>> findOkpd2ByCode(String code) {
        return findById(SuggestionTypes.OKPD_2, new BasicRequest(code));
    }

    public Flux<Suggestion<Okpd2>> suggestOkpd2(BasicRequest request) {
        return suggest(SuggestionTypes.OKPD_2, request);
    }

    public Flux<Suggestion<Address>> geolocate(GeolocateRequest request) {
        return executeOperation(SuggestionTypes.ADDRESS.getResponseClass(), request, GEOLOCATE_PREFIX,
            SuggestionTypes.ADDRESS.getSuggestOperationPrefix());
    }

    public Mono<Suggestion<Address>> iplocate(String ip) {
        return webClient
            .get()
            .uri(builder ->
                builder
                    .path("/iplocate" + SuggestionTypes.ADDRESS.getSuggestOperationPrefix())
                    .queryParam("ip", ip)
                    .build()
            )
            .retrieve()
            .onStatus(status -> !status.is2xxSuccessful(), DadataClient::errorResponse)
            .bodyToMono(new ParameterizedTypeReference<IplocateResponse>() {})
            .mapNotNull(IplocateResponse::getLocation);
    }

    protected <T> Flux<Suggestion<T>> suggest(SuggestionType<T> suggestionType, BasicRequest request) {
        return executeOperation(suggestionType.getResponseClass(), request, SUGGESTION_PREFIX,
            suggestionType.getSuggestOperationPrefix());
    }

    protected <T> Mono<Suggestion<T>> findById(SuggestionType<T> suggestionType, BasicRequest request) {
        return executeOperation(suggestionType.getResponseClass(), request, FIND_BY_ID_PREFIX,
            suggestionType.getFindByIdOperationPrefix()).next();
    }

    protected <T> Flux<Suggestion<T>> executeOperation(ParameterizedTypeReference<DadataResponse<T>> responseClass,
        BasicRequest request, String operationPrefix,
        String suggestionTypePrefix) {
        return webClient
            .post().uri(operationPrefix + suggestionTypePrefix)
            .body(BodyInserters.fromValue(request))
            .retrieve()
            .onStatus(status -> !status.is2xxSuccessful(), DadataClient::errorResponse)
            .bodyToMono(responseClass)
            .map(DadataResponse::getSuggestions)
            .flatMapMany(Flux::fromIterable);
    }

    private static Mono<DadataException> errorResponse(ClientResponse response) {
        return response.bodyToMono(ErrorDetails.class)
            .flatMap(error -> Mono.error(new DadataException(response.statusCode(), error)));
    }
}
