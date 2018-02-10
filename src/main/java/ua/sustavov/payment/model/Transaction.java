package ua.sustavov.payment.model;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ua.sustavov.payment.enums.AccountType;
import ua.sustavov.payment.enums.RequestType;
import ua.sustavov.payment.enums.TransactionIndustryType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by SUSTAVOV on 07.02.2018.
 */

@XmlRootElement
public class Transaction {

    //TODO lombok

    private int amount;
    private String holderName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private RequestType requestType;
    private String accountId;
    private TransactionIndustryType transactionIndustryType;
    private String transactionCode;
    private AccountType accountType;
    private String accountNumber;
    private String accountAccessory;
    private String customerAccountCode;

    public Transaction() {
    }

    public Transaction(int amount, String holderName, String street, String city, String state, String zipCode) {
        this.amount = amount;
        this.holderName = holderName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.requestType = RequestType.SALE;
        this.accountId = "829001";
        this.transactionIndustryType = TransactionIndustryType.RE;
        this.transactionCode = "0000000001";
        this.accountType = AccountType.R;
        this.accountNumber = "4111111111111111";
        this.accountAccessory = "0333";
        this.customerAccountCode = "0000000001";
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", holderName='" + holderName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public String toPOSTString() {

        Session sess = Sessions.getCurrent();
        User currentUser = (User)sess.getAttribute("currentUser");

        return "&userName=" + currentUser.getUserName() +
                "&password=" + currentUser.getPassword() +
                "&requestType=" + "sale" +
                "&accountId=" + "829001" +
                "&transactionIndustryType=" + "RE" +
                "&transactionCode=" + "0000000001" +
                "&amount=" + amount +
                "&holderName=" + holderName +
                "&street=" + street +
                "&city=" + city +
                "&state=" + state +
                "&zipCode=" + zipCode +
                "&accountType=" + "R" +
                "&accountNumber=" + "4111111111111111" +
                "&accountAccessory=" + "0333" +
                "&customerAccountCode=" + "0000000001";
    }
}
