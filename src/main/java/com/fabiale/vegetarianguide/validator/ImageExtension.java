package com.fabiale.vegetarianguide.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageExtensionValidator.class)
@Documented
public @interface ImageExtension {

	public String message() default "{com.fabiale.vegetarianguide.validator.ImageExtension.message}";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
	public String[] extension() default "";
}
