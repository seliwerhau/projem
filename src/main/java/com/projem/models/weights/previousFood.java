package com.projem.models.weights;
// this class is storing our data types that we are going to put it inside of our table
// so for my table(database) i need some properties (same as django models)

public class previousFood {
    private int id;
    private String nameOfFood;
    private int weight;
    private int protein;
    private int carb;
    private int fat;
    private int calories;

    
    

   
    @Override
    public String toString() {
        
        return "previousWeights [id=" + id + ", nameOfFood=" + nameOfFood + ", weight=" + weight + ", protein="
                + protein +", calories="+ calories+ ", fat="+ fat + ", carb="+carb + " ]";
    }
    public previousFood(int id, String nameOfFood, int weight, int protein, int calories, int fat, int carb) {
        this.id = id;
        this.nameOfFood = nameOfFood;
        this.weight = weight;
        this.protein = protein;
        this.fat = fat;
        this.calories = calories;
        this.carb = carb;
        
    }
    
    public previousFood() {
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameOfFood() {
        return nameOfFood;
    }
    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getProtein() {
        return protein;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }
    public int getCarb() {
        return carb;
    }
    public void setCarb(int carb) {
        this.carb = carb;
    }

    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public int getFat() {
        return fat;
    }
    public void setFat(int fat) {
        this.fat = fat;
    }

}
