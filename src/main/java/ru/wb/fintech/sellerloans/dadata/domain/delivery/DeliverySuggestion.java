package ru.wb.fintech.sellerloans.dadata.domain.delivery;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class DeliverySuggestion implements SuggestionType<Delivery> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Delivery>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Delivery>>() {};
    }

    @Override
    public String getFindByIdOperationPrefix() {
        return "/delivery";
    }

    @Override
    public String getSuggestOperationPrefix() {
        throw new UnsupportedOperationException("Operation 'suggest' not supported for Delivery");
    }

}
