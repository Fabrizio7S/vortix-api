package com.vortix.vortix_api.core.user.exception;

public class InvalidPasswordException  extends RuntimeException
{
    public InvalidPasswordException() {
        super("Invalid Password");
    }
}
