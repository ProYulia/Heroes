package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Monk extends Healer {

    public Monk(ArrayList<Base> group, int x, int y, int pivot) {
        super(12, 7, new int[]{-4,-4}, 30, 5, States.ALIVE);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Wizard.png");
    }

//    public void drawMonk(Batch spriteBatch) {
//        update(Gdx.graphics.getDeltaTime());
//        super.draw(spriteBatch);
//    }
//
//    private void update(float delta) {
//        setX(position.x*delta);
//        setY(position.y*delta);
//    }

}
