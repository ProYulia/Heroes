package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameOverScreen extends ScreenAdapter {
    SuperHeroes game;

    public GameOverScreen(SuperHeroes game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(Assets.gameOverBackground, 0, 0, 1000, 720);
        game.batch.end();
    }
}
