package ua.sustavov.payment.validators;

import org.springframework.stereotype.Component;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.validator.AbstractValidator;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */

@Component("maxLengthValidator")
public class MaxLengthValidator extends AbstractValidator implements Validator {

    @Override
    public void validate(ValidationContext validationContext) {
        Number maxLength = (Number)validationContext.getBindContext().getValidatorArg("length");
        if (validationContext.getProperty().getValue() instanceof String){
            String value = (String)validationContext.getProperty().getValue();
            if (value.length() > maxLength.longValue()){
                validationContext.setInvalid();
                addInvalidMessage(validationContext, "Field should be less than " + maxLength);
            }
        }else{
            validationContext.setInvalid();
        }
    }
}
