package com.document.document.repository;


import com.document.document.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie , Long> {

    public Categorie findBycategorieDocs(String categorie);
}
