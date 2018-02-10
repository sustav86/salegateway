package ua.sustavov.payment.validators;

import org.springframework.stereotype.Component;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */

@Component("zeroValidator")
public class ZeroValidator extends AbstractValidator {

    @Override
    public void validate(ValidationContext validationContext) {
        if (validationContext.getProperty().getValue() instanceof Number){
            int value = (Integer) validationContext.getProperty().getValue();
            if (value <= 0){
                validationContext.setInvalid();
                addInvalidMessage(validationContext, "Field can not be zero");
            }
        }else{
            validationContext.setInvalid();
        }
    }
}
