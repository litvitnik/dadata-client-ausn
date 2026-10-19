package ru.wb.fintech.sellerloans.dadata.domain.fns;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class FnsUnitSuggestion implements SuggestionType<FnsUnit> {

    @Override
    public ParameterizedTypeReference<DadataResponse<FnsUnit>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<FnsUnit>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/fns_unit";
    }

}
