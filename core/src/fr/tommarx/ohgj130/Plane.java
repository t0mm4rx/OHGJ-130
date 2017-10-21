package fr.tommarx.ohgj130;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import fr.tommarx.gameengine.Components.SpriteRenderer;
import fr.tommarx.gameengine.Components.Transform;
import fr.tommarx.gameengine.Game.AbstractGameObject;
import fr.tommarx.gameengine.Game.Game;
import fr.tommarx.gameengine.IO.Keys;

public class Plane extends AbstractGameObject {

    float a = 0;

    public Plane() {
        super(new Transform(new Vector2(1, 3)));
        addComponent(new SpriteRenderer(this, Gdx.files.internal("plane.png"), 0, 0, 1.5f, .8f));
    }

    protected void drawBefore() {

    }

    protected void drawAfter() {

    }

    protected void update(float delta) {
        a++;
        if (Keys.isKeyJustPressed(Input.Keys.SPACE)) {
            dropBomb();
        }
        this.getTransform().setRotation((float)Math.sin(a / 10) * 2);
        this.getTransform().setPosition(new Vector2(1, 3 + (float)Math.sin(a / 10) * 0.1f));
    }

    private void dropBomb() {
        Game.getCurrentScreen().add(new Bomb(new Transform(new Vector2(1, 3))));
    }
}
