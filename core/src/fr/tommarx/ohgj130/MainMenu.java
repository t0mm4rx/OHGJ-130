package fr.tommarx.ohgj130;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.tommarx.gameengine.Components.Text;
import fr.tommarx.gameengine.Components.Transform;
import fr.tommarx.gameengine.Game.Draw;
import fr.tommarx.gameengine.Game.Game;
import fr.tommarx.gameengine.Game.GameObject;
import fr.tommarx.gameengine.Game.Screen;
import fr.tommarx.gameengine.IO.Keys;

public class MainMenu extends Screen {

    Texture background;
    GameObject text;

    public MainMenu(Game game) {
        super(game);
    }

    public void show() {
        background = new Texture("cover.png");
        text = new GameObject(new Transform(new Vector2(1.5f, 1)));
        text.addComponent(new Text(text, "Press space to destroy the world", Color.WHITE));
        add(text);
    }

    public void renderBefore() {
        Draw.texture(background, Game.center.x - .5f, Game.center.y);
    }

    public void renderAfter() {

    }

    public void update() {
        if (Keys.isKeyJustPressed(Input.Keys.SPACE)) {
            setScreen(new MainScreen(this.game));
        }
    }

}
