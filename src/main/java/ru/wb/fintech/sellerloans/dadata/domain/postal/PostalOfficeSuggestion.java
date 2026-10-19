package ru.wb.fintech.sellerloans.dadata.domain.postal;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class PostalOfficeSuggestion implements SuggestionType<PostalOffice> {

    @Override
    public ParameterizedTypeReference<DadataResponse<PostalOffice>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<PostalOffice>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/postal_office";
    }

}
