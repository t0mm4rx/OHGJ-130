package fr.tommarx.ohgj130;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;

import fr.tommarx.gameengine.Collisions.CollisionsListener;
import fr.tommarx.gameengine.Collisions.CollisionsManager;
import fr.tommarx.gameengine.Components.BoxBody;
import fr.tommarx.gameengine.Components.SpriteRenderer;
import fr.tommarx.gameengine.Components.Transform;
import fr.tommarx.gameengine.Game.AbstractGameObject;
import fr.tommarx.gameengine.Game.Game;
import fr.tommarx.gameengine.Util.Util;

public class Bomb extends AbstractGameObject {

    BoxBody body;

    public Bomb(Transform transform) {
        super(transform);
        addComponent(new SpriteRenderer(this, Gdx.files.internal("nuke.png"), 0, 0, 0.3f, .3f));
        body = new BoxBody(this, .3f, .3f, BodyDef.BodyType.DynamicBody.DynamicBody, false);
        addComponent(body);
        setTag("Bomb");
    }

    protected void drawBefore() {

    }

    protected void drawAfter() {

    }

    protected void update(float delta) {
        //this.getTransform().setRotation(this.getTransform().getRotation() + (90 - this.getTransform().getRotation() / 10));
        //this.getTransform().getPosition().add(0, -0.1f);
        body.getBody().setLinearVelocity(new Vector2(0, -5f));
        if (this.getTransform().getPosition().y < -5) {
            Game.getCurrentScreen().remove(this);
        }
    }
}
