package com.compassuol.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    //define our init method
        @PostConstruct
        public void doMyStartupStuff(){
            System.out.println("In the init method: "+ getClass().getSimpleName());
        }
        @PreDestroy
        public void doMyCleanupStuff(){
            System.out.println("In the cleanup method: "+ getClass().getSimpleName());
        }
    //define our destroy method
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
