package ru.wb.fintech.sellerloans.dadata.domain.fio;

import ru.wb.fintech.sellerloans.dadata.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669113">Dadata fio object</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class Fio extends AdditionalProps {

    String name;
    String surname;
    String patronymic;
    Gender gender;
    String source;
    String qc;
}
