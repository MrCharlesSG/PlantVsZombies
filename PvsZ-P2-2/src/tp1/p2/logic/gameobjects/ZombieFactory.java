package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

public class ZombieFactory {
	
	
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
			new ZombieSporty(),
			new ZombieBucketHead(),
			new ZombieCommon(),
			new ZombieExplosive()
		);
	
	public static List<Zombie> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}

	public static Zombie spawnZombie(int row,int col, GameWorld game, int zombieType) {

		if(GameObject.posValida(col, row, GameWorld.NUM_COLS+1, GameWorld.NUM_ROWS)){
			col++;
			if(game.isEmpty(col, row)) {
				Zombie zb=AVAILABLE_ZOMBIES.get(zombieType);
				zb.create(game, col, row);
				return zb;
			}
		}
		return null;
	}
}
