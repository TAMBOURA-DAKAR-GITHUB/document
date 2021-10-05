package com.document.document.controller;


import com.document.document.domain.Roles;
import com.document.document.exception.InterceptionException.InterceptionExceptionSimple.RolesNotFountException;
import com.document.document.service.Impdocservice.RolesServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/document/roles")
public class RolesController {

    private RolesServiceImp rolesServiceImp;

    public RolesController(RolesServiceImp rolesServiceImp) {
        this.rolesServiceImp = rolesServiceImp;
    }

    @PostMapping(value = "/addRoles")
    public ResponseEntity<Object> addAgent(@RequestBody Roles roles) {
        String rolesexist = roles.getRoles();
        if (rolesexist != null && !"".equals(rolesexist)) {

            Roles roles1 = rolesServiceImp.VerificationRoles(rolesexist);
            if (roles1 != null) {
                throw new RolesNotFountException();
            }
        }
        try {
            roles = rolesServiceImp.addRoles(roles);
        } catch (Exception e) {
            throw new RolesNotFountException();
        }

        return new ResponseEntity<>(
                roles,
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/listeRoles")
    public ResponseEntity<Object> listeRoles() {
        List<Roles> RolesList = null;
        try {
            RolesList = rolesServiceImp.listeRoles();
        } catch (Exception e) {
            throw new RolesNotFountException();
        }

        return new ResponseEntity<>(RolesList, HttpStatus.OK);
    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id) {
        // verifier si id existe dans la base de donnee
        boolean isRolesExist = rolesServiceImp.isRolesExist(id);
        if (isRolesExist)
        {
            Roles roles = null;
            try {
                roles = rolesServiceImp.listeById(id);
            } catch (Exception e) {
                throw new RolesNotFountException();
            }

            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
        else
        {
            throw new RolesNotFountException();
        }

    }

    @PutMapping(value = "/updateRoles/{id}")
    public ResponseEntity<Object> updateRoles(@PathVariable(name = "id") long id, @RequestBody Roles roles)
    {
        boolean isRolesExist = rolesServiceImp.isRolesExist(id);
        if (isRolesExist)
        {
            try {
                roles.setIdRoles(id);
                rolesServiceImp.UpdateRoles(roles);
            }catch (Exception e){
                throw new RolesNotFountException();
            }
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
        else
        {
            throw new RolesNotFountException();
        }


    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(name = "id") long id)
    {
        boolean isRolesExist = rolesServiceImp.isRolesExist(id);
        if (isRolesExist)
        {
            try {
                rolesServiceImp.deleteRoles(id);
            }catch (Exception e){
                throw  new RolesNotFountException();
            }

            return new ResponseEntity<>("Roles Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new RolesNotFountException();
        }

    }
}
