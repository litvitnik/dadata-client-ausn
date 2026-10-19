package ru.wb.fintech.sellerloans.dadata.domain.organization;

import ru.wb.fintech.sellerloans.dadata.domain.fio.Fio;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Manager {

    String ogrn;
    String inn;
    String name;
    Fio fio;
    String post;
    String hid;
    ManagerType type;

    public enum ManagerType {

        EMPLOYEE,
        FOREIGNER,
        LEGAL
    }
}
