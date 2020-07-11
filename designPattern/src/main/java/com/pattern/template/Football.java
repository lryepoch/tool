package com.pattern.template;

public class Football extends Game {

	@Override
	void initialize() {
		System.out.println("football Game Initialized !Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("football Game Started.Enjoy the game");
	}

	@Override
	void endPlay() {
		System.out.println("football Game Finished");
	}
}
