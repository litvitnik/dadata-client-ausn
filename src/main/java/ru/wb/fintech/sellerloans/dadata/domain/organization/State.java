package ru.wb.fintech.sellerloans.dadata.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.wb.fintech.sellerloans.dadata.domain.OrganizationStatus;
import ru.wb.fintech.sellerloans.dadata.json.LocalDateDeserializer;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class State {

    @JsonAlias("actuality_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate actualityDate;
    @JsonAlias("registration_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate registrationDate;
    @JsonAlias("liquidation_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate liquidationDate;
    String code;
    OrganizationStatus status;
}
