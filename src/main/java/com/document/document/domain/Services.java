package com.document.document.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Services implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idService;
    @Column(length = 50)
    @NotNull
    private String nomService;
    @Column(length = 50)
    @NotNull
    private String telephoneService;
    @Column(length = 100)
    @NotNull
    private String emailService;
    @Column(length = 50)
    @NotNull
    private String quartierService;

    @OneToMany(mappedBy = "services")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Agent> agents;


    public Services() {
    }

    public Services(String nomService, String telephoneService, String emailService, String quartierService) {
        this.nomService = nomService;
        this.telephoneService = telephoneService;
        this.emailService = emailService;
        this.quartierService = quartierService;
    }

    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getTelephoneService() {
        return telephoneService;
    }

    public void setTelephoneService(String telephoneService) {
        this.telephoneService = telephoneService;
    }

    public String getEmailService() {
        return emailService;
    }

    public void setEmailService(String emailService) {
        this.emailService = emailService;
    }

    public String getQuartierService() {
        return quartierService;
    }

    public void setQuartierService(String quartierService) {
        this.quartierService = quartierService;
    }

    public Collection<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Collection<Agent> agents) {
        this.agents = agents;
    }

//    @Override
//    public String toString() {
//        return "Services{" +
//                "idService=" + idService +
//                ", nomService='" + nomService + '\'' +
//                ", telephoneService='" + telephoneService + '\'' +
//                ", emailService='" + emailService + '\'' +
//                ", quartierService='" + quartierService + '\'' +
//                ", agents=" + agents +
//                '}';
//    }
}
