package tech.lapsa.javax.validation.constraints;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import tech.lapsa.javax.validation.TemporalLeftBeforeRight;

public class TemporalLeftAfterRightConstraintValidator
	extends ATemporalLeftRightConstraintValidator<TemporalLeftBeforeRight> {

    @Override
    public void initialize(final TemporalLeftBeforeRight constraintAnnotation) {
    }

    @Override
    protected boolean compare(final LocalDateTime left, final LocalDateTime right) {
	if (left == null || right == null)
	    return true;
	return left.isAfter(right);
    }

    @Override
    protected boolean compare(final LocalDate left, final LocalDate right) {
	if (left == null || right == null)
	    return true;
	return left.isAfter(right);
    }

    @Override
    protected boolean compare(final Instant left, final Instant right) {
	if (left == null || right == null)
	    return true;
	return left.isAfter(right);
    }

    @Override
    protected boolean compare(final Date left, final Date right) {
	if (left == null || right == null)
	    return true;
	return left.after(right);
    }

}