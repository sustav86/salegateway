package ua.sustavov.payment;

import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import ua.sustavov.payment.model.Card;
import ua.sustavov.payment.model.Transaction;
import ua.sustavov.payment.service.Transactionality;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {

    private String response;

    @WireVariable
    private Card modelCard;

    @WireVariable
    private Transaction modelTransaction;

    @WireVariable
    private Transactionality transaction;

    @WireVariable
    private Validator maxLengthValidator;

    @WireVariable
    private Validator zeroValidator;

    public Card getModelCard() {
        return modelCard;
    }

    public Transaction getModelTransaction() {
        return modelTransaction;
    }

    public Validator getMaxLengthValidator() {
        return maxLengthValidator;
    }

    public Validator getZeroValidator() {
        return zeroValidator;
    }

    public String getResponse() {
        return response;
    }

    @Command
    @NotifyChange("response")
    public void saveOrder() {
        response = transaction.sale(modelCard, modelTransaction);
    }

}
