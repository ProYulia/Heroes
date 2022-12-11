package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Heroes.Base;
import com.mygdx.game.Heroes.Spearman;
import com.mygdx.game.Heroes.States;

public class WorldRenderer {
    SpriteBatch batch;
    World world;
    BitmapFont font = new BitmapFont();

    public WorldRenderer(SpriteBatch batch, World world) {
        this.world = world;
        this.batch = batch;
    }

    public void render(){
        renderBackground();
        drawHeroes();
    }

    public void renderBackground() {
        batch.begin();
        batch.draw(Assets.background, 0, 0);
        batch.end();
    }

    public void renderHeroes() {
        batch.begin();
        drawSpearman();

//        batch.draw(Assets.background, 0, 0);
//        for (Base hero : world.darkSide) {
//            batch.draw(hero.getTexture(), hero.getPosition().x, hero.getPosition().y, 100, 100);
//            font.draw(batch, hero.getInfo(),hero.getPosition().x-100, hero.getPosition().y+5);
//        }
//
//        for (Base hero : world.whiteSide)
//        {
//            batch.draw(hero.getTexture(), hero.getPosition().x, hero.getPosition().y, 100, 100);
//            font.draw(batch, hero.getInfo(),hero.getPosition().x, hero.getPosition().y+5);
//        }
        batch.end();
    }
    private void drawHeroes() {
        batch.begin();
        drawSpearman();
        batch.end();
    }
    private void draw (Base hero, TextureRegion region) {
        batch.draw(region, hero.getPosition().x, hero.getPosition().y);

    }

    private void drawSpearman () {
        Spearman spearman = world.getSpearman();
        switch (spearman.getState()) {
            case ALIVE:
                draw(spearman, Assets.spearmanStandingAnimation.getFrame());
                break;
        }
    }


}
