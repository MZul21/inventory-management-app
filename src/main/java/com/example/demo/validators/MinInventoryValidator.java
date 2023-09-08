package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinInventoryValidator implements ConstraintValidator<ValidMinInventory, Part> {
    @Autowired
    private ApplicationContext applicationContext;

    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidMinInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        boolean isValid = part.getInv() >= part.getMinVal();
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode( "minVal" ).addConstraintViolation();
        }
        return isValid;
    }
}