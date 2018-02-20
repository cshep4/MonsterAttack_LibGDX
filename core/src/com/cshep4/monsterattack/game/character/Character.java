package com.cshep4.monsterattack.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.cshep4.monsterattack.game.core.GameObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.cshep4.monsterattack.GameScreen.getScreenXMax;
import static com.cshep4.monsterattack.game.constants.Constants.CHARACTER_HEIGHT_DIVIDER;
import static com.cshep4.monsterattack.game.constants.Constants.CHARACTER_WIDTH_DIVIDER;


@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Character extends GameObject {
    protected int health;
    protected float xVel;
    protected float yVel;

    protected Character(Rectangle rectangle, Texture texture, int frameCols, int frameRows) {
        super(rectangle, texture, frameCols, frameRows);
        health = 1;
        setWidth(getScreenXMax() / CHARACTER_WIDTH_DIVIDER);
        setHeight(getScreenXMax() / CHARACTER_HEIGHT_DIVIDER);
    }

    public void update(){
        setX(getX() + getXVelByDeltaTime());
        setY(getY() + getYVelByDeltaTime());
    }

    public void kill() {
        health = 0;
    }

    protected float getXVelByDeltaTime() {
        return xVel*Gdx.graphics.getDeltaTime();
    }

    protected float getYVelByDeltaTime() {
        return yVel*Gdx.graphics.getDeltaTime();
    }
}
