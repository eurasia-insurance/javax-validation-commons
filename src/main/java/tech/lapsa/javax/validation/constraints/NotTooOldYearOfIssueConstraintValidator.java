package tech.lapsa.javax.validation.constraints;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.NotTooOldYearOfIssue;

public class NotTooOldYearOfIssueConstraintValidator
	implements ConstraintValidator<NotTooOldYearOfIssue, Integer> {

    private int maxAge;

    @Override
    public void initialize(final NotTooOldYearOfIssue a) {
	maxAge = a.maxAge();
    }

    @Override
    public boolean isValid(final Integer value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	final int nowY = LocalDate.now().getYear();
	final int age = nowY - value;
	return age <= maxAge;
    }
}