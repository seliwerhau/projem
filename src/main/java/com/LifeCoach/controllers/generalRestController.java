package com.LifeCoach.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LifeCoach.models.weights.previousFood;
import com.LifeCoach.services.businessServiceInterface;


@RestController
@RequestMapping("/api/v1")
public class generalRestController {
    businessServiceInterface service;
    
    
    @Autowired
    public generalRestController(businessServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public List<previousFood> showAllWeights(){
        List<previousFood> weights = service.getFood();

        return weights;
    }


    // we are getting the data from the url
    @GetMapping("/search/{searchTermURL}")
    // we are passing that data from the url to the function
    public List<previousFood> searchsWeights(@PathVariable(name="searchTermURL") String searchTerm){
        List<previousFood> weights = service.searchFood(searchTerm);

        return weights;
    }
    
    @PostMapping("/add")
    public long addWeights(@RequestBody previousFood model){

        return service.addOne(model);
    }

    @GetMapping("/get/{id}")
    public previousFood getById(@PathVariable(name="id") int id){
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteWeights(@PathVariable(name="id") int id){
        return service.deleteOne(id);
    }


    @PutMapping("/update/{id}")
    public previousFood updateWeights(@RequestBody previousFood model, @PathVariable(name="id") int id){
        return service.updateOne(id, model);
    }


}
