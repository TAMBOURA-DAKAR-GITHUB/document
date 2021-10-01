package com.document.document.exception.Message.MessageSimple;



import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.TypeNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TypeException {

    @ExceptionHandler(value = TypeNotFountException.class)
    public ResponseEntity<Object> exception(TypeNotFountException exception)
    {
        return new ResponseEntity<>("erreur d'execution de la requete ....", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
