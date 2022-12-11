package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    SuperHeroes game;
    World world;
    WorldRenderer renderer;

    public GameScreen(SuperHeroes game) {
        this.game = game;
        world = new World();
        renderer = new WorldRenderer(game.batch, world);
    }

    private void updateStep(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
            world.setPriority();
    }
    public void update (float deltaTime) {
        if (deltaTime > 0.1f) deltaTime = 0.1f;
    }

    @Override
    public void render(float delta) {
        update(delta);
        updateStep();
        renderer.render();
    }
}
