package com.document.document.repository.dataverification;

import com.document.document.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent , Long> {

    public Agent findByemailAgent(String mail);

}