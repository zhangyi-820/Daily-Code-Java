package com.example.easypoidemo.pojo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :ZhangYi
 * @date :2021/12/3 11:50
 * @description:自定义学号校验器
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudentNumValidator.class)
public @interface StudentNumCheck {
    String message() default "学号格式错误";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
