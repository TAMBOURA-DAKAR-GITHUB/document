package com.document.document.service.docservice;

import com.document.document.domain.Nature;

import java.util.List;

public interface NatureService {

    public Nature addNature(Nature nature);
    public List<Nature> listeNature();
    public  Nature listeById(long id);
    public Nature UpdateNature(Nature nature);
    public void deleteNature(long id);

    // la methode pour verifie si un agent existe
    public abstract boolean isNatureExist(long id);
    public Nature VerificationNature(String nature);
}
