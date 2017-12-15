package tech.lapsa.javax.validation.constraints;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import tech.lapsa.javax.validation.DaysAfterNow;
import tech.lapsa.javax.validation.Mode;

public class DaysAfterNowConstraintValidator extends ATemporalConstraintValidator<DaysAfterNow> {

    private Mode mode;
    private long days;

    @Override
    public void initialize(final DaysAfterNow constraintAnnotation) {
	mode = constraintAnnotation.mode();
	days = constraintAnnotation.value();
    }

    @Override
    protected boolean validate(final LocalDateTime value) {
	switch (mode) {
	case MUST_NOT:
	    return value.isAfter(LocalDateTime.now().minusDays(days));
	case MUST:
	default:
	    return value.isAfter(LocalDateTime.now().plusDays(days));
	}
    }

    @Override
    protected boolean validate(final Instant value) {
	switch (mode) {
	case MUST_NOT:
	    return value.isAfter(Instant.now().minus(days, ChronoUnit.DAYS));
	case MUST:
	default:
	    return value.isAfter(Instant.now().plus(days, ChronoUnit.DAYS));
	}
    }

    @Override
    protected boolean validate(final LocalDate value) {
	switch (mode) {
	case MUST_NOT:
	    return value.isAfter(LocalDate.now().minusDays(days));
	case MUST:
	default:
	    return value.isAfter(LocalDate.now().plusDays(days));
	}
    }
}