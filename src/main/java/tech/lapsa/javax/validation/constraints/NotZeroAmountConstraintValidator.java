package tech.lapsa.javax.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.NotZeroAmount;

public class NotZeroAmountConstraintValidator
	implements ConstraintValidator<NotZeroAmount, Number> {

    @Override
    public void initialize(final NotZeroAmount a) {
    }

    @Override
    public boolean isValid(final Number value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	if (value instanceof Double)
	    return value.doubleValue() > 0;
	if (value instanceof Integer)
	    return value.intValue() > 0;
	if (value instanceof Long)
	    return value.longValue() > 0;
	if (value instanceof Short)
	    return value.shortValue() > 0;
	if (value instanceof Byte)
	    return value.byteValue() > 0;
	if (value instanceof Float)
	    return value.floatValue() > 0;
	return false;
    }
}