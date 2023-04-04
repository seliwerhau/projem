package com.projem.models.weights;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class foodMapper implements RowMapper<previousFood> {

    @Override
    public previousFood mapRow(ResultSet rs, int arg1) throws SQLException {
       
        previousFood weights = new previousFood(rs.getInt("ID"), rs.getString("NAME_OF_FOOD"), rs.getInt("WEIGHT"), rs.getInt("PROTEIN"), rs.getInt("CARB"),rs.getInt("FAT"),rs.getInt("CALORIES"));

        return weights;
    }
    
}
