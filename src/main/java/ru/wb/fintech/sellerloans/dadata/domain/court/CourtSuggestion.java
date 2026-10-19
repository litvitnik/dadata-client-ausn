package ru.wb.fintech.sellerloans.dadata.domain.court;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class CourtSuggestion implements SuggestionType<Court> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Court>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Court>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/region_court";
    }

}
