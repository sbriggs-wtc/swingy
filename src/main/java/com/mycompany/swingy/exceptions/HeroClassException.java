package com.mycompany.swingy.exceptions;

import java.lang.Exception;

public class HeroClassException extends Exception{
    private static final long serialVersionUID = 1L;
    public HeroClassException(String message) {
        super(message);
    }
}