package com.mycompany.swingy.exceptions;

import com.mycompany.swingy.model.*;
import java.util.Set;
import java.lang.Exception;
import javax.validation.*;

public class HeroValidationException extends Exception{
    private static final long serialVersionUID = 1L;
    public HeroValidationException(String message){
        super(message);
    }
    public HeroValidationException(Set<ConstraintViolation<Hero>> constraintViolations){
        for(ConstraintViolation<Hero> constraint : constraintViolations){
            //parse the CV set, create string
            System.out.println(constraint.getMessage());
        }
    }
}