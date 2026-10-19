package ru.wb.fintech.sellerloans.dadata.domain.address;

import ru.wb.fintech.sellerloans.dadata.domain.Suggestion;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class IplocateResponse {

    Suggestion<Address> location;
}
