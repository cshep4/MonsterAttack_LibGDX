package com.cshep4.monsterattack.game.core;

import com.cshep4.monsterattack.game.character.Bomber;
import com.cshep4.monsterattack.game.character.BomberProducer;
import com.cshep4.monsterattack.game.character.Enemy;
import com.cshep4.monsterattack.game.character.ProducerEnemy;
import com.cshep4.monsterattack.game.character.Standard;
import com.cshep4.monsterattack.game.character.StandardProducer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.cshep4.monsterattack.GameScreen.getScreenXMax;
import static com.cshep4.monsterattack.GameScreen.getScreenYMax;
import static com.cshep4.monsterattack.game.constants.Constants.CHARACTER_HEIGHT_DIVIDER;
import static com.cshep4.monsterattack.game.constants.Constants.MAX_ENEMIES;
import static com.cshep4.monsterattack.game.constants.Constants.MAX_LEVEL;
import static com.cshep4.monsterattack.game.constants.Constants.MIN_LEVEL;
import static com.cshep4.monsterattack.game.constants.Constants.SPAWN_DELAY_MAX;
import static com.cshep4.monsterattack.game.constants.Constants.SPAWN_DELAY_MIN;
import static java.lang.System.currentTimeMillis;

public final class Spawn {
    private static long enemySpawnTime = currentTimeMillis();

    private Spawn() {}

    public static void spawnEnemies(List<Enemy> enemies, List<ProducerEnemy> producerEnemies) {
        if (readyToSpawn(enemies, producerEnemies)) {
            int maxY = (int) (getScreenYMax() - (getScreenXMax() / CHARACTER_HEIGHT_DIVIDER * 2)) + 1;
            int minY = (int) getScreenXMax() / CHARACTER_HEIGHT_DIVIDER;

            float x = getScreenXMax();
            float y = ThreadLocalRandom.current().nextInt(minY, maxY);

            int level = ThreadLocalRandom.current().nextInt(MIN_LEVEL, MAX_LEVEL + 1);
            int randEnemy = ThreadLocalRandom.current().nextInt(MIN_LEVEL, MAX_LEVEL + 1);

            switch (randEnemy) {
                case 1:
                    enemies.add(Standard.create(x, y, level));
                    break;
                case 2:
                    producerEnemies.add(StandardProducer.create(x, y));
                    break;
                case 3:
                    enemies.add(Bomber.create(x, y, level));
                    break;
                case 4:
                    producerEnemies.add(BomberProducer.create(x, y));
                    break;
                default:
                    enemies.add(Standard.create(x, y, level));
                    break;
            }

            enemySpawnTime = currentTimeMillis();
        }
	}

	private static boolean readyToSpawn(List<Enemy> enemies, List<ProducerEnemy> producerEnemies) {
        return lessThanMaxNumberOfEnemies(enemies, producerEnemies) && checkSpawnDelay();
    }

	private static boolean lessThanMaxNumberOfEnemies(List<Enemy> enemies, List<ProducerEnemy> producerEnemies) {
        return ((enemies.size() + producerEnemies.size()) < MAX_ENEMIES);
    }

	private static boolean checkSpawnDelay() {
        Random rand = new Random();
        int delay = rand.nextInt(SPAWN_DELAY_MAX) + SPAWN_DELAY_MIN;

        return currentTimeMillis() - enemySpawnTime > delay;
	}
}