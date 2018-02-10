package ua.sustavov.payment.enums;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */
public enum RequestType {

    SALE("sale"), SALE_AUTH("sale-auth");

    private final String name;

    RequestType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
