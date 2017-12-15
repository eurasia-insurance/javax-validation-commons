package tech.lapsa.javax.validation.constraints;

import java.lang.annotation.Annotation;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

public abstract class ATemporalConstraintValidator<A extends Annotation> implements ConstraintValidator<A, Object> {

    @Override
    public void initialize(final A a) {
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	if (value instanceof Date)
	    return validate((Date) value);
	if (value instanceof Instant)
	    return validate((Instant) value);
	if (value instanceof LocalTime)
	    return validate((LocalTime) value);
	if (value instanceof LocalDate)
	    return validate((LocalDate) value);
	if (value instanceof LocalDateTime)
	    return validate((LocalDateTime) value);
	throw unsupportedType(value.getClass());
    }

    protected static ValidationException unsupportedType(final Class<?> clazz) {
	return new ValidationException(String.format("%1$s isn't supported for this constraint", clazz));
    }

    protected boolean validate(final Date value) {
	throw unsupportedType(value.getClass());
    }

    protected boolean validate(final Instant value) {
	throw unsupportedType(value.getClass());
    }

    protected boolean validate(final LocalDateTime value) {
	throw unsupportedType(value.getClass());
    }

    protected boolean validate(final LocalDate value) {
	throw unsupportedType(value.getClass());
    }

    protected boolean validate(final LocalTime value) {
	throw unsupportedType(value.getClass());
    }

}
