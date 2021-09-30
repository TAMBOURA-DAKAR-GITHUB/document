package com.document.document.service.docservice;

import com.document.document.domain.Agent;

import java.util.List;

public interface AgentService {

    public Agent addAgent(Agent agent);
    public List<Agent> listeAgent();
    public  Agent listeById(long id);
    public Agent UpdateAgent(Agent agent);
    public void deleteAgent(long id);

    // la methode pour verifie si un agent existe
    public abstract boolean isAgentExist(long id);
    public Agent VerificationAgent(String emil);
}
