package com.document.document.service.Impdocservice;

import com.document.document.domain.Roles;
import com.document.document.repository.Verification.VerifiactionRoles;
import com.document.document.repository.data.RolesRepository;
import com.document.document.service.docservice.RolesService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImp implements RolesService {

    private RolesRepository rolesRepository;
    private VerifiactionRoles verifiactionRoles;

    public RolesServiceImp(RolesRepository rolesRepository, VerifiactionRoles verifiactionRoles) {
        this.rolesRepository = rolesRepository;
        this.verifiactionRoles = verifiactionRoles;
    }

    @Override
    public Roles addRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public List<Roles> listeRoles() {
        return rolesRepository.findAll(Sort.by("idRoles").descending());
    }

    @Override
    public Roles listeById(long id) {
        return rolesRepository.findById(id).get();
    }

    @Override
    public Roles UpdateRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void deleteRoles(long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public boolean isRolesExist(long id) {
        return verifiactionRoles.isRolesExist(id);
    }

    @Override
    public Roles VerificationRoles(String roles) {
        return rolesRepository.findByRoles(roles);
    }
}
