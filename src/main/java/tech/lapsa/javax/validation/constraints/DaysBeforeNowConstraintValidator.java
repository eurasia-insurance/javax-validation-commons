package tech.lapsa.javax.validation.constraints;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import tech.lapsa.javax.validation.DaysBeforeNow;
import tech.lapsa.javax.validation.Mode;

public class DaysBeforeNowConstraintValidator extends ATemporalConstraintValidator<DaysBeforeNow> {

    private Mode mode;
    private long days;

    @Override
    public void initialize(DaysBeforeNow constraintAnnotation) {
	this.mode = constraintAnnotation.mode();
	this.days = constraintAnnotation.value();
    }

    @Override
    protected boolean validate(Date value) {
	switch (mode) {
	case MUST_NOT:
	    return value.toInstant().isBefore(Instant.now().plus(days, ChronoUnit.DAYS));
	case MUST:
	default:
	    return value.toInstant().isBefore(Instant.now().minus(days, ChronoUnit.DAYS));
	}
    }

    @Override
    protected boolean validate(LocalDateTime value) {
	switch (mode) {
	case MUST_NOT:
	    return value.isBefore(LocalDateTime.now().plusDays(days));
	case MUST:
	default:
	    return value.isBefore(LocalDateTime.now().minusDays(days));
	}
    }

    @Override
    protected boolean validate(Instant value) {
	switch (mode) {
	case MUST_NOT:
	    return value.isBefore(Instant.now().plus(days, ChronoUnit.DAYS));
	case MUST:
	default:
	    return value.isBefore(Instant.now().minus(days, ChronoUnit.DAYS));
	}
    }

    @Override
    protected boolean validate(LocalDate value) {
	switch (mode) {
	case MUST_NOT:
	    return value.isBefore(LocalDate.now().plusDays(days));
	case MUST:
	default:
	    return value.isBefore(LocalDate.now().minusDays(days));
	}
    }
}