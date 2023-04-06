package com.projem.services;
import java.util.List;

import com.projem.models.weights.*;
public interface businessServiceInterface {
    
    public void test();


    public void init();
    public void destroy();

    public previousFood getById(int id);
    public List<previousFood> getFood();
    public List<previousFood> searchFood(String searchTerm);

    public long addOne(previousFood newWeights);

    public boolean deleteOne(int id);

    public previousFood updateOne(int idToUpdate, previousFood updateWeights);
    
}
