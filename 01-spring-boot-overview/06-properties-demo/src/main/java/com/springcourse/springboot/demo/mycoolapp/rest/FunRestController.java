package com.springcourse.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "hello world"

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach:" + coachName + ", Team name: "+ teamName;
    }

    @GetMapping ("/")
    public String sayHello() {
        return "Hello world";
    }


    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Ruan a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return  "Today is your lucky day.";
    }
}

    //expose a new endpoint for "workout"


