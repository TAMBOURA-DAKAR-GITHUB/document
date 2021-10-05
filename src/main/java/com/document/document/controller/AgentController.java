package com.document.document.controller;

import com.document.document.domain.Agent;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.AgentNotFountException;
import com.document.document.service.Impdocservice.AgentServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/document/agent")
public class AgentController {

    private AgentServiceImp agentServiceImp;

    public AgentController(AgentServiceImp agentServiceImp) {
        this.agentServiceImp = agentServiceImp;
    }

    @PostMapping(value = "/addAgent")
    public ResponseEntity<Object> addAgent(@RequestBody Agent agent) {
        String agentexist = agent.getEmailAgent();
        if (agentexist != null && !"".equals(agentexist)) {

            Agent agent1 = agentServiceImp.VerificationAgent(agentexist);
            if (agent1 != null) {
                throw new AgentNotFountException();
            }
        }
        try {
            agent = agentServiceImp.addAgent(agent);
        } catch (Exception e) {
            throw new AgentNotFountException();
        }

        return new ResponseEntity<>(
                agent,
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/listeAgent")
    public ResponseEntity<Object> listeAgent() {
        List<Agent> AgentList = null;
        try {
            AgentList = agentServiceImp.listeAgent();
        } catch (Exception e) {
            throw new AgentNotFountException();
        }

        return new ResponseEntity<>(AgentList, HttpStatus.OK);
    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id) {
        // verifier si id existe dans la base de donnee
        boolean isAgentExist = agentServiceImp.isAgentExist(id);
        if (isAgentExist)
        {
            Agent agent = null;
            try {
                agent = agentServiceImp.listeById(id);
            } catch (Exception e) {
                throw new AgentNotFountException();
            }

            return new ResponseEntity<>(agent, HttpStatus.OK);
        }
        else
        {
            throw new AgentNotFountException();
        }

    }

    @PutMapping(value = "/updateAgent/{id}")
    public ResponseEntity<Object> updateAgent(@PathVariable(name = "id") long id, @RequestBody Agent agent)
    {
        boolean isAgentExist = agentServiceImp.isAgentExist(id);
        if (isAgentExist)
        {
            try {
                agent.setIdAgent(id);
                agentServiceImp.UpdateAgent(agent);
            }catch (Exception e){
                throw new AgentNotFountException();
            }
            return new ResponseEntity<>(agent, HttpStatus.OK);
        }
        else
        {
            throw new AgentNotFountException();
        }


    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(name = "id") long id)
    {
        boolean isAgentExist = agentServiceImp.isAgentExist(id);
        if (isAgentExist)
        {
            try {
                agentServiceImp.deleteAgent(id);
            }catch (Exception e){
                throw  new AgentNotFountException();
            }

            return new ResponseEntity<>("agent Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new AgentNotFountException();
        }

    }
}
