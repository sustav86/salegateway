package ua.sustavov.payment.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ua.sustavov.payment.enums.AccountType;
import ua.sustavov.payment.enums.RequestType;
import ua.sustavov.payment.enums.TransactionIndustryType;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by SUSTAVOV on 07.02.2018.
 */

@XmlRootElement
@Component("modelTransaction")
@Data
@ToString
public class Transaction implements Serializable {

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
        this.accountId = "829001";
        this.transactionIndustryType = TransactionIndustryType.RE;
        this.transactionCode = "0000000001";
        this.accountType = AccountType.R;
        this.accountNumber = "4111111111111111";
        this.accountAccessory = "0333";
        this.customerAccountCode = "0000000001";
        this.requestType = RequestType.SALE;
    }

    public Transaction(int amount, String holderName, String street, String city, String state, String zipCode) {
        this.amount = amount;
        this.holderName = holderName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
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
