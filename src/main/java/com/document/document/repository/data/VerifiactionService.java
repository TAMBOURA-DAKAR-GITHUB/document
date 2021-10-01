package com.document.document.repository.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerifiactionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isServiceExist(long id)
    {
        String sql = "SELECT COUNT(*) FROM service where  id_service =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
