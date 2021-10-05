package com.document.document.repository.Verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerifiactionDocument {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isDocumentExist(long id)
    {
        String sql = "SELECT COUNT(*) FROM document where  id_categorie =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
