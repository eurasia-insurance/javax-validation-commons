package tech.lapsa.javax.validation.constraints;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.ValidEmail;

public class ValidEmailConstraintValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern;

    @Override
    public void initialize(final ValidEmail a) {
	pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	return pattern.matcher(value.toString()).matches();
    }

}