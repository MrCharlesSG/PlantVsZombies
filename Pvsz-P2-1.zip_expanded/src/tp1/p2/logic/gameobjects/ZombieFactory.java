package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

public class ZombieFactory {	
	
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
			new DefaultZombie(),
			new BucketHead(),
			new Sporty(),
			new ExplosiveZombie()
		);
	
	public static List<Zombie> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}
	
	public static boolean isValidZombie(int zombieIdx) {
		return zombieIdx >= 0 && zombieIdx < AVAILABLE_ZOMBIES.size();
	}
	
	public static Zombie spawnZombie(int row, GameWorld game, int zombieType) {
		int col=GameWorld.NUM_COLS;
		if(isValidZombie(zombieType)) {
			if(GameObject.posValida(col, row, col, GameWorld.NUM_ROWS)){
				col++;
				if(game.isEmpty(col, row)) {
					Zombie zb=AVAILABLE_ZOMBIES.get(zombieType);
					zb.create(game, col, row);
					return zb;
				}
			}
		}
		return null;
	}
}
