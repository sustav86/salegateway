package ua.sustavov.payment.model;

import java.util.Date;

/**
 * Created by SUSTAVOV on 07.02.2018.
 */
public class Card {

    //TODO lombok

    private String cardNumber;
    private Date expDate;
    private String cscCode;

    public Card() {
    }

    public Card(String cardNumber, Date expDate, String cscCode) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cscCode = cscCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getCscCode() {
        return cscCode;
    }

    public void setCscCode(String cscCode) {
        this.cscCode = cscCode;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expDate=" + expDate +
                ", cscCode='" + cscCode + '\'' +
                '}';
    }
}
