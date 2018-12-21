package com.evaluateApisBcolinad.restfulApis.Exceptions;
public class CustomException {

    private String message;

    public CustomException(){}

    public CustomException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
