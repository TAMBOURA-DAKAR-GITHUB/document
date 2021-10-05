package com.document.document.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRoles;
    @Column(length = 50)
    @NotNull
    private String roles;

    @OneToMany(mappedBy = "roles")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Agent> agents;

    public Roles() {
    }

    public Roles(String roles) {
        this.roles = roles;
    }

    public long getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(long idRoles) {
        this.idRoles = idRoles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public Collection<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Collection<Agent> agents) {
        this.agents = agents;
    }

//    @Override
//    public String toString() {
//        return "Roles{" +
//                "idRoles=" + idRoles +
//                ", roles='" + roles + '\'' +
//                ", agents=" + agents +
//                '}';
//    }
}
