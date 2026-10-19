package ru.wb.fintech.sellerloans.dadata.domain.fio;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class FioSuggestion implements SuggestionType<Fio> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Fio>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Fio>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/fio";
    }

    @Override
    public String getFindByIdOperationPrefix() {
        throw new UnsupportedOperationException("Operation 'findById' not supported for Fio");
    }
}
