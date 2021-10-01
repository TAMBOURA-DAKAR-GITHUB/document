package com.document.document.repository.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerifiactionType {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isTypeExist(long id)
    {
        String sql = "SELECT COUNT(*) FROM type where  id_Type =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
