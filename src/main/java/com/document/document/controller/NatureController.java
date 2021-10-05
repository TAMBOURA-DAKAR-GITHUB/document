package com.document.document.controller;

import com.document.document.domain.Nature;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.NatureNotFountException;
import com.document.document.service.Impdocservice.NatureServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/document/nature")
public class NatureController {

    private NatureServiceImp natureServiceImp;

    public NatureController(NatureServiceImp natureServiceImp) {
        this.natureServiceImp = natureServiceImp;
    }

    @PostMapping(value = "/addNature")
    public ResponseEntity<Object> addNature(@RequestBody Nature nature) {
        String natureexist = nature.getNatureDocs();
        if (natureexist != null && !"".equals(natureexist)) {

            Nature nature1 = natureServiceImp.VerificationNature(natureexist);
            if (nature1 != null) {
                throw new NatureNotFountException();
            }
        }
        try {
            nature = natureServiceImp.addNature(nature);
        } catch (Exception e) {
            throw new NatureNotFountException();
        }

        return new ResponseEntity<>(
                nature,
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/listeNature")
    public ResponseEntity<Object> listeNature() {
        List<Nature> NatureList = null;
        try {
            NatureList = natureServiceImp.listeNature();
        } catch (Exception e) {
            throw new NatureNotFountException();
        }

        return new ResponseEntity<>(NatureList, HttpStatus.OK);
    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id) {
        // verifier si id existe dans la base de donnee
        boolean isNaturExist = natureServiceImp.isNatureExist(id);
        if (isNaturExist)
        {
            Nature nature = null;
            try {
                nature = natureServiceImp.listeById(id);
            } catch (Exception e) {
                throw new NatureNotFountException();
            }

            return new ResponseEntity<>(nature, HttpStatus.OK);
        }
        else
        {
            throw new NatureNotFountException();
        }

    }

    @PutMapping(value = "/updateNature/{id}")
    public ResponseEntity<Object> updateNature(@PathVariable(name = "id") long id, @RequestBody Nature nature)
    {
        boolean isNaturExist = natureServiceImp.isNatureExist(id);
        if (isNaturExist)
        {
            try {
                nature.setIdNature(id);
                natureServiceImp.UpdateNature(nature);
            }catch (Exception e){
                throw new NatureNotFountException();
            }
            return new ResponseEntity<>(nature, HttpStatus.OK);
        }
        else
        {
            throw new NatureNotFountException();
        }


    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(name = "id") long id)
    {
        boolean isNaturExist = natureServiceImp.isNatureExist(id);
        if (isNaturExist)
        {
            try {
                natureServiceImp.deleteNature(id);
            }catch (Exception e){
                throw  new NatureNotFountException();
            }

            return new ResponseEntity<>("nature Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new NatureNotFountException();
        }

    }
}
