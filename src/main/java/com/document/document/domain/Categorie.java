package com.document.document.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategorie;
    @Column(length = 50)
    @NotNull
    private String categorieDocs;
    @OneToMany(mappedBy = "categorie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Document> documents;

    public Categorie() {
    }

    public Categorie(String categorieDocs) {
        this.categorieDocs = categorieDocs;
    }

    public long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorieDocs() {
        return categorieDocs;
    }

    public void setCategorieDocs(String categorieDocs) {
        this.categorieDocs = categorieDocs;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }

//    @Override
//    public String toString() {
//        return "Categorie{" +
//                "idCategorie=" + idCategorie +
//                ", categorieDocs='" + categorieDocs + '\'' +
//                ", documents=" + documents +
//                '}';
//    }
}
