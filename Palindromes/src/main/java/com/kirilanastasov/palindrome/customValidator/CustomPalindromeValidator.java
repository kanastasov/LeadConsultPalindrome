package com.kirilanastasov.palindrome.customValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Constraint(validatedBy = PalindromeValidator.class)
public @interface CustomPalindromeValidator {
	String message() default "{Input value needs to be palindrome}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
