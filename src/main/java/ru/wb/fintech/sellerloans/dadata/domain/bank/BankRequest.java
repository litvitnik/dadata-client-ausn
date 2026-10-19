package ru.wb.fintech.sellerloans.dadata.domain.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.wb.fintech.sellerloans.dadata.domain.BasicRequest;
import ru.wb.fintech.sellerloans.dadata.domain.OrganizationStatus;
import ru.wb.fintech.sellerloans.dadata.domain.address.FilterProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669107">Dadata bank suggestion docs</a>
 * @see ru.wb.fintech.sellerloans.dadata.domain.bank.BankRequestBuilder
 */

@Value
@EqualsAndHashCode(callSuper = true)
public class BankRequest extends BasicRequest {

    @JsonProperty("locations_boost")
    List<Map<FilterProperty, String>> locationsBoost;
    List<Map<FilterProperty, String>> locations;
    @JsonProperty("status")
    Set<OrganizationStatus> statuses;
    @JsonProperty("type")
    Set<BankType> types;

    public BankRequest(String query, Integer count, List<Map<FilterProperty, String>> locationsBoost,
        List<Map<FilterProperty, String>> locations,
        Set<OrganizationStatus> statuses, Set<BankType> types) {
        super(query, count);
        this.locationsBoost = locationsBoost;
        this.locations = locations;
        this.statuses = statuses;
        this.types = types;
    }
}
