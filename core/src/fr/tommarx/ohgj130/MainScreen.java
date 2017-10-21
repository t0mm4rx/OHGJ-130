package fr.tommarx.ohgj130;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;

import fr.tommarx.gameengine.Collisions.CollisionsListener;
import fr.tommarx.gameengine.Collisions.CollisionsManager;
import fr.tommarx.gameengine.Components.Text;
import fr.tommarx.gameengine.Components.Transform;
import fr.tommarx.gameengine.Game.AbstractGameObject;
import fr.tommarx.gameengine.Game.Draw;
import fr.tommarx.gameengine.Game.Game;
import fr.tommarx.gameengine.Game.GameObject;
import fr.tommarx.gameengine.Game.Screen;
import fr.tommarx.gameengine.Util.Math;
import fr.tommarx.gameengine.Util.Util;

public class MainScreen extends Screen {

    Plane plane;

    int cash = 0;
    Text text;

    Sound s_cash;
    Texture background;

    float y = 0;

    public MainScreen(Game game) {
        super(game);
    }

    public void show() {
        plane = new Plane();
        add(plane);

        add(new Enemy(new Transform(new Vector2(5, .5f))));
        add(new Enemy(new Transform(new Vector2(9, .5f))));

        //Game.debugging = true;

        new CollisionsManager(new CollisionsListener() {
            public void collisionEnter(AbstractGameObject a, AbstractGameObject b, Contact contact) {
                if (Util.areGameObjectsByTag(a, b, "Bomb", "Enemy")) {
                    cash += Math.randomInt(10, 50);
                    text.setText(cash + "$");
                    s_cash.play(.7f);
                }
            }

            public void collisionEnd(AbstractGameObject a, AbstractGameObject b, Contact contact) {}
        });
        world.setGravity(new Vector2(0, 0));

        GameObject a = new GameObject(new Transform(new Vector2(4.5f, 3.8f)));
        text = new Text(a, cash + "$", Color.GREEN);
        a.addComponent(text);
        add(a);

        s_cash = Gdx.audio.newSound(Gdx.files.internal("cash.mp3"));
        background = new Texture("background.jpg");
    }

    public void renderBefore() {
        Draw.rect(Game.center.x, Game.center.y, Game.size.x, Game.size.y, Color.WHITE);
        Draw.texture(background, Game.center.x - .5f - y, Game.center.y + .5f, Game.size.x, Game.size.y);
        Draw.texture(background, Game.center.x - .5f + Game.size.x - y, Game.center.y + .5f, Game.size.x, Game.size.y);
    }

    public void renderAfter() {

    }

    public void update() {
        y += 0.01f;
        if (y > Game.size.x) {
            y = 0;
        }
    }

}
