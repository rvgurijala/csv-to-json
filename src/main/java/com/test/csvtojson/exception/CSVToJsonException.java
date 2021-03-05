package com.test.csvtojson.exception;

public class CSVToJsonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CSVToJsonException(String message){
        super(message);
    }

    public CSVToJsonException(String message, Throwable throwable){
        super(message, throwable);
    }
}
