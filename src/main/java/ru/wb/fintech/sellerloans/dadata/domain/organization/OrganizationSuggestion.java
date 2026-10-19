package ru.wb.fintech.sellerloans.dadata.domain.organization;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class OrganizationSuggestion implements SuggestionType<Organization> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Organization>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Organization>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/party";
    }
}
