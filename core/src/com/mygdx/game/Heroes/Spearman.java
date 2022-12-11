package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Spearman extends Warrior {
    boolean delivery;
    public Spearman(ArrayList<Base> group, int x, int y, int pivot) {
        super(4, 5, new int[]{1,3}, 10, 4, States.ALIVE);
        super.group = group;
        delivery = false;
        super.position = new Position(x, y);
        super.texture = new Texture("Spearman.png");
    }



    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
