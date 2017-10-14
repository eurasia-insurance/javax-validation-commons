package tech.lapsa.javax.validation.constraints;

import java.time.LocalDate;

import tech.lapsa.javax.validation.ValidDateOfIssue;

public class ValidDateOfIssueConstraintValidator extends ATemporalConstraintValidator<ValidDateOfIssue> {

    @Override
    protected boolean validate(LocalDate value) {
	return true;
    }

}