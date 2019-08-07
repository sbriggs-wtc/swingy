package com.mycompany.swingy.exceptions;

import com.mycompany.swingy.model.*;
import java.util.Set;
import java.lang.Exception;
import javax.validation.*;

public class HeroValidationException extends Exception{
    private static final long serialVersionUID = 1L;
    private StringBuilder stringBuilder = new StringBuilder();
    private String message;
    public HeroValidationException(String message){
        setMessage(message);
    }
    public HeroValidationException(Set<ConstraintViolation<Hero>> constraintViolations){
        stringBuilder.append("Hero validation error(s): ");
        stringBuilder.append(constraintViolations.size());
        stringBuilder.append("\n");
        int i = 1;
        for(ConstraintViolation<Hero> violation : constraintViolations){
            stringBuilder.append(i + ") ");
            stringBuilder.append(violation.getMessage());
            stringBuilder.append(" Your setting: " + violation.getInvalidValue() + ".");
            stringBuilder.append("\n");
            i++;
        }
        setMessage(stringBuilder.toString());
    }
    @Override
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}