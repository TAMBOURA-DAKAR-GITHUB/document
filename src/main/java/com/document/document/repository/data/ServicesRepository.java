package com.document.document.repository.data;

import com.document.document.domain.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services , Long> {

    public Services findByemailService(String email);
}
