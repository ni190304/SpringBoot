package com.example.learn_spring_aop.aopexample.business;

import java.util.Arrays;
import org.springframework.stereotype.Service;

import com.example.learn_spring_aop.aopexample.data.DataService2;

@Service
public class BusinessService2 {

	private DataService2 dataService2;

	public BusinessService2(DataService2 dataService2) {
		this.dataService2 = dataService2;
	}

	public int calculateMax(){
		int[] data = dataService2.retrieveData();

		// throw new RuntimeException("Something went wrong while calculating max");

		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Arrays.stream(data).max().orElse(0);
	}



}
