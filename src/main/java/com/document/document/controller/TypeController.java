package com.document.document.controller;

import com.document.document.domain.Type;
import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.TypeExistetException;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.TypeNotFountException;
import com.document.document.service.Impdocservice.TypeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/document")
public class TypeController {

    private TypeServiceImp typeServiceImp;

    public TypeController(TypeServiceImp typeServiceImp) {
        this.typeServiceImp = typeServiceImp;
    }

    @PostMapping(value = "/addType")
    public ResponseEntity<Type> addType(@RequestBody Type type) {
        String typeexist = type.getTypeDocs();
        if (typeexist != null && !"".equals(typeexist)) {

            Type type1 = typeServiceImp.VerificationType(typeexist);
            if (type1 != null) {
                throw new TypeNotFountException();
            }
        }
        try {
            type = typeServiceImp.addTypes(type);
        } catch (Exception e) {
            throw new TypeNotFountException();
        }

        return new ResponseEntity<>(
                type,
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/listeType")
    public ResponseEntity<Object> listeType() {
        List<Type> TypeList = null;
        try {
            TypeList = typeServiceImp.listeType();
        } catch (Exception e) {
            throw new TypeNotFountException();
        }

        return new ResponseEntity<>(TypeList, HttpStatus.OK);
    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id) {
        // verifier si id existe dans la base de donnee
        boolean isTypeExist = typeServiceImp.isTypeExist(id);
        if (isTypeExist)
        {
        Type type = null;
        try {
            type = typeServiceImp.listeById(id);
        } catch (Exception e) {
            throw new TypeNotFountException();
        }

        return new ResponseEntity<>(type, HttpStatus.OK);
    }
        else
        {
            throw new

    TypeNotFountException();
    }

    }

    @PutMapping(value = "/updateType/{id}")
    public ResponseEntity<Object> updateType(@PathVariable(name = "id") long id, @RequestBody Type type)
    {
        boolean isTypeExist = typeServiceImp.isTypeExist(id);
        if (isTypeExist)
        {
            try {
                type.setIdType(id);
                typeServiceImp.UpdateType(type);
            }catch (Exception e){
                throw new TypeExistetException();
            }
            return new ResponseEntity<>(type, HttpStatus.OK);
        }
        else
        {
            throw new TypeNotFountException();
        }


    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(name = "id") long id)
    {
        boolean isTypeExist = typeServiceImp.isTypeExist(id);
        if (isTypeExist)
        {
            try {
                typeServiceImp.deleteType(id);
            }catch (Exception e){
                throw  new TypeNotFountException();
            }

            return new ResponseEntity<>("le type Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new TypeNotFountException();
        }

    }




















}
