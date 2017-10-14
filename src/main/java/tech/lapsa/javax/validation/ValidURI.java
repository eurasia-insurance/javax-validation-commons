package tech.lapsa.javax.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import tech.lapsa.javax.validation.constraints.ValidURIConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidURIConstraintValidator.class)
public @interface ValidURI {
    String message() default "{tech.lapsa.javax.validation.ValidURI.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean mustAbsolute() default true;

    String[] allowedSchemes() default { "http", "https" };
}
