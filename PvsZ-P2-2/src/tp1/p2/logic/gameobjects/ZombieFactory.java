package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

public class ZombieFactory {
	
	
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
			new ZombieCommon(),		
			new ZombieSporty(),
			new ZombieBucketHead(),
			new ZombieExplosive()
		);
	
	public static List<Zombie> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}

	public static GameObject spawnZombie(int row,int col, GameWorld game, int zombieType) {

		if(GameObject.posValida(col, row, GameWorld.NUM_COLS, GameWorld.NUM_ROWS)){
			col++;
			
			GameObject zb=AVAILABLE_ZOMBIES.get(zombieType).create(game, col, row);
			return zb;
			
		}
		else {
			GameWorld.invalidPosition();
		}
		return null;
	}
	
	public static boolean correctIndex(int i) {
		return i>=0 && i<AVAILABLE_ZOMBIES.size();
	}
}
