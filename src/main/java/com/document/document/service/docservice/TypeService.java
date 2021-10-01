package com.document.document.service.docservice;

import com.document.document.domain.Type;

import java.util.List;

public interface TypeService {

    public Type addTypes(Type type);
    public List<Type> listeType();
    public  Type listeById(long id);
    public Type UpdateType(Type type);
    public void deleteType(long id);

    // la methode pour verifie si un agent existe
    public abstract boolean isTypeExist(long id);
    public Type VerificationType(String type);
}
