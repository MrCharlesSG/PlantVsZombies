package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.control.exceptions.GameException;
import tp1.p2.control.exceptions.InvalidPositionException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

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

	public static GameObject spawnZombie(int row,int col, GameWorld game, int zombieType) throws GameException {
		if (!isValidZombie(zombieType)) {
			throw new GameException(Messages.INVALID_GAME_OBJECT);
		}else {
			if(GameObject.posValida(col, row, GameWorld.NUM_COLS, GameWorld.NUM_ROWS)){
				col++;
				
				GameObject zb=AVAILABLE_ZOMBIES.get(zombieType).create(game, col, row);
				return zb;
				
			}
			else {
				throw new InvalidPositionException(Messages.INVALID_POSITION);
			}
		}
	}
	
	private static boolean isValidZombie(int i) {
		return i>=0 && i<AVAILABLE_ZOMBIES.size();
	}

}
