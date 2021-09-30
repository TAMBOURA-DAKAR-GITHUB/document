package com.document.document.service.docservice;

import com.document.document.domain.Services;

import java.util.List;

public interface ServicesService {

    public Services addServices(Services services);
    public List<Services> listeServices();
    public  Services listeById(long id);
    public Services UpdateServices(Services services);
    public void deleteServices(long id);

    // la methode pour verifie si un agent existe
    public abstract boolean isServicesExist(long id);
    public Services VerificationServices(String service);
}
