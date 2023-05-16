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
    private Coach anotherCoach;

   @Autowired
   public DemoController(
           @Qualifier("cricketCoach") Coach theCoach,
           @Qualifier("cricketCoach") Coach theAnotherCoach) {

       System.out.println("In constructor: "+ getClass().getSimpleName());
       myCoach= theCoach;
       anotherCoach = theAnotherCoach;
   }

    @GetMapping("/check")
       public String check(){
           return "Comparing beans: myCoach == anotterCoach, " + (this.myCoach == this.anotherCoach);
        }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return  myCoach.getDailyWorkout();
    }
}
