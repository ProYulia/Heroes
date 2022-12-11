package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Sniper extends Shooter {

    public Sniper(ArrayList<Base> group, int x, int y, int pivot) {
        super(12, 10, new int[]{8,10}, 15, 9, States.ALIVE, 32);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Sniper.png");
    }


    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
