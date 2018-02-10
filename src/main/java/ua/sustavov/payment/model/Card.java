package ua.sustavov.payment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SUSTAVOV on 07.02.2018.
 */

@XmlRootElement
@Component("modelCard")
@Data
@NoArgsConstructor
@ToString
public class Card implements Serializable {

    private String cardNumber;
    private Date expDate;
    private String cscCode;

    public Card(String cardNumber, Date expDate, String cscCode) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cscCode = cscCode;
    }

}
