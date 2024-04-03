package com.codelibary.www.CustomExcption;

import java.security.PublicKey;

public class MenuCatNotFoundExpection extends RuntimeException{

    public MenuCatNotFoundExpection(String message){

        super(message);
    }
}
