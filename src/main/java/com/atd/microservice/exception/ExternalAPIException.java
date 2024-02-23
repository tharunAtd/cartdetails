package com.atd.microservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalAPIException extends CartServiceException {
    private static final long serialVersionUID = 2747603756066356734L;

    public ExternalAPIException(String aClassName, String aMethodName, Throwable aExceptionObject, String aErrorKey,
                                String aErrorMessage, String aMessage) {
        super(aClassName, aMethodName, aExceptionObject, aErrorKey, aErrorMessage, aMessage);

    }
}
