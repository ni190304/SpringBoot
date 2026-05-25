package com.example.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MarioGameQualifier")
public class MarioGame implements GamingConsole {

	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Jump");
	}

	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Go Into a hole");
	}

	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Go back");
	}

	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Accelerate");
	}

}
