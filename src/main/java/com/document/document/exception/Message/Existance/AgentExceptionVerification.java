package com.document.document.exception.Message.Existance;


import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.AgentExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AgentExceptionVerification
{
    @ExceptionHandler(value = AgentExistetException.class)
    public ResponseEntity<Object> exception(AgentExistetException exception)
    {
        return new ResponseEntity<>("Le Agent Existe deja ......", HttpStatus.BAD_REQUEST);
    }
}
