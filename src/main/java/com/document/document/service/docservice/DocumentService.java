package com.document.document.service.docservice;

import com.document.document.domain.Document;

import java.util.List;

public interface DocumentService {

    public Document addDocument(Document document);
    public List<Document> listeDocument();
    public  Document listeById(long id);
    public Document UpdateDocument(Document document);
    public void deleteDocument(long id);
    public List<Document> rechercheByCritere(long idC , long idN , long idT);

    // la methode pour verifie si un agent existe
    public abstract boolean isDocumentExist(long id);
    public Document VerificationDocument(String document);
}
