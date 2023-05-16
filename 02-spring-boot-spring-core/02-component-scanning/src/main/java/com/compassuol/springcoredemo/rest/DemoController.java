package com.compassuol.springcoredemo.rest;

import com.compassuol.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // DEFINE A PRIVATE FIELD FOR THE DEPENDENCY

    private Coach myCoach;


    //DEFINE THE CONSTRUCTOR FOR DEPENDENCY INJECTION

    @Autowired
    public  DemoController(Coach theCoach){
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return  myCoach.getDailyWorkout();
    }
}
