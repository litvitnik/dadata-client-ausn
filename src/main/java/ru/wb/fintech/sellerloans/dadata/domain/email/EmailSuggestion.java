package ru.wb.fintech.sellerloans.dadata.domain.email;

import ru.wb.fintech.sellerloans.dadata.domain.DadataResponse;
import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import org.springframework.core.ParameterizedTypeReference;

public class EmailSuggestion implements SuggestionType<Email> {

    @Override
    public ParameterizedTypeReference<DadataResponse<Email>> getResponseClass() {
        return new ParameterizedTypeReference<DadataResponse<Email>>() {};
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/email";
    }

    @Override
    public String getFindByIdOperationPrefix() {
        throw new UnsupportedOperationException("Operation 'findById' not supported for Email");
    }
}
