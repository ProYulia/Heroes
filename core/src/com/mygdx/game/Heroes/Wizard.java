package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Wizard extends Healer {
    public Wizard(ArrayList<Base> group, int x, int y, int pivot) {
        super(17, 12, new int[]{-5,-5}, 30, 9, States.ALIVE);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Wizard.png");
    }

}
