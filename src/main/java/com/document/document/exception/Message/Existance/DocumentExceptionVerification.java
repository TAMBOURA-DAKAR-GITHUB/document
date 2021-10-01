package com.document.document.exception.Message.Existance;


import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.DocumentExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class DocumentExceptionVerification
{
    @ExceptionHandler(value = DocumentExistetException.class)
    public ResponseEntity<Object> exception(DocumentExistetException exception)
    {
        return new ResponseEntity<>("Le Document Existe deja ......", HttpStatus.BAD_REQUEST);
    }
}
