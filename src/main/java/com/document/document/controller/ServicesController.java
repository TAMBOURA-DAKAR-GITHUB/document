package com.document.document.controller;


import com.document.document.domain.Services;
import com.document.document.domain.Type;
import com.document.document.exception.InterceptionException.InterceptionExceptionExistance.TypeExistetException;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.ServicesNotFountException;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.TypeNotFountException;
import com.document.document.service.Impdocservice.ServicesServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/document/services")
public class ServicesController {

    private ServicesServiceImp servicesServiceImp;

    public ServicesController(ServicesServiceImp servicesServiceImp) {
        this.servicesServiceImp = servicesServiceImp;
    }

    @PostMapping(value = "/addService")
    public ResponseEntity<Object> addservice(@RequestBody Services services) {
        String serviceexist = services.getEmailService();
        if (serviceexist != null && !"".equals(serviceexist)) {

            Services services1 = servicesServiceImp.VerificationServices(serviceexist);
            if (services1 != null) {
                throw new ServicesNotFountException();
            }
        }
        try {
            services = servicesServiceImp.addServices(services);
        } catch (Exception e) {
            throw new ServicesNotFountException();
        }

        return new ResponseEntity<>(
                services,
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/listeService")
    public ResponseEntity<Object> listeService() {
        List<Services> ServicesList = null;
        try {
            ServicesList = servicesServiceImp.listeServices();
        } catch (Exception e) {
            throw new TypeNotFountException();
        }

        return new ResponseEntity<>(ServicesList, HttpStatus.OK);
    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id) {
        // verifier si id existe dans la base de donnee
        boolean isServicesExist = servicesServiceImp.isServicesExist(id);
        if (isServicesExist)
        {
            Services services = null;
            try {
                services = servicesServiceImp.listeById(id);
            } catch (Exception e) {
                throw new ServicesNotFountException();
            }

            return new ResponseEntity<>(services, HttpStatus.OK);
        }
        else
        {
            throw new ServicesNotFountException();
        }

    }

    @PutMapping(value = "/updateServices/{id}")
    public ResponseEntity<Object> updateServices(@PathVariable(name = "id") long id, @RequestBody Services services)
    {
        boolean isServicesExist = servicesServiceImp.isServicesExist(id);
        if (isServicesExist)
        {
            try {
                services.setIdService(id);
                servicesServiceImp.UpdateServices(services);
            }catch (Exception e){
                throw new TypeExistetException();
            }
            return new ResponseEntity<>(services, HttpStatus.OK);
        }
        else
        {
            throw new ServicesNotFountException();
        }

    }


    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") long id) {
        boolean isServicesExist = servicesServiceImp.isServicesExist(id);
        if (isServicesExist) {
            try {
                servicesServiceImp.deleteServices(id);
            } catch (Exception e) {
                throw new ServicesNotFountException();
            }

            return new ResponseEntity<>("services Supprimer avec success", HttpStatus.OK);
        } else {
            throw new ServicesNotFountException();
        }


    }



}
