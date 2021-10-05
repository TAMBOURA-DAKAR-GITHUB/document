package com.document.document.repository.Verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerifiactionRoles {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isRolesExist(long id)
    {
        String sql = "SELECT COUNT(*) FROM roles where  id_roles =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
