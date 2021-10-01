package com.document.document.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idType;
    @Column(length = 50)
    @NotNull
    private String typeDocs;
    @OneToMany(mappedBy = "type")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Document> documents;

    public Type() {
    }

    public Type(String typeDocs) {
        this.typeDocs = typeDocs;
    }

    public long getIdType() {
        return idType;
    }

    public void setIdType(long idType) {
        this.idType = idType;
    }

    public String getTypeDocs() {
        return typeDocs;
    }

    public void setTypeDocs(String typeDocs) {
        this.typeDocs = typeDocs;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Type{" +
                "idType=" + idType +
                ", typeDocs='" + typeDocs + '\'' +
                ", documents=" + documents +
                '}';
    }
}
