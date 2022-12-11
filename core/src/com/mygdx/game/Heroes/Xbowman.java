package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Xbowman extends Shooter {


    public Xbowman(ArrayList<Base> group, int x, int y, int pivot) {
        super(6, 3, new int[]{2,3}, 10, 4, States.ALIVE, 16);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Xbowman.png");
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
