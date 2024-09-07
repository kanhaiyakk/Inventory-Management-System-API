package com.cts.inventorymanagementsystem.exceptions;

public class ResourceNotFoungException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ResourceNotFoungException(String message) {
        super(message);
    }

}