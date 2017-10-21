package fr.tommarx.ohgj130;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

import fr.tommarx.gameengine.Components.BoxBody;
import fr.tommarx.gameengine.Components.SpriteRenderer;
import fr.tommarx.gameengine.Components.Transform;
import fr.tommarx.gameengine.Game.AbstractGameObject;
import fr.tommarx.gameengine.Game.Game;
import fr.tommarx.gameengine.Util.Math;

public class Enemy extends AbstractGameObject {

    float speed;
    public BoxBody body;

    public Enemy(Transform transform) {
        super(transform);
        setTag("Enemy");
        if (Math.random(0, 100) >= 50) {
            addComponent(new SpriteRenderer(this, Gdx.files.internal("kim.png"), 0, 0, 1, 1));
        } else {
            addComponent(new SpriteRenderer(this, Gdx.files.internal("mexicain.png"), 0, 0, 1, 1));
        }
        body = new BoxBody(this, .5f, 1, BodyDef.BodyType.DynamicBody, false);
        addComponent(body);
        speed = Math.random(0.03f, 0.07f);
    }

    protected void drawBefore() {

    }

    protected void drawAfter() {

    }

    protected void update(float delta) {
        body.getBody().setLinearVelocity(new Vector2(-speed * 50, 0));
        if (getTransform().getPosition().x < -3) {
            Game.getCurrentScreen().add(new Enemy(new Transform(new Vector2(5 + Math.random(2, 5), .5f))));
            Game.getCurrentScreen().remove(this);
        }
    }
}
