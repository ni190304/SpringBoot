package com.example.learn_spring_framework.game;

public class GameRunner {

	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running Game: "+game);
		
		game.up();
		game.down();
		game.right();
		game.left();
	}
}
