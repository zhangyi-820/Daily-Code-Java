package com.example.easypoidemo.pojo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author :ZhangYi
 * @date :2021/12/3 11:54
 * @description:
 */
public class StudentNumValidator implements ConstraintValidator<StudentNumCheck, String> {
    @Override
    public void initialize(StudentNumCheck constraint) {
    }

    @Override
    public boolean isValid(String obj, ConstraintValidatorContext context) {
        try {
            Integer.parseInt(obj);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
