package ru.wb.fintech.sellerloans.dadata.domain.okpd2;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class Okpd2Suggestion implements SuggestionType<Okpd2> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Okpd2>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Okpd2>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/okpd2";
    }

}
