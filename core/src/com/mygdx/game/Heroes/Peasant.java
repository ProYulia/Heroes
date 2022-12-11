package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Peasant extends Warrior {
    boolean delivery;

    public Peasant(ArrayList<Base> group, int x, int y, int pivot) {
        super(1, 1, new int[]{1,1}, 1, 3, States.ALIVE);
        super.group = group;
        delivery = true;
        super.position = new Position(x, y);
        super.texture = new Texture("Peasant.png");
    }

    @Override
    public void step(ArrayList<Base> group) {
        if (getState().equals(States.USED))
            setState(States.ALIVE);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
