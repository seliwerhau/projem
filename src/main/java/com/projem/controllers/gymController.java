package com.projem.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.TreeMap;
import java.util.Map;

import com.projem.models.LoginModel;
import com.projem.models.weights.previousFood;
import com.projem.services.businessServiceInterface;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import com.projem.models.weights.previousFood;

import java.util.List;
import java.util.TreeMap;

import javax.xml.validation.*;
@Controller
@RequestMapping("/form")
public class gymController {
    businessServiceInterface service;

    @Autowired
    public gymController(businessServiceInterface service){
        super();
        this.service = service;
    }

    @GetMapping("/homepage")
    public String home(Model model){
        
        return "homepage.html";
    }

    @GetMapping("/addNew")
    public String showFoodForm(Model model){

        model.addAttribute("foodObject", new previousFood());
        return "gym/addNewWeights.html"; 

    }
    @PostMapping("/information")
    public String displayLoginForm(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "login/loginResult.html";
    }   
    

    @RequestMapping("/table")
    public String addnew(@Valid previousFood newFood, BindingResult bindingResult, Model model){
        
        // add to the database
        
        service.addOne(newFood);


        // get all weights from database
        List<previousFood> foodListing = service.getFood();
        
        // show all weights
        model.addAttribute("foodListing", foodListing);
        
        return "gym/weights.html";
    }

   

    @PostMapping("/delete")
    public String deleteFood(@Valid previousFood food, BindingResult bindingResult, Model model){
        service.deleteOne(food.getId());

        List<previousFood> foodListing = service.getFood();
        model.addAttribute("foodListing", foodListing);
        return "gym/weights.html";
    }

    @GetMapping("/graph")
    public String getGraph(Model model){
        
        return "gym/graph.html";
    }

}
// TO-DO
// I need to check professors old thymeleaf videos to find where he codes the orders.html then i'm good to go for searching specific item in html page 