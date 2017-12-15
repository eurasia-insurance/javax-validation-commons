package tech.lapsa.javax.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.NotEmptyString;

public class NotEmptyStringConstraintValidator implements ConstraintValidator<NotEmptyString, String> {

    private boolean trimSpaces;

    @Override
    public void initialize(final NotEmptyString a) {
	trimSpaces = a.trimSpaces();
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	if (trimSpaces)
	    return !value.trim().isEmpty();
	else
	    return !value.isEmpty();
    }

}