package com.github.bookCrud.exception.customExc;

public class EntityNotFoundExc extends RuntimeException{
    public EntityNotFoundExc(String massage){
        super(massage);
    }
}
