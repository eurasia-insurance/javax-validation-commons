package tech.lapsa.javax.validation.constraints;

import java.time.LocalDate;

import tech.lapsa.javax.validation.ValidDateOfBirth;

public class ValidDateOfBirthConstraintValidator extends ATemporalConstraintValidator<ValidDateOfBirth> {

    @Override
    protected boolean validate(final LocalDate value) {
	return true;
    }

}