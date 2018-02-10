package ua.sustavov.payment.enums;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */
public enum TransactionIndustryType {

    RE("RE"), RS("RS");

    private final String name;

    TransactionIndustryType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
