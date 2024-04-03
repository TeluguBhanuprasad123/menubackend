package com.codelibary.www.CustomExcption;

public class BusinessException extends RuntimeException {

    public BusinessException(String message, Exception e){

        super(message);
    }
}
