package com.document.document.service.Impdocservice;

import com.document.document.domain.Agent;
import com.document.document.repository.Verification.VerifiactionAgent;
import com.document.document.repository.data.AgentRepository;
import com.document.document.service.docservice.AgentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImp implements AgentService {

    private AgentRepository agentRepository;
    private VerifiactionAgent verifiactionAgent;

    public AgentServiceImp(AgentRepository agentRepository, VerifiactionAgent verifiactionAgent) {
        this.agentRepository = agentRepository;
        this.verifiactionAgent = verifiactionAgent;
    }

    @Override
    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public List<Agent> listeAgent() {
        List<Agent> listeagent = agentRepository.findAll(Sort.by("idAgent").descending());
        return listeagent;
    }

    @Override
    public Agent listeById(long id) {
        return agentRepository.findById(id).get();
    }

    @Override
    public Agent UpdateAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public void deleteAgent(long id) {
       agentRepository.deleteById(id);

    }

    @Override
    public boolean isAgentExist(long id) {
        return verifiactionAgent.isAgentExist(id);
    }

    @Override
    public Agent VerificationAgent(String emil) {
        return agentRepository.findByemailAgent(emil);
    }
}
