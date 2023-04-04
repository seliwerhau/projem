package com.projem.data;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.projem.models.weights.*;

@Repository
public class foodFakeDAO implements foodDataAccessInterface {

    List<previousFood> myFood = new ArrayList<previousFood>();
    
    public foodFakeDAO() {
        // myWeights.add(new previousWeights(0,"Squat",275,2,"13-02"));
        // myWeights.add(new previousWeights(1,"Bench Press",225,2,"13-02"));
        // myWeights.add(new previousWeights(2,"Deadlift",335,2,"13-02"));
        // myWeights.add(new previousWeights(3,"Barbell Row",170,2,"13-02"));
        // myWeights.add(new previousWeights(4,"Overhead Press",135,2,"13-02"));
    }

    @Override
    public previousFood getById(int id) {
        
        for(int i =0; i<myFood.size(); i++){
            if(myFood.get(i).getId() == id){
                return myFood.get(i);
            }
        }
        return null;
    }

    @Override
    public List<previousFood> getFood(){
        return myFood;
    }

    @Override
    public List<previousFood> searchFood(String searchTerm){
        // now we will create an empty list that will contain the items that were searched
        
        List<previousFood> foundItems = new ArrayList<previousFood>();
        
        for(int i = 0; i < myFood.size(); i++){
            if(myFood.get(i).getNameOfFood().toLowerCase().contains(searchTerm.toLowerCase())){ 
                foundItems.add(myFood.get(i));
            }
        }
        

        // another way to do searching
        //List<previousWeights> foundItems = myWeights.stream()
        //.filter(myWeights -> myWeights.getNameOfExercise().toLowerCase()
        //.contains(searchTerm.toLowerCase())).collect(Collectors.toList());
        
        return foundItems;
        
    }

    @Override
    public long addOne(previousFood newFood){
        boolean success = myFood.add(newFood);

        if(success){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean deleteOne(int id){
        for(int i =0; i<myFood.size(); i++){
            if(myFood.get(i).getId() == id){
                myFood.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public previousFood updateOne(int idToUpdate, previousFood updateFood){
        for(int i =0; i<myFood.size(); i++){
            if(myFood.get(i).getId() == idToUpdate){
                myFood.set(i,updateFood);
                return myFood.get(i);
            }
        }
        return null;
    }



}
