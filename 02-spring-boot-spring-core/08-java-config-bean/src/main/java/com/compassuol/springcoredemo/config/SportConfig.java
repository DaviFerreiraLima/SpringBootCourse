package com.compassuol.springcoredemo.config;

import com.compassuol.springcoredemo.common.Coach;
import com.compassuol.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
