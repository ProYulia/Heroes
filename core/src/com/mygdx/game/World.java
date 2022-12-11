package com.mygdx.game;

import com.mygdx.game.Heroes.*;

import java.util.ArrayList;

public class World {
    public ArrayList<Base> whiteSide;
    public ArrayList<Base> darkSide;
    private Spearman spearman;

    public World() {
        this.whiteSide = new ArrayList<>();
        this.darkSide = new ArrayList<>();
        generateScene();
    }

    public Spearman getSpearman() {
        return spearman;
    }

    private void generateScene(){
        int n = 10;
        int width = 1024;
        spearman = new Spearman(whiteSide, 10, 100 + n, 1);
        whiteSide.add(spearman);
        whiteSide.add(new Monk(whiteSide, 5, 100 + n, 1));
        whiteSide.add(new Monk (whiteSide, 5, 200 + n, 1));
        whiteSide.add(new Peasant(whiteSide, 5, 300 + n, 1));
        whiteSide.add(new Spearman(whiteSide, 5, 400 + n, 1));

        darkSide.add(new Peasant(darkSide, width - n*10, 0 + n, -1));
        darkSide.add(new Wizard(darkSide, width - n*10, 100 + n, -1));
        darkSide.add(new Robber(darkSide, width - n*10, 200 + n, -1));
        darkSide.add(new Robber (darkSide, width - n*10, 300 + n, -1));
        darkSide.add(new Robber (darkSide, width - n*10, 400 + n, -1));
    }

    public void setPriority() {
        for (int i = 0; i < 5; i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Xbowman")) whiteSide.get(i).step(darkSide);
            clazz = darkSide.get(i).getClass().toString();
            if (clazz.contains("Sniper")) darkSide.get(i).step(whiteSide);
        }

        for (int i = 0; i < 5; i++) {
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
        for (int i = 0; i < 5; i++) {
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
        for (int i = 0; i < 5; i++) {
            String clazz = whiteSide.get(i).getClass().toString();
            if (clazz.contains("Peasant")) whiteSide.get(i).step(darkSide);
            if (clazz.contains("Peasant")) darkSide.get(i).step(whiteSide);
        }
    }


}
