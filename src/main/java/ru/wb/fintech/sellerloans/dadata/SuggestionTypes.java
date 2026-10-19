package ru.wb.fintech.sellerloans.dadata;

import ru.wb.fintech.sellerloans.dadata.domain.SuggestionType;
import ru.wb.fintech.sellerloans.dadata.domain.address.Address;
import ru.wb.fintech.sellerloans.dadata.domain.address.AddressSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.bank.Bank;
import ru.wb.fintech.sellerloans.dadata.domain.bank.BankSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.court.Court;
import ru.wb.fintech.sellerloans.dadata.domain.court.CourtSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.delivery.Delivery;
import ru.wb.fintech.sellerloans.dadata.domain.delivery.DeliverySuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.email.Email;
import ru.wb.fintech.sellerloans.dadata.domain.email.EmailSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.fio.Fio;
import ru.wb.fintech.sellerloans.dadata.domain.fio.FioSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.fms.FmsUnit;
import ru.wb.fintech.sellerloans.dadata.domain.fms.FmsUnitSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.fns.FnsUnit;
import ru.wb.fintech.sellerloans.dadata.domain.fns.FnsUnitSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.okpd2.Okpd2;
import ru.wb.fintech.sellerloans.dadata.domain.okpd2.Okpd2Suggestion;
import ru.wb.fintech.sellerloans.dadata.domain.organization.Organization;
import ru.wb.fintech.sellerloans.dadata.domain.organization.OrganizationSuggestion;
import ru.wb.fintech.sellerloans.dadata.domain.postal.PostalOffice;
import ru.wb.fintech.sellerloans.dadata.domain.postal.PostalOfficeSuggestion;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SuggestionTypes {

    public static final SuggestionType<Organization> ORGANIZATION = new OrganizationSuggestion();
    public static final SuggestionType<Address> ADDRESS = new AddressSuggestion();
    public static final SuggestionType<Bank> BANK = new BankSuggestion();
    public static final SuggestionType<Fio> FIO = new FioSuggestion();
    public static final SuggestionType<Email> EMAIL = new EmailSuggestion();
    public static final SuggestionType<FmsUnit> FMS = new FmsUnitSuggestion();
    public static final SuggestionType<FnsUnit> FNS = new FnsUnitSuggestion();
    public static final SuggestionType<PostalOffice> POSTAL_OFFICE = new PostalOfficeSuggestion();
    public static final SuggestionType<Court> COURT = new CourtSuggestion();
    public static final SuggestionType<Delivery> DELIVERY = new DeliverySuggestion();
    public static final SuggestionType<Okpd2> OKPD_2 = new Okpd2Suggestion();
}
