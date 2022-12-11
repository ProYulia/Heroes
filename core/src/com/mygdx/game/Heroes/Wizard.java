package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameAnimation;

import java.util.ArrayList;

public class Wizard extends Healer {
    GameAnimation currentAnimation;
    public Wizard(ArrayList<Base> group, int x, int y, int pivot) {
        super(17, 12, new int[]{-5,-5}, 30, 9, States.ALIVE);
        super.group = group;
        super.position = new Position(x, y);
        super.texture = new Texture("Wizard.png");
    }
    public TextureRegion getWizardTexture() {
        if (currentAnimation == null || currentAnimation.isFinished()) {
            switch (getState()) {
                case ALIVE:
                    currentAnimation = Assets.wizardStandingAnimation;
                    break;
                case DEAD:
                    currentAnimation = Assets.wizardDyingAnimation;
                    break;
                case ATTACK:
                    currentAnimation = Assets.wizardAttackingAnimation;
                    break;

            }
        }
        return currentAnimation.getFrame();
    }

    public GameAnimation getCurrentAnimation() {
        return currentAnimation;
    }

}
