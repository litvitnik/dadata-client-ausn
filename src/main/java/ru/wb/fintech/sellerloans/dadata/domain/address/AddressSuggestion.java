package ru.wb.fintech.sellerloans.dadata.domain.address;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class AddressSuggestion implements SuggestionType<Address> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Address>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Address>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/address";
    }
}
