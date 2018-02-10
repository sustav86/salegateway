package ua.sustavov.payment.enums;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */
public enum AccountType {

    R("R"), E("E");

    private final String name;

    AccountType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
