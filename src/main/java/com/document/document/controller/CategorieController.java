package com.document.document.controller;

import com.document.document.domain.Categorie;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.CategorieNotFountException;
import com.document.document.service.Impdocservice.CategorieServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/document/categorie")
public class CategorieController {

    private CategorieServiceImp categorieServiceImp;

    public CategorieController(CategorieServiceImp categorieServiceImp) {
        this.categorieServiceImp = categorieServiceImp;
    }

    @PostMapping(value = "/addCategorie")
    public ResponseEntity<Object> addNature(@RequestBody Categorie categorie) {
        String categorieexist = categorie.getCategorieDocs();
        if (categorieexist != null && !"".equals(categorieexist)) {

            Categorie categorie1 = categorieServiceImp.VerificationCategorie(categorieexist);
            if (categorie1 != null) {
                throw new CategorieNotFountException();
            }
        }
        try {
            categorie = categorieServiceImp.addCategorie(categorie);
        } catch (Exception e) {
            throw new CategorieNotFountException();
        }

        return new ResponseEntity<>(
                categorie,
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/listeCategorie")
    public ResponseEntity<Object> listeCategorie() {
        List<Categorie> CategorieList = null;
        try {
            CategorieList = categorieServiceImp.listeCategorie();
        } catch (Exception e) {
            throw new CategorieNotFountException();
        }

        return new ResponseEntity<>(CategorieList, HttpStatus.OK);
    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id) {
        // verifier si id existe dans la base de donnee
        boolean isCategorieExist = categorieServiceImp.isCategorieExist(id);
        if (isCategorieExist)
        {
            Categorie categorie = null;
            try {
                categorie = categorieServiceImp.listeById(id);
            } catch (Exception e) {
                throw new CategorieNotFountException();
            }

            return new ResponseEntity<>(categorie, HttpStatus.OK);
        }
        else
        {
            throw new CategorieNotFountException();
        }

    }

    @PutMapping(value = "/updateCategorie/{id}")
    public ResponseEntity<Object> updateCategorie(@PathVariable(name = "id") long id, @RequestBody Categorie categorie)
    {
        boolean isCategorieExist = categorieServiceImp.isCategorieExist(id);
        if (isCategorieExist)
        {
            try {
                categorie.setIdCategorie(id);
                categorieServiceImp.UpdateCategorie(categorie);
            }catch (Exception e){
                throw new CategorieNotFountException();
            }
            return new ResponseEntity<>(categorie, HttpStatus.OK);
        }
        else
        {
            throw new CategorieNotFountException();
        }


    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(name = "id") long id)
    {
        boolean isCategorieExist = categorieServiceImp.isCategorieExist(id);
        if (isCategorieExist)
        {
            try {
                categorieServiceImp.deleteCategorie(id);
            }catch (Exception e){
                throw  new CategorieNotFountException();
            }

            return new ResponseEntity<>("categorie Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new CategorieNotFountException();
        }

    }
}
