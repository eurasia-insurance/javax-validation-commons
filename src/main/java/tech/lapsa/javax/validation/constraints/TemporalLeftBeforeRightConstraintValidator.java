package tech.lapsa.javax.validation.constraints;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import tech.lapsa.javax.validation.TemporalLeftBeforeRight;

public class TemporalLeftBeforeRightConstraintValidator
	extends ATemporalLeftRightConstraintValidator<TemporalLeftBeforeRight> {

    @Override
    public void initialize(TemporalLeftBeforeRight constraintAnnotation) {
    }

    @Override
    protected boolean compare(LocalDateTime left, LocalDateTime right) {
	if (left == null || right == null)
	    return true;
	return left.isBefore(right);
    }

    @Override
    protected boolean compare(LocalDate left, LocalDate right) {
	if (left == null || right == null)
	    return true;
	return left.isBefore(right);
    }

    @Override
    protected boolean compare(Instant left, Instant right) {
	if (left == null || right == null)
	    return true;
	return left.isBefore(right);
    }

    @Override
    protected boolean compare(Date left, Date right) {
	if (left == null || right == null)
	    return true;
	return left.before(right);
    }
}