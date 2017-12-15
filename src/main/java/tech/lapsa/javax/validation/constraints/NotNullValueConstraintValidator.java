package tech.lapsa.javax.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.NotNullValue;

public class NotNullValueConstraintValidator implements ConstraintValidator<NotNullValue, Object> {

    @Override
    public void initialize(final NotNullValue constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
	return value != null;
    }

}