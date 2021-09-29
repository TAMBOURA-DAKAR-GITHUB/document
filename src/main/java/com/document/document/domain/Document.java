package com.document.document.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDocument;
    @Column(length = 100)
    @NotNull
    private String referenceDocument;
    @NotNull
    private String descriptionDocument;
    private Date dateArriveeDocument;
    // a creer par le systeme
    private Date dateCreationDocument;
    @Column(length = 50)
    @NotNull
    private String origineDocument;
    private String docfile;

    @ManyToOne
    @JoinColumn(name = "idType")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "idNature")
    private Nature nature;
    @ManyToOne
    @JoinColumn(name = "idAgent")
    private Agent agent;

    public Document() {
    }

    public Document(String referenceDocument, String descriptionDocument, Date dateArriveeDocument,
                    String origineDocument, String docfile, Type type, Categorie categorie, Nature nature, Agent agent) {
        this.referenceDocument = referenceDocument;
        this.descriptionDocument = descriptionDocument;
        this.dateArriveeDocument = dateArriveeDocument;
        this.origineDocument = origineDocument;
        this.docfile = docfile;
        this.type = type;
        this.categorie = categorie;
        this.nature = nature;
        this.agent = agent;
    }

    public long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(long idDocument) {
        this.idDocument = idDocument;
    }

    public String getReferenceDocument() {
        return referenceDocument;
    }

    public void setReferenceDocument(String referenceDocument) {
        this.referenceDocument = referenceDocument;
    }

    public String getDescriptionDocument() {
        return descriptionDocument;
    }

    public void setDescriptionDocument(String descriptionDocument) {
        this.descriptionDocument = descriptionDocument;
    }

    public Date getDateArriveeDocument() {
        return dateArriveeDocument;
    }

    public void setDateArriveeDocument(Date dateArriveeDocument) {
        this.dateArriveeDocument = dateArriveeDocument;
    }

    public Date getDateCreationDocument() {
        return dateCreationDocument;
    }

    public void setDateCreationDocument(Date dateCreationDocument) {
        this.dateCreationDocument = dateCreationDocument;
    }

    public String getOrigineDocument() {
        return origineDocument;
    }

    public void setOrigineDocument(String origineDocument) {
        this.origineDocument = origineDocument;
    }

    public String getDocfile() {
        return docfile;
    }

    public void setDocfile(String docfile) {
        this.docfile = docfile;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Document{" +
                "idDocument=" + idDocument +
                ", referenceDocument='" + referenceDocument + '\'' +
                ", descriptionDocument='" + descriptionDocument + '\'' +
                ", dateArriveeDocument=" + dateArriveeDocument +
                ", dateCreationDocument=" + dateCreationDocument +
                ", origineDocument='" + origineDocument + '\'' +
                ", docfile='" + docfile + '\'' +
                ", type=" + type +
                ", categorie=" + categorie +
                ", nature=" + nature +
                ", agent=" + agent +
                '}';
    }
}
