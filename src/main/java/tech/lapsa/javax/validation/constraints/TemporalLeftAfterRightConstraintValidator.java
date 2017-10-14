package tech.lapsa.javax.validation.constraints;

import java.time.LocalDate;
import java.time.LocalDateTime;

import tech.lapsa.javax.validation.TemporalLeftBeforeRight;

public class TemporalLeftAfterRightConstraintValidator extends ATemporalLeftRightConstraintValidator<TemporalLeftBeforeRight> {

    @Override
    public void initialize(TemporalLeftBeforeRight constraintAnnotation) {
    }

    @Override
    protected boolean compare(LocalDateTime left, LocalDateTime right) {
	if (left == null || right == null)
	    return true;
	return left.isAfter(right);
    }

    @Override
    protected boolean compare(LocalDate left, LocalDate right) {
	if (left == null || right == null)
	    return true;
	return left.isAfter(right);
    }

}