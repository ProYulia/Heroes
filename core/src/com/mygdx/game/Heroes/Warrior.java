package com.mygdx.game.Heroes;

import java.util.ArrayList;

public class Warrior extends Base {
    public Warrior(int attack, int protection, int[] damage, double health, int speed, States state) {
        super(attack, protection, damage, health, speed, state);
    }
    private Base findAim(ArrayList<Base> enemies) {
        float minDistance = Float.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getState() == States.DEAD) continue;
            float distance = getPosition().getDist(enemies.get(i).getPosition());
            if (minDistance > distance) {
                minDistance = distance;
                index = i;
            }
        }
        System.out.println(getClass().getSimpleName() + "->" + enemies.get(index).getClass().getSimpleName());//
        return enemies.get(index);
    }

    @Override
    public void step(ArrayList<Base> enemies) {
        if (getState().equals(States.DEAD)) return;

        Base aim = findAim(enemies);
        if (getPosition().getDist(aim.getPosition()) < 190) getAttack(aim);
        else move(enemies, aim);
    }
    private void move(ArrayList<Base> enemies, Base aim) {
        int x = getPosition().x;
        int y = getPosition().y;

        if (aim.getPosition().y > y && checkPosition(new Position(x, y+100)) && (y+100 < 1025))
            setPosition(new Position(x, y+100));
        if (aim.getPosition().y < y && checkPosition(new Position(x, y-100)) && (y-100 > 0))
            setPosition(new Position(x, y-100));
        if (aim.getPosition().x > x && checkPosition(new Position(x+100, y)) && (x+100 < 1025))
            setPosition(new Position(x+100, y));
        if ((aim.getPosition().x < x) && (checkPosition(new Position(x-100, y))) && (x-100 > 0))
            setPosition(new Position(x-100, y));
    }

    private boolean checkPosition(Position pos) {
        for (Base base : getGroup()) {
            if (pos.isEqual(base.getPosition()) && base.getState() != States.DEAD)
                return false;
        }
        return true;
    }
}
