package com.document.document.repository.data;


import com.document.document.domain.Nature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureRepository extends JpaRepository<Nature , Long> {

    public Nature findBynatureDocs(String nature);
}
