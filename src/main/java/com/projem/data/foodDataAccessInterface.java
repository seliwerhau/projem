package com.projem.data;
import java.util.List;

import com.projem.models.weights.previousFood;
public interface foodDataAccessInterface {
    
    public previousFood getById(int id);
    public List<previousFood> getFood();
    public List<previousFood> searchFood(String searchTerm);

    public long addOne(previousFood newWeights);

    public boolean deleteOne(int id);

    public previousFood updateOne(int idToUpdate, previousFood updateWeights);
    
}
