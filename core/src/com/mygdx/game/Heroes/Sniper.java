package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameAnimation;

import java.util.ArrayList;

public class Sniper extends Shooter {
    GameAnimation currentAnimation;

    public Sniper(ArrayList<Base> group, int x, int y, int pivot) {
        super(12, 10, new int[]{8,10}, 15, 9, States.ALIVE, 32);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Sniper.png");
    }
    public TextureRegion getSniperTexture() {
        if (currentAnimation == null || currentAnimation.isFinished()) {
            switch (getState()) {
                case ALIVE:
                    currentAnimation = Assets.sniperStandingAnimation;
                    break;
                case DEAD:
                    currentAnimation = Assets.sniperDyingAnimation;
                    break;
                case ATTACK:
                    currentAnimation = Assets.sniperAttackingAnimation;
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
