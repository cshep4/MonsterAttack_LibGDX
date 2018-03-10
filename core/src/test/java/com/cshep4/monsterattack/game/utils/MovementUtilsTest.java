package com.cshep4.monsterattack.game.utils;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.math.Rectangle;
import com.cshep4.monsterattack.game.character.Character;
import com.cshep4.monsterattack.game.character.Player;
import com.cshep4.monsterattack.game.factory.AnimationFactory;
import com.cshep4.monsterattack.game.wrapper.Animation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static com.cshep4.monsterattack.game.constants.Constants.CHARACTER_MOVE_LEFT;
import static com.cshep4.monsterattack.game.constants.Constants.CHARACTER_MOVE_RIGHT;
import static com.cshep4.monsterattack.game.constants.Constants.PLAYER_SPEED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest({AnimationFactory.class})
public class MovementUtilsTest {
    private static final float START_X = 100;
    private static final float START_Y = 100;
    private static final float DESTINATION_X = 400;
    private static final float DESTINATION_Y = 400;
    private static final float START_DIFFERENCE_X = 300;
    private static final float START_DIFFERENCE_Y = 300;

    @Mock
    private Animation animationWrapper;

    @Mock
    private Graphics graphics;

    @Mock
    private Application app;

    @Before
    public void init() {
        mockStatic(AnimationFactory.class);
        when(AnimationFactory.createAnimation(any(Integer.class), any(Integer.class), any(String.class))).thenReturn(animationWrapper);

        Gdx.graphics = graphics;
        when(graphics.getDeltaTime()).thenReturn(1f);
        Gdx.app = app;
        doNothing().when(app).log(any(String.class),any(String.class));
    }

    @Test
    public void moveCharacterTowardsPoint() throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(START_X);
        rectangle.setY(START_Y);
        Character character = Player.create(1,1);
        character.setXVel(PLAYER_SPEED);
        character.setYVel(PLAYER_SPEED);

        MovementUtils.moveCharacterTowardsPoint(character, DESTINATION_X, DESTINATION_Y);

        final float endDifferenceX = DESTINATION_X - character.getX();
        final float endDifferenceY = DESTINATION_Y - character.getY();

        assertThat(endDifferenceX, lessThan(START_DIFFERENCE_X));
        assertThat(endDifferenceY, lessThan(START_DIFFERENCE_Y));
        //should equal same as both start X and Y and end X and Y are same
        assertThat(character.getX(), is(character.getY()));
    }

    @Test
    public void movePlayerTowardsPoint_setsCorrectAnimationWhenPlayerFacingRight() throws Exception {
        Player player = Player.create(START_X, START_Y);
        player.setXVel(PLAYER_SPEED);
        player.setYVel(PLAYER_SPEED);

        MovementUtils.movePlayerTowardsPoint(player, DESTINATION_X, DESTINATION_Y);

        final float endDifferenceX = DESTINATION_X - player.getX();
        final float endDifferenceY = DESTINATION_Y - player.getY();

        assertThat(endDifferenceX, lessThan(START_DIFFERENCE_X));
        assertThat(endDifferenceY, lessThan(START_DIFFERENCE_Y));

        verifyStatic(AnimationFactory.class);
        AnimationFactory.createAnimation(6, 1, CHARACTER_MOVE_RIGHT);
    }

    @Test
    public void movePlayerTowardsPoint_setsCorrectAnimationWhenPlayerFacingLeft() throws Exception {
        Player player = Player.create(DESTINATION_X, DESTINATION_Y);
        player.setXVel(PLAYER_SPEED);
        player.setYVel(PLAYER_SPEED);

        MovementUtils.movePlayerTowardsPoint(player, START_X, START_Y);

        final float endDifferenceX = DESTINATION_X - player.getX();
        final float endDifferenceY = DESTINATION_Y - player.getY();

        assertThat(endDifferenceX, lessThan(START_DIFFERENCE_X));
        assertThat(endDifferenceY, lessThan(START_DIFFERENCE_Y));

        verifyStatic(AnimationFactory.class);
        AnimationFactory.createAnimation(6, 1, CHARACTER_MOVE_LEFT);
    }

    @Test
    public void movePlayerTowardsPoint_doNotMovePlayerIfAlreadyAtDestination() throws Exception {
        Player player = Player.create(START_X, START_Y);
        player.setXVel(PLAYER_SPEED);
        player.setYVel(PLAYER_SPEED);

        float desinationX = START_X + player.getWidth()/2;
        float desinationY = START_Y + player.getHeight()/2;

        MovementUtils.movePlayerTowardsPoint(player, desinationX, desinationY);

        assertThat(player.getX(), is(START_X));
        assertThat(player.getY(), is(START_Y));
    }
}