package com.example.BE_Tinder_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeTinderAppApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(BeTinderAppApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
