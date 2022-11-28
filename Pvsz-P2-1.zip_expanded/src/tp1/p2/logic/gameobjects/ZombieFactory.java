package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

public class ZombieFactory {
	
	
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
			new ZombieCommon(),	
			new ZombieBucketHead(),
			new ZombieSporty(),
			new ZombieExplosive()
		);
	
	public static List<Zombie> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}

	public static GameObject spawnZombie(int row,int col, GameWorld game, int zombieType) {

		if(GameObject.posValida(col, row, GameWorld.NUM_COLS, GameWorld.NUM_ROWS)&&!game.isFullyOcuppied(col, row)){
			col++;
			
			GameObject zb=AVAILABLE_ZOMBIES.get(zombieType).create(game, col, row);
			return zb;
			
		}
		return null;
	}
}
