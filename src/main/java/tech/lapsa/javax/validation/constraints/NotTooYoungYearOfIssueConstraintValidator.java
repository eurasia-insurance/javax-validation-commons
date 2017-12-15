package tech.lapsa.javax.validation.constraints;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.javax.validation.NotTooYoungYearOfIssue;

public class NotTooYoungYearOfIssueConstraintValidator
	implements ConstraintValidator<NotTooYoungYearOfIssue, Integer> {

    private int minAge;

    @Override
    public void initialize(final NotTooYoungYearOfIssue a) {
	minAge = a.minAge();
    }

    @Override
    public boolean isValid(final Integer value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	final int nowY = LocalDate.now().getYear();
	final int age = nowY - value;
	return age >= minAge;
    }
}