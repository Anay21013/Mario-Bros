package com.mygdx.testgame.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.testgame.MarioBros;
import com.mygdx.testgame.Screens.PlayScreen;

public class Mario extends Sprite {
    private TextureRegion marioStand;
    public World world;
    public Body b2body;
    public Mario(World world,PlayScreen screen){
        super(screen.getAtlas().findRegion("little_mario"));
        this.world = world;
        defineMario();
        marioStand = new TextureRegion(getTexture(), 0, 0, 16, 16);
        setBounds(0,0,16/MarioBros.PPM,16/MarioBros.PPM);
        setRegion(marioStand);
    }
    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32/MarioBros.PPM,32/MarioBros.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/MarioBros.PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
