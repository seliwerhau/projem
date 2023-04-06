package com.projem.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projem.models.weights.foodMapper;
import com.projem.models.weights.previousFood;



@Repository
public class foodDataService implements foodDataAccessInterface{
    // TO-DO
    // i need to figure out how to add required bean type to the JdbcTemplate and Datasource

    // // i need to create the instances of the database and connect the mysql database with my java program
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;
    

    @Override
    public long addOne(previousFood newFood) {
        long result;
        if(newFood.getNameOfFood() != null){
            result = jdbcTemplate.update("INSERT INTO WEIGHTS (NAME_OF_FOOD, WEIGHT, PROTEIN, CARB, FAT, CALORIES) VALUES (?,?,?,?,?,?)", 
        newFood.getNameOfFood(),
        newFood.getWeight(),
        newFood.getProtein(),
        newFood.getCalories(),
        newFood.getFat(),
        newFood.getCarb()
        );
        }
        else{
            result = 0;
        }
        

        return result;
        // i need to add the items 
    }
 
    @Override
    public boolean deleteOne(int id) {
        int result = jdbcTemplate.update("DELETE FROM WEIGHTS WHERE ID = ? ", id);

        if (result > 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public previousFood getById(int id) {

        List<previousFood> result =  jdbcTemplate.query("SELECT * FROM WEIGHTS WHERE ID = ?",new foodMapper(), id);
        
        if(result.size()>0){
            return result.get(0);
        }
        else{
            return null;
        }
    }
    
    @Override
    public List<previousFood> getFood() {
        List<previousFood> results =  jdbcTemplate.query("SELECT * FROM WEIGHTS", new foodMapper());
        
        return results;
        //return null;
    }

    @Override
    public List<previousFood> searchFood(String searchTerm) {
        List<previousFood> result = jdbcTemplate.query("SELECT * FROM WEIGHTS WHERE NAME_OF_FOOD LIKE ?", new foodMapper(), "%" + searchTerm + "%");

        return result;
    }


    //UPDATE DOESN'T WORK I DON'T KNOW WHY IT SAYS WRONG GRAMMAR AND TABLE WEIGHTS COULDN'T FIND
    @Override
    public previousFood updateOne(int idToUpdate, previousFood updateWeights) {
        int result =  jdbcTemplate.update("UPDATE WEIGHTS SET NAME_OF_FOOD = ?, WEIGHTS = ?, PROTEIN = ?, CARB = ?, FAT = ?, CALORIES = ? WHERE ID = ?", 
            updateWeights.getNameOfFood(),
            updateWeights.getWeight(),
            updateWeights.getProtein(),
            updateWeights.getCalories(),
            updateWeights.getFat(),
            updateWeights.getCarb(),
            idToUpdate 
        );

        if (result > 0){
            return updateWeights;
        }
        else{
            return null;
        }
    }
    
}
