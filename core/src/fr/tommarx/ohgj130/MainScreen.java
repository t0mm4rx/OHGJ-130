package fr.tommarx.ohgj130;

import com.badlogic.gdx.graphics.Color;

import fr.tommarx.gameengine.Game.Draw;
import fr.tommarx.gameengine.Game.Game;
import fr.tommarx.gameengine.Game.Screen;

public class MainScreen extends Screen {

    public MainScreen(Game game) {
        super(game);
    }

    public void show() {

    }

    public void renderBefore() {
        Draw.rect(Game.center.x, Game.center.y, Game.size.x, Game.size.y, Color.WHITE);
    }

    public void renderAfter() {

    }

    public void update() {

    }

}
