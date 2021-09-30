package com.document.document.service.docservice;

import com.document.document.domain.Roles;

import java.util.List;

public interface RolesService {

    public Roles addRoles(Roles roles);
    public List<Roles> listeRoles();
    public  Roles listeById(long id);
    public Roles UpdateRoles(Roles roles);
    public void deleteRoles(long id);

    // la methode pour verifie si un agent existe
    public abstract boolean isRolesExist(long id);
    public Roles VerificationRoles(String roles);
}
