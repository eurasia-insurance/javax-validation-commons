package tech.lapsa.javax.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import tech.lapsa.javax.validation.constraints.NotTooOldYearOfIssueConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = NotTooOldYearOfIssueConstraintValidator.class)
public @interface NotTooOldYearOfIssue {
    String message() default "{tech.lapsa.javax.validation.NotTooOldYearOfIssue.message}";

    int maxAge() default 10;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
