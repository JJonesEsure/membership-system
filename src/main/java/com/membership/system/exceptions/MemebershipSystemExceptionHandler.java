package com.membership.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.membership.system.model.ErrorResponse;

@ControllerAdvice
public class MemebershipSystemExceptionHandler
{
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    @ResponseBody
    public ErrorResponse handle(final UsernameNotFoundException exception)
    {
        return new ErrorResponse().setMessage(exception.getMessage()+" please register at /auth/register");
    }
    
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler
    @ResponseBody
    public ErrorResponse handle(final Exception exception)
    {
        return new ErrorResponse().setMessage(exception.getMessage());
    }
}
