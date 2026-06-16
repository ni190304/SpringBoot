package com.example.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {

    public void up() {
		// TODO Auto-generated method stub
		System.out.println("Go up");
	}

	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Go down");
	}

	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Go right");
	}

	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Go left");
	}
}
