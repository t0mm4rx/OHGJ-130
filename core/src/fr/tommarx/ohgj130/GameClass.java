package fr.tommarx.ohgj130;

import fr.tommarx.gameengine.Game.Game;

public class GameClass extends Game {

	public void init() {
		setScreen(new MainScreen(this));
	}
}
