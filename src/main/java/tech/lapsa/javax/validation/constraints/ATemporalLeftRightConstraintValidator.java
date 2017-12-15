package tech.lapsa.javax.validation.constraints;

import java.lang.annotation.Annotation;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import tech.lapsa.javax.validation.DateComparison;
import tech.lapsa.javax.validation.InstantComparison;
import tech.lapsa.javax.validation.LocalDateComparison;
import tech.lapsa.javax.validation.LocalDateTimeComparison;
import tech.lapsa.javax.validation.TemporalComparison;

public abstract class ATemporalLeftRightConstraintValidator<A extends Annotation>
	implements ConstraintValidator<A, TemporalComparison<?>> {

    @Override
    public boolean isValid(final TemporalComparison<?> value, final ConstraintValidatorContext context) {
	if (value == null)
	    return true;

	if (value instanceof DateComparison)
	    return compare((DateComparison) value);

	if (value instanceof InstantComparison)
	    return compare((InstantComparison) value);

	if (value instanceof LocalDateComparison)
	    return compare((LocalDateComparison) value);

	if (value instanceof LocalDateTimeComparison)
	    return compare((LocalDateTimeComparison) value);

	return true;
    }

    private boolean compare(final LocalDateTimeComparison value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(final InstantComparison value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(final LocalDateComparison value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(final DateComparison value) {
	return compare(value.left(), value.right());
    }

    protected static ValidationException unsupportedType(final Class<?> clazz) {
	return new ValidationException(String.format("%1$s isn't supported for this constraint", clazz));
    }

    protected boolean compare(final Date left, final Date right) {
	throw unsupportedType(left.getClass());
    }

    protected boolean compare(final Instant left, final Instant right) {
	throw unsupportedType(left.getClass());
    }

    protected boolean compare(final LocalDateTime left, final LocalDateTime right) {
	throw unsupportedType(left.getClass());
    }

    protected boolean compare(final LocalDate left, final LocalDate right) {
	throw unsupportedType(left.getClass());
    }
}
