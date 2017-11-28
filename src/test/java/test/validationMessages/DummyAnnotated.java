package test.validationMessages;

import tech.lapsa.javax.validation.DaysAfterNow;
import tech.lapsa.javax.validation.DaysBeforeNow;
import tech.lapsa.javax.validation.NotEmptyString;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.javax.validation.NotZeroAmount;
import tech.lapsa.javax.validation.TemporalFuture;
import tech.lapsa.javax.validation.TemporalLeftAfterRight;
import tech.lapsa.javax.validation.TemporalLeftBeforeRight;
import tech.lapsa.javax.validation.TemporalPast;
import tech.lapsa.javax.validation.ValidDateOfBirth;
import tech.lapsa.javax.validation.ValidDateOfIssue;
import tech.lapsa.javax.validation.ValidEmail;
import tech.lapsa.javax.validation.ValidHumanName;
import tech.lapsa.javax.validation.ValidURI;
import tech.lapsa.javax.validation.ValidURL;

public interface DummyAnnotated {

    @TemporalFuture
    @TemporalLeftAfterRight
    @TemporalLeftBeforeRight
    @TemporalPast
    @DaysAfterNow(5)
    @DaysBeforeNow(5)
    @NotEmptyString
    @NotNullValue
    // becasuse needs to know how to pass annotation values
    // to message interpolator
    // @NotTooOldYearOfIssue
    // @NotTooYoungYearOfIssue
    @NotZeroAmount
    @ValidDateOfBirth
    @ValidDateOfIssue
    @ValidHumanName
    @ValidURI
    @ValidEmail
    @ValidURL
    void dummy();
}
