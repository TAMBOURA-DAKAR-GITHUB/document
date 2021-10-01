package com.document.document.exception.Message.Existance;


import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.CategorieExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CategorieExceptionVerification
{
    @ExceptionHandler(value = CategorieExistetException.class)
    public ResponseEntity<Object> exception(CategorieExistetException exception)
    {
        return new ResponseEntity<>("Le Categorie Existe deja ......", HttpStatus.BAD_REQUEST);
    }
}
