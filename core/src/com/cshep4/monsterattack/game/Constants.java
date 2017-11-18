package com.cshep4.monsterattack.game;

public final class Constants {

	private Constants() {}

	public static final int LEFT = 0;
	public static final int RIGHT = 1;

	public static final int CHARACTER_WIDTH_DIVIDER = 14;
	public static final int CHARACTER_HEIGHT_DIVIDER = 10;

	public static final int BULLET_WIDTH_DIVIDER = 3;
	public static final int BULLET_HEIGHT_DIVIDER = 5;

	public static final int BOMB_SIZE_DIVIDER = 5;

	public static final int BUTTON_SIZE_DIVIDER = 10;

	public static final int BULLET_SPEED = 10;

	public static final float ENEMY_SPEED = 2;
	public static final float PLAYER_SPEED = 2;

	public static final int SHOOT_DELAY = 1000;

	public static final int SPAWN_DELAY_MIN = 1500;
	public static final int SPAWN_DELAY_MAX = 2500;

	public static final int PRODCUER_SPAWN_DELAY_MIN = 1500;
	public static final int PRODCUER_SPAWN_DELAY_MAX = 2500;

	public static final int MUTATE_DELAY_MIN = 3000;
	public static final int MUTATE_DELAY_MAX = 4000;

	public static final int MAX_ENEMIES = 2;
	
	//sprite dividers
	public static final int CHARACTER_IDLE_DIVIDER = 2;
	public static final int CHARACTER_GOT_HIT_DIVIDER = 1;
	public static final int CHARACTER_RUNNING_DIVIDER = 6;
	public static final int S_1_GOT_HIT_DIVIDER = 1;
	public static final int S_MOVE_DIVIDER = 2;
	public static final int S_GOT_HIT_DIVIDER = 2;
	public static final int S_SHIELD_DIVIDER = 2;
	public static final int B_GOT_HIT_DIVIDER = 2;
	public static final int B_MOVE_DIVIDER = 7;
	public static final int S_P_IDLE_DIVIDER = 8;
	public static final int S_P_PRODUCE_DIVIDER = 2;
	public static final int B_P_IDLE_DIVIDER = 2;
	public static final int B_P_PRODUCE_DIVIDER = 1;

	//Define the frame rate
	public static final float FRAME_RATE = 30;

	// --------------------------------------Sprites
	// Enemies
//	public static final String S1_SPRITE_IDLE = "";
//	public static final String S2_SPRITE_IDLE = "";
//	public static final String S3_SPRITE_IDLE = "";
//	public static final String S4_SPRITE_IDLE = "";
	public static final String SP_SPRITE_IDLE = "sp_idle.png";
//	public static final String B1_SPRITE_IDLE = "";
//	public static final String B2_SPRITE_IDLE = "";
//	public static final String B3_SPRITE_IDLE = "";
//	public static final String B4_SPRITE_IDLE = "";
	public static final String BP_SPRITE_IDLE = "bp_idle.png";
	public static final String S1_SPRITE_MOVE_LEFT = "s1_move.png";
	public static final String S2_SPRITE_MOVE_LEFT = "s2_move.png";
	public static final String S3_SPRITE_MOVE_LEFT = "s3_move.png";
	public static final String S4_SPRITE_MOVE_LEFT = "s4_move.png";
	public static final String S1_SPRITE_MOVE_RIGHT = "s1_move1.png";
	public static final String S2_SPRITE_MOVE_RIGHT = "s2_move1.png";
	public static final String S3_SPRITE_MOVE_RIGHT = "s3_move1.png";
	public static final String S4_SPRITE_MOVE_RIGHT = "s4_move1.png";
	public static final String S4_SPRITE_SHIELD = "s4_shield.png";
	public static final String SP_SPRITE_PRODUCE = "sp_produce.png";
	public static final String B1_SPRITE_MOVE = "b1_move.png";
	public static final String B2_SPRITE_MOVE = "b2_move.png";
	public static final String B3_SPRITE_MOVE = "b3_move.png";
	public static final String B4_SPRITE_MOVE = "b4_move.png";
	public static final String BP_SPRITE_PRODUCE = "bp_produce.png";
	public static final String S1_SPRITE_HIT = "s1_gothit.png";
	public static final String S2_SPRITE_HIT = "s2_gothit.png";
	public static final String S3_SPRITE_HIT = "s3_gothit.png";
	public static final String S4_SPRITE_HIT = "s4_gothit.png";
//	public static final String SP_SPRITE_HIT = "";
	public static final String B1_SPRITE_HIT = "b1_gothit.png";
	public static final String B2_SPRITE_HIT = "b2_gothit.png";
	public static final String B3_SPRITE_HIT = "b3_gothit.png";
	public static final String B4_SPRITE_HIT = "b4_gothit.png";
//	public static final String BP_SPRITE_HIT = "";

	// Character
	public static final String CHARACTER_IDLE = "idle.png";
	public static final String CHARACTER_MOVE_RIGHT = "character_running.png";
	public static final String CHARACTER_MOVE_LEFT = "character_running1.png";
	public static final String CHARACTER_HIT = "gothit.png";

	// Misc.
	public static final String BACKGROUND = "background_small.png";
	public static final String PAUSE_BUTTON = "pause_button.png";
	public static final String SHOOT_BUTTON = "shoot_button.png";

	// Bullet
	public static final String PLAYER_BULLET = "bullet.png";
	public static final String ENEMY_BULLET = "bullet1.png";
}
