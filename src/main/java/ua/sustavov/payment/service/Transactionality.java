package ua.sustavov.payment.service;

import ua.sustavov.payment.model.Card;
import ua.sustavov.payment.model.Transaction;

/**
 * Created by SUSTAVOV on 08.02.2018.
 */

public interface Transactionality {

    String sale(Card card, Transaction transaction);

}
