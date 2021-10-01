package com.document.document.exception.Message.Existance;


import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.ServicesExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ServicesExceptionVerification
{
    @ExceptionHandler(value = ServicesExistetException.class)
    public ResponseEntity<Object> exception(ServicesExistetException exception)
    {
        return new ResponseEntity<>("Le Services Existe deja ......", HttpStatus.BAD_REQUEST);
    }
}
