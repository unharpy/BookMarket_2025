package kr.ac.kopo.minn.bookmarket.vaildator;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BookIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BookId {
    String message() default "";       // 필수속성들 message, groups, payload
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
