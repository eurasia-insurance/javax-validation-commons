package tech.lapsa.javax.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import tech.lapsa.javax.validation.constraints.NotEmptyStringConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = NotEmptyStringConstraintValidator.class)
public @interface NotEmptyString {

    String message() default "{tech.lapsa.javax.validation.NotEmptyString.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean trimSpaces() default true;

}