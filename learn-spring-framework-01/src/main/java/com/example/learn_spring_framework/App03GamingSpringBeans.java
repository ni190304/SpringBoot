package com.example.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.learn_spring_framework.game.GameRunner;
import com.example.learn_spring_framework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

		context.getBean(GamingConsole.class).up();

		context.getBean(GameRunner.class).run();

		// var game = new MarioGame();
		// var game = new SuperContraGame();
		// var game = new PacmanGame();
		// var gameRunner = new GameRunner(game);
		// gameRunner.run();

	}

}
