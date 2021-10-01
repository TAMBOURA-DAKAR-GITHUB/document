package com.document.document.exception.Message.Existance;


import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.RolesExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RolesExceptionVerification
{
    @ExceptionHandler(value = RolesExistetException.class)
    public ResponseEntity<Object> exception(RolesExistetException exception)
    {
        return new ResponseEntity<>("Le Roles Existe deja ......", HttpStatus.BAD_REQUEST);
    }
}
