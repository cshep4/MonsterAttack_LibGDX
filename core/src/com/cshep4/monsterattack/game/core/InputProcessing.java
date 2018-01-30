package com.cshep4.monsterattack.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.cshep4.monsterattack.GameScreen;

import static com.cshep4.monsterattack.GameScreen.getScreenXMax;
import static com.cshep4.monsterattack.GameScreen.getScreenYMax;
import static com.cshep4.monsterattack.game.core.State.PAUSE;
import static com.cshep4.monsterattack.game.core.State.RESUME;
import static com.cshep4.monsterattack.game.core.State.RUN;

public class InputProcessing extends InputAdapter {
    private GameScreen gameScreen;

    public InputProcessing(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        float xMultiplier = getScreenXMax() / Gdx.graphics.getWidth();
        float yMultiplier = getScreenYMax() / Gdx.graphics.getHeight();

        float xPos = xMultiplier * x;
        float yPos = yMultiplier * (gameScreen.getHeight() - y);

        if (gameScreen.getState() == RUN) {
            if (gameScreen.getPauseButton().getRectangle().contains(xPos, yPos)) {
                gameScreen.setState(PAUSE);
                gameScreen.setJustPaused(true);
            }
            else if (gameScreen.getShootButton().getRectangle().contains(xPos, yPos)) {
                gameScreen.shoot();
            }
            else {
                if (gameScreen.getPressDownPointer() == -1) {
                    gameScreen.setPressDownPointer(pointer);
                }
            }
        }

        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        if (!gameScreen.isJustPaused() && gameScreen.getState() == PAUSE) {
            gameScreen.setState(RESUME);
        }
        gameScreen.setJustPaused(false);

        if (pointer == gameScreen.getPressDownPointer()) {
            gameScreen.getPlayer().stand();
            gameScreen.setPressDownPointer(-1);
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        float xMultiplier = getScreenXMax() / Gdx.graphics.getWidth();
        float yMultiplier = getScreenYMax() / Gdx.graphics.getHeight();

        float xPos = xMultiplier * screenX;
        float yPos = yMultiplier * (gameScreen.getHeight() - screenY);

        if (pointer == gameScreen.getPressDownPointer()) {
            gameScreen.getPlayer().move(xPos, yPos);
        }
        return true;
    }
}
