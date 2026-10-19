package ru.wb.fintech.sellerloans.dadata.domain.bank;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class BankSuggestion implements SuggestionType<Bank> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Bank>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Bank>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/bank";
    }

}
