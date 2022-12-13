package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public abstract class Base extends Sprite implements BaseInterface {
    private int attack;
    private int protection;
    private int[] damage;
    private double health;
    private int speed;
    private double maxHealth;
    private States state;
    private static int idCounter;
    private final int playerID;
    protected ArrayList<Base> group;
    protected Position position;
    public Texture texture;
    Position destination;
    int direction;

    public Base(int attack, int protection, int[] damage, double health, int speed,  States state) {
        this.attack = attack;
        this.protection = protection;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.state = state;
        playerID = idCounter++;
        this.maxHealth = health;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    public void setState(States state) {
        this.state = state;
        System.out.println(state);
    }

    public void setDestination(Position destination) {
        this.destination = destination;
    }

    public Position getDestination() {
        if (destination == null)
            destination = position; //TODO
        return destination;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public ArrayList<Base> getGroup() {
        return group;
    }

    public States getState() {
        return state;
    }

    public int[] getDamage() {
        return damage;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(double health) {
        if (health > getMaxHealth()) this.health = maxHealth;
        else this.health = health;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public void updatePosition() {
        if (destination == null)
            destination = position;
        position.x += (destination.x - position.x)/20;
        position.y += (destination.y - position.y)/20;
    }


    public int getPlayerID() {
        return playerID;
    }

    @Override
    public String getInfo() {
        String str = state +"";
        String str2 = (int) health +"";
        return getClass().getSimpleName()  + str2+ "/" + (int) maxHealth + " " + str;
    }

    @Override
    public void step(ArrayList<Base> group) {
    }

    protected void getAttack(Base hero) {
        setState(States.ATTACK);
        hero.setState(States.HURT);
        if (attack == hero.protection && speed < position.getDist(hero.getPosition())) hero.health -=(damage[0]+damage[1])/4;
        if (attack == hero.protection) hero.health -= (damage[0]+damage[1])/2;
        if (attack > hero.protection && speed < position.getDist(hero.getPosition())) hero.health -= damage[1]/2;
        if (attack > hero.protection) hero.health -= damage[1];
        if (attack < hero.protection && speed < position.getDist(hero.getPosition())) hero.health -= damage[0]/2;
        else  hero.health -= damage[0];
        if (hero.health <= 0) {
            hero.health = 0;
            hero.setState(States.DEAD);
        }
    }




}