package com.projem.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.projem.models.weights.previousFood;
import com.projem.data.*;


// it only tells data layer to do something 
public class businessService implements businessServiceInterface {

    @Autowired
    foodDataAccessInterface foodDAO;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<previousFood> getFood() {
        // TODO Auto-generated method stub
        return foodDAO.getFood();
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void test() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long addOne(previousFood newFood) {
        
        return foodDAO.addOne(newFood); 
    }

    @Override
    public boolean deleteOne(int id) {
        return foodDAO.deleteOne(id);
    }

    @Override
    public previousFood getById(int id) {
        return foodDAO.getById(id);
    }

    @Override
    public List<previousFood> searchFood(String searchTerm) {
        // TODO Auto-generated method stub
        return foodDAO.searchFood(searchTerm);
    }

    @Override
    public previousFood updateOne(int idToUpdate, previousFood updateFood) {
        return foodDAO.updateOne(idToUpdate, updateFood);
    }
    
}
