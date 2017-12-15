package tech.lapsa.javax.validation.constraints;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import tech.lapsa.javax.validation.TemporalPast;

public class TemporalPastConstraintValidator extends ATemporalConstraintValidator<TemporalPast> {

    private boolean allowNow;

    @Override
    public void initialize(final TemporalPast constraintAnnotation) {
	allowNow = constraintAnnotation.allowNow();
    }

    @Override
    protected boolean validate(final Date value) {
	final Date now = new Date();
	return value.before(now) || allowNow && value.equals(now);
    }

    @Override
    protected boolean validate(final LocalDateTime value) {
	final LocalDateTime now = LocalDateTime.now();
	return value.isBefore(now) || allowNow && value.isEqual(now);
    }

    @Override
    protected boolean validate(final LocalDate value) {
	final LocalDate now = LocalDate.now();
	return value.isBefore(now) || allowNow && value.isEqual(now);
    }

    @Override
    protected boolean validate(final LocalTime value) {
	final LocalTime now = LocalTime.now();
	return value.isBefore(now) || allowNow && value.equals(now);
    }

    @Override
    protected boolean validate(final Instant value) {
	final Instant now = Instant.now();
	return value.isBefore(now) || allowNow && value.equals(now);
    }

}
