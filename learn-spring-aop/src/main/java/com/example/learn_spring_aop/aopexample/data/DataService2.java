package com.example.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

import com.example.learn_spring_aop.aopexample.annotations.TrackTime;

@Repository
public class DataService2 {

    @TrackTime
    public int[] retrieveData() {
        // Simulate data retrieval logic
        System.out.println("Retrieving data from DataService2...");
        return new int[]{111, 222, 332, 444, 555};
    }
}
