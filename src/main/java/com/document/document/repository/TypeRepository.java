package com.document.document.repository;

import com.document.document.domain.Services;
import com.document.document.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    public Type findBytypeDocs(String type);

}
