package com.document.document.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgent;
    @Column(length = 50)
    @NotNull
    private String nomAgent;
    @Column(length = 50)
    @NotNull
    private String prenomAgent;
    @Column(length = 50)
    @NotNull
    private String adresseAgent;
    @Column(length = 50)
    @NotNull
    private String sexeAgent;
    @Column(length = 100)
    @NotNull
    private String emailAgent;
    @Column(length = 50)
    @NotNull
    private String passwordAgent;
    private boolean etatAgent;

    @ManyToOne
    @JoinColumn(name = "idService")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "idRoles")
    private Roles roles;

    public Agent() {
    }

    public Agent(String nomAgent, String prenomAgent, String adresseAgent, String sexeAgent,
                 String emailAgent, String passwordAgent, boolean etatAgent, Services services, Roles roles) {
        this.nomAgent = nomAgent;
        this.prenomAgent = prenomAgent;
        this.adresseAgent = adresseAgent;
        this.sexeAgent = sexeAgent;
        this.emailAgent = emailAgent;
        this.passwordAgent = passwordAgent;
        this.etatAgent = etatAgent;
        this.services = services;
        this.roles = roles;
    }

    public long getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(long idAgent) {
        this.idAgent = idAgent;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public void setNomAgent(String nomAgent) {
        this.nomAgent = nomAgent;
    }

    public String getPrenomAgent() {
        return prenomAgent;
    }

    public void setPrenomAgent(String prenomAgent) {
        this.prenomAgent = prenomAgent;
    }

    public String getAdresseAgent() {
        return adresseAgent;
    }

    public void setAdresseAgent(String adresseAgent) {
        this.adresseAgent = adresseAgent;
    }

    public String getSexeAgent() {
        return sexeAgent;
    }

    public void setSexeAgent(String sexeAgent) {
        this.sexeAgent = sexeAgent;
    }

    public String getEmailAgent() {
        return emailAgent;
    }

    public void setEmailAgent(String emailAgent) {
        this.emailAgent = emailAgent;
    }

    public String getPasswordAgent() {
        return passwordAgent;
    }

    public void setPasswordAgent(String passwordAgent) {
        this.passwordAgent = passwordAgent;
    }

    public boolean isEtatAgent() {
        return etatAgent;
    }

    public void setEtatAgent(boolean etatAgent) {
        this.etatAgent = etatAgent;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "idAgent=" + idAgent +
                ", nomAgent='" + nomAgent + '\'' +
                ", prenomAgent='" + prenomAgent + '\'' +
                ", adresseAgent='" + adresseAgent + '\'' +
                ", sexeAgent='" + sexeAgent + '\'' +
                ", emailAgent='" + emailAgent + '\'' +
                ", passwordAgent='" + passwordAgent + '\'' +
                ", etatAgent=" + etatAgent +
                ", services=" + services +
                ", roles=" + roles +
                '}';
    }
}
