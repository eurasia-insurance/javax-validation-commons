package tech.lapsa.javax.validation.constraints;

import java.time.LocalDate;
import java.time.LocalDateTime;

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