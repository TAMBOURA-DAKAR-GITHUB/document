package com.document.document.exception.Message.Existance;


import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.NatureExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class NatureExceptionVerification
{
    @ExceptionHandler(value = NatureExistetException.class)
    public ResponseEntity<Object> exception(NatureExistetException exception)
    {
        return new ResponseEntity<>("Le Nature Existe deja ......", HttpStatus.BAD_REQUEST);
    }
}
