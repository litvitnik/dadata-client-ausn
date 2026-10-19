package ru.wb.fintech.sellerloans.dadata.domain.fms;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class FmsUnitSuggestion implements SuggestionType<FmsUnit> {

    @Override
    public ParameterizedTypeReference<DadataResponse<FmsUnit>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<FmsUnit>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/fms_unit";
    }

}
