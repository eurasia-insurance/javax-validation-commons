package tech.lapsa.javax.validation.constraints;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.ValidURL;

public class ValidURLConstraintValidator implements ConstraintValidator<ValidURL, String> {

    private static final String URL_PATTERN = "^(?:([^:/?#]+):)?(?://([^/?#]*))?([^?#]*)(?:\\?([^#]*))?(?:#(.*))?$";

    private Pattern pattern;

    @Override
    public void initialize(ValidURL a) {
	pattern = Pattern.compile(URL_PATTERN);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	return pattern.matcher(value.toString()).matches();
    }

}