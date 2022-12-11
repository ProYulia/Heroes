package com.mygdx.game;

import com.mygdx.game.Heroes.*;

import java.util.ArrayList;

public class World {
    public ArrayList<Base> whiteSide;
    public ArrayList<Base> darkSide;
    private Spearman spearman_1;
    private Monk monk_1;
    private Peasant peasant_1, peasant_2;
    private Xbowman xbowman_1;
    private Wizard wizard_1;
    private Robber robber_1;
    private Sniper sniper_1;


    public World() {
        this.whiteSide = new ArrayList<>();
        this.darkSide = new ArrayList<>();
        generateScene();
    }

    public Xbowman getXbowman_1() {return xbowman_1;}
    public Wizard getWizard_1() {return wizard_1;}
    public Peasant getPeasant_1() {return peasant_1;}
    public Peasant getPeasant_2() {return peasant_2;}
    public Monk getMonk_1() {return monk_1;}
    public Spearman getSpearman() {return spearman_1;}
    public Robber getRobber_1() {return robber_1;}

    public Sniper getSniper_1() {return sniper_1;}

    private void generateScene(){
        int n = 20;
        int width = 1024;
        spearman_1 = new Spearman(whiteSide, 5, 50 + n, 1);
        whiteSide.add(spearman_1);
        monk_1 = new Monk(whiteSide, 5, 100 + n, 1);
        whiteSide.add(monk_1);
        peasant_1 = new Peasant(whiteSide, 5, 200 + n, 1);
        whiteSide.add(peasant_1);
        xbowman_1 = new Xbowman(whiteSide, 5, 300 + n, 1);
        whiteSide.add(xbowman_1);

        peasant_2 = new Peasant(darkSide, width - n*10, 50 + n, -1);
        darkSide.add(peasant_2);
        wizard_1 = new Wizard(darkSide, width - n*10, 100 + n, -1);
        darkSide.add(wizard_1);
        robber_1 = new Robber(darkSide, width - n*10, 200 + n, -1);
        darkSide.add(robber_1);
        sniper_1 = new Sniper (darkSide, width - n*10, 300 + n, -1);
        darkSide.add(sniper_1);

    }

    public void setPriority() {
        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Xbowman")) whiteSide.get(i).step(darkSide);
            clazz = darkSide.get(i).getClass().toString();
            if (clazz.contains("Sniper")) darkSide.get(i).step(whiteSide);
        }

        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Spearman")) {
                whiteSide.get(i).step(darkSide);
//				System.out.println(clazz);
            }
            clazz = darkSide.get(i).getClass().toString();
            if (clazz.contains("Robber")) {
                darkSide.get(i).step(whiteSide);
//				System.out.println(clazz);
            }
        }
        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Monk")) {
                whiteSide.get(i).step(darkSide);
//				System.out.println(clazz);
            }
            clazz = darkSide.get(i).getClass().toString();
            if (clazz.contains("Wizard")) {
                darkSide.get(i).step(whiteSide);
//				System.out.println(clazz);
            }
        }
        for (int i = 0; i < whiteSide.size(); i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Peasant")) whiteSide.get(i).step(darkSide);
            if (clazz.contains("Peasant")) darkSide.get(i).step(whiteSide);
        }
    }


}
