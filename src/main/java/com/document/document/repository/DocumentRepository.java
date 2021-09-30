package com.document.document.repository;

import com.document.document.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document , Long> {

    public Document findByCategorieIdCategorieAndNatureIdNatureAndTypeIdType(long idC , long idN , long idT);
//    public List<Document> findByNatureIdNature(long id);
//    public List<Document> findByTypeIdType(long id);

    public  Document findByreferenceDocument(String reference);
}
