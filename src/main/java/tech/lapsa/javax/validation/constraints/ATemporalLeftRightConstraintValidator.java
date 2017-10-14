package tech.lapsa.javax.validation.constraints;

import static com.lapsa.utils.TemporalUtils.*;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.CalendarComparison;
import tech.lapsa.javax.validation.DateComparison;
import tech.lapsa.javax.validation.LocalDateComparison;
import tech.lapsa.javax.validation.LocalDateTimeComparison;
import tech.lapsa.javax.validation.TemporalComparison;

public abstract class ATemporalLeftRightConstraintValidator<A extends Annotation>
	implements ConstraintValidator<A, TemporalComparison<?>> {

    @Override
    public boolean isValid(TemporalComparison<?> value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;

	if (value instanceof CalendarComparison)
	    return compare((CalendarComparison) value);

	if (value instanceof DateComparison)
	    return compare((DateComparison) value);

	if (value instanceof LocalDateComparison)
	    return compare((LocalDateComparison) value);

	if (value instanceof LocalDateTimeComparison)
	    return compare((LocalDateTimeComparison) value);

	return true;
    }

    private boolean compare(LocalDateTimeComparison value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(LocalDateComparison value) {
	return compare(value.left(), value.right());
    }

    private boolean compare(DateComparison value) {
	return compare(toLocalDateTime(value.left()), toLocalDateTime(value.right()));
    }

    private boolean compare(CalendarComparison value) {
	return compare(toLocalDateTime(value.left()), toLocalDateTime(value.right()));
    }

    protected abstract boolean compare(LocalDateTime left, LocalDateTime right);

    protected abstract boolean compare(LocalDate left, LocalDate right);
}
