package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameAnimation;

import java.util.ArrayList;

public class Spearman extends Warrior {
    boolean delivery;
    GameAnimation currentAnimation;
    public Spearman(ArrayList<Base> group, int x, int y, int pivot) {
        super(4, 5, new int[]{1,3}, 10, 4, States.ALIVE);
        super.group = group;
        delivery = false;
        super.position = new Position(x, y);
        super.texture = new Texture("Spearman.png");
    }

    public TextureRegion getSpearmanTexture() {
        if (currentAnimation == null || currentAnimation.isFinished()) {
            switch (getState()) {
                case ALIVE:
                    currentAnimation = Assets.spearmanStandingAnimation;
                    break;
                case DEAD:
                    currentAnimation = Assets.spearmanDyingAnimation;
                    break;
                case ATTACK:
                    currentAnimation = Assets.spearmanAttackingAnimation;
                    break;

            }
        }
        return currentAnimation.getFrame();
    }

    public GameAnimation getCurrentAnimation() {
        return currentAnimation;
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
