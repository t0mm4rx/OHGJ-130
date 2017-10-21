package fr.tommarx.ohgj130.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.tommarx.ohgj130.GameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "OHGJ #130 -- World destructor 3000 -- by t0m";
		config.width = 500;
		config.height = 400;
		new LwjglApplication(new GameClass(), config);
	}
}
