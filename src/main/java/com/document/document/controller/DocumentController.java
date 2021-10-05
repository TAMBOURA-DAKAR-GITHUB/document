package com.document.document.controller;

import com.document.document.domain.Document;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.DocumentNotFountException;
import com.document.document.service.Impdocservice.DocumentServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/document/document")
public class DocumentController {

    private DocumentServiceImp documentServiceImp;

    public DocumentController(DocumentServiceImp documentServiceImp) {
        this.documentServiceImp = documentServiceImp;
    }

    @PostMapping(value = "/addDocument")
    public ResponseEntity<Object> addDocument(@RequestBody Document document) {
        String referenceexist = document.getReferenceDocument();
        if (referenceexist != null && !"".equals(referenceexist)) {

            Document document1 = documentServiceImp.VerificationDocument(referenceexist);
            if (document1 != null) {
                throw new DocumentNotFountException();
            }
        }
        try {
            document.setDateCreationDocument(new Date());
            document = documentServiceImp.addDocument(document);
            System.out.println(document.getDateCreationDocument());
        } catch (Exception e) {
            throw new DocumentNotFountException();
        }

        return new ResponseEntity<>(
                document,
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/listeDocument")
    public ResponseEntity<Object> listeRoles() {
        List<Document> DocumentList = null;
        try {
            DocumentList = documentServiceImp.listeDocument();
        } catch (Exception e) {
            throw new DocumentNotFountException();
        }

        return new ResponseEntity<>(DocumentList, HttpStatus.OK);
    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id) {
        // verifier si id existe dans la base de donnee
        boolean isDocumentExist = documentServiceImp.isDocumentExist(id);
        if (isDocumentExist) {
            Document document = null;
            try {
                document = documentServiceImp.listeById(id);
            } catch (Exception e) {
                throw new DocumentNotFountException();
            }

            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            throw new DocumentNotFountException();
        }

    }

    @PutMapping(value = "/updateDocument/{id}")
    public ResponseEntity<Object> updateDocument(@PathVariable(name = "id") long id, @RequestBody Document document) {
        boolean isDocumentExist = documentServiceImp.isDocumentExist(id);
        if (isDocumentExist) {
            try {
                document.setIdDocument(id);
                documentServiceImp.UpdateDocument(document);
            } catch (Exception e) {
                throw new DocumentNotFountException();
            }
            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            throw new DocumentNotFountException();
        }


    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") long id) {
        boolean isDocumentExist = documentServiceImp.isDocumentExist(id);
        if (isDocumentExist) {
            try {
                documentServiceImp.deleteDocument(id);
            } catch (Exception e) {
                throw new DocumentNotFountException();
            }

            return new ResponseEntity<>("Document Supprimer avec success", HttpStatus.OK);
        } else {
            throw new DocumentNotFountException();
        }

    }

    // la methode pour la recherche d'un document par nature , categorie , type
    @GetMapping(value = "/rechercheBy/{idC}/{idN}/{idT}")
    public ResponseEntity<Object> rechercheBy(@PathVariable(name = "idC") long idC, @PathVariable(name = "idN") long idN, @PathVariable(name = "idT") long idT) {
        // verifier si id existe dans la base de donnee

        List<Document> document = null;
        try {
            document = documentServiceImp.rechercheByCritere(idC, idN, idT);
            document.stream().forEach(d -> System.out.println(d));
        } catch (Exception e) {
            throw new DocumentNotFountException();
        }

        return new ResponseEntity<>(document, HttpStatus.OK);
    }


}








