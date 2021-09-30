package com.document.document.service.docservice;

import com.document.document.domain.Categorie;

import java.util.List;

public interface CategorieService {

    public Categorie addCategorie(Categorie categorie);
    public List<Categorie> listeCategorie();
    public  Categorie listeById(long id);
    public Categorie UpdateCategorie(Categorie categorie);
    public void deleteCategorie(long id);

    // la methode pour verifie si un agent existe
    public abstract boolean isCategorieExist(long id);
    public Categorie VerificationCategorie(String categorie);
}
