package com.atd.microservice.exception;

import com.atd.microservice.config.Constants;
import lombok.Getter;

@Getter
public class CartServiceException extends RuntimeException{
    private String errorMessage;
    private String message;
    private Throwable exceptionObject;
    private String baseExceptionClassName;
    private String className;
    private String methodName;
    private String errorKey;

    public CartServiceException(String aErrorMessage) {
        super(aErrorMessage);
        errorMessage = aErrorMessage;
        message = aErrorMessage;
        if (exceptionObject != null) {
                baseExceptionClassName = exceptionObject.getClass().getName().trim();
        }
    }

    public CartServiceException() {
        baseExceptionClassName = "com.atd.microservices.core.quote.service.exception.QuoteServiceException";
    }


    public CartServiceException(String aClassName, String aMethodName, Throwable aExceptionObject,
                                String aErrorKey, String aErrorMessage, String aMessage) {

        super(aErrorMessage + Constants.CHARS.COMMA + aMessage, aExceptionObject);
        className = aClassName;
        methodName = aMethodName;
        exceptionObject = aExceptionObject;
        errorKey = aErrorKey;
        errorMessage = aErrorMessage;
        message = aMessage;
        if (exceptionObject != null) {
            baseExceptionClassName = exceptionObject.getClass().getName().trim();
        }

    }
}
