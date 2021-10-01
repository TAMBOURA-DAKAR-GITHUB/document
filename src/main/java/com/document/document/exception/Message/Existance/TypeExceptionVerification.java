package com.document.document.exception.Message.Existance;


import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.TypeExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TypeExceptionVerification
{
    @ExceptionHandler(value = TypeExistetException.class)
    public ResponseEntity<Object> exception(TypeExistetException exception)
    {
        return new ResponseEntity<>("Le type Existe deja ......", HttpStatus.BAD_REQUEST);
    }
}
