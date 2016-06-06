package com.wr.unit.admin.web.exception;

/**
 * Created by wangrui on 2015/4/22.
 */
public class RegistrationException extends RuntimeException  {
    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException() {
        super();
    }
}
