package com.example.learn_spring_framework;

import com.example.learn_spring_framework.game.GameRunner;
import com.example.learn_spring_framework.game.PacmanGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// var game = new MarioGame();
		// var game = new SuperContraGame();
		
		var game = new PacmanGame();  // 1. Object Creation and Initialization
		var gameRunner = new GameRunner(game); // 2. Object Creation and Initialization + Wiring the dependencies together
		gameRunner.run();

	}

}
