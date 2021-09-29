package com.document.document.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Nature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNature;
    @Column(length = 50)
    @NotNull
    private String natureDocs;
    @OneToMany(mappedBy = "nature")
    private Collection<Document> documents;

    public Nature() {
    }

    public Nature(String natureDocs) {
        this.natureDocs = natureDocs;
    }

    public long getIdNature() {
        return idNature;
    }

    public void setIdNature(long idNature) {
        this.idNature = idNature;
    }

    public String getNatureDocs() {
        return natureDocs;
    }

    public void setNatureDocs(String natureDocs) {
        this.natureDocs = natureDocs;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Nature{" +
                "idNature=" + idNature +
                ", natureDocs='" + natureDocs + '\'' +
                ", documents=" + documents +
                '}';
    }
}
