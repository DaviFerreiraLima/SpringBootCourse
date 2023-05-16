package com.compassuol.springcoredemo.rest;

import com.compassuol.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // DEFINE A PRIVATE FIELD FOR THE DEPENDENCY

    private Coach myCoach;

   @Autowired
   public DemoController(
           @Qualifier("cricketCoach") Coach theCoach){

       System.out.println("In constructor: "+ getClass().getSimpleName());
       myCoach= theCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return  myCoach.getDailyWorkout();
    }
}
