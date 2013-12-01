package org.agoncal.book.javaee7.chapter03.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.agoncal.book.javaee7.chapter03.validator.ZipCodeValidator;

@Constraint(validatedBy = ZipCodeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
		ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {
	String message() default "{org.agoncal.book.javaee7.chapter03.ZipCode.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.METHOD, ElementType.FIELD,
			ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
			ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		ZipCode[] value();
	}
}
