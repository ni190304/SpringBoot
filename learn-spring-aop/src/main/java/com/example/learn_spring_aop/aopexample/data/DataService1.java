package com.example.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        // Simulate data retrieval logic
        System.out.println("Retrieving data from DataService1...");
        return new int[]{11, 22, 33, 44, 57};
    }
}
