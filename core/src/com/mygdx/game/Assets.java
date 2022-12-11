package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class Assets {
    public static BitmapFont font;
    public static Texture background;
    private static TextureAtlas atlas;
    static GameAnimation spearmanStandingAnimation;


    public static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));

    }

    public static void load() {
        atlas = new TextureAtlas("Lancer.atlas");
        spearmanStandingAnimation = new GameAnimation(atlas,"Knight_01__ATTACK", 10, Animation.PlayMode.LOOP);
        spearmanStandingAnimation.setTime(Gdx.graphics.getDeltaTime());
        background = loadTexture("battlefield2.png");
        font = new BitmapFont();

    }

}
