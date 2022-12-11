package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameAnimation {
    private Animation<TextureAtlas.AtlasRegion> animation;
    private float time;

    public GameAnimation(TextureAtlas atlas, String name, int fps,Animation.PlayMode playMode) {
        animation = new Animation<TextureAtlas.AtlasRegion>(1.0f/fps, atlas.findRegions(name));
        animation.setPlayMode(playMode);
    }
    public void setTime(float dTime) {time += dTime;}
    public TextureRegion getFrame() {return animation.getKeyFrame(time, true);}
}
