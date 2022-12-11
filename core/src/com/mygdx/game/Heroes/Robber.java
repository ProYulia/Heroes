package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Robber extends Warrior {
    boolean delivery;
    public Robber(ArrayList<Base> group, int x, int y, int pivot) {
        super(8, 3, new int[]{2,4}, 10, 6, States.ALIVE);
        super.group = group;
        delivery = false;
        super.position = new Position(x, y);
        super.texture = new Texture("Wizard.png");
    }


    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
