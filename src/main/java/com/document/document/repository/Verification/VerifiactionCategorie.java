package com.document.document.repository.Verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerifiactionCategorie {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isCategorieExist(long id)
    {
        String sql = "SELECT COUNT(*) FROM categorie where  id_categorie =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
