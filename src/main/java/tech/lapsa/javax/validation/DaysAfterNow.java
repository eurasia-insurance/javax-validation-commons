package tech.lapsa.javax.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import tech.lapsa.javax.validation.constraints.DaysAfterNowConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = DaysAfterNowConstraintValidator.class)
public @interface DaysAfterNow {

    Mode mode() default Mode.MUST;

    int value();

    String message() default "{tech.lapsa.javax.validation.DaysAfterNow.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
