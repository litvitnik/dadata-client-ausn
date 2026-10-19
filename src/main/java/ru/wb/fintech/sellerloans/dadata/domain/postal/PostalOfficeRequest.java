package ru.wb.fintech.sellerloans.dadata.domain.postal;

import ru.wb.fintech.sellerloans.dadata.domain.BasicRequest;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class PostalOfficeRequest extends BasicRequest {

    private List<PostalOfficeFilter> filters;

    @Builder
    public PostalOfficeRequest(String query, @Singular List<PostalOfficeFilter> filters) {
        super(query, null);
        this.filters = filters;
    }
}
