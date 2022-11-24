package tp1.p2.logic;

import java.util.Random;

import tp1.p2.logic.Game;
import tp1.p2.control.Level;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;

/**
 * Manage zombies in the game.
 *
 */
public class ZombiesManager {

	private GameWorld game;

	private Level level;

	private Random rand;

	private int remainingZombies;
	
	private int zombiesAlived;
	
	public ZombiesManager(GameWorld game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombiesAlived = 0;
		
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}

	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	private int randomZombieRow() {
		return rand.nextInt(GameWorld.NUM_ROWS);
	}

	private int randomZombieType() {
		
		return rand.nextInt(ZombieFactory.getAvailableZombies().size());
	}

	public void update() {
		addZombie();
	}

	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}

	public boolean addZombie(int row) {
		boolean canAdd = this.remainingZombies > 0 && shouldAddZombie() && isPositionEmpty(GameWorld.NUM_COLS, row);

		if (canAdd) {
			int zombieType = randomZombieType();
			game.addItem(ZombieFactory.spawnZombie(row,GameWorld.NUM_COLS, game, zombieType));	
			this.remainingZombies--;
			this.zombiesAlived++;
		}
		return canAdd;
	}

	public int getRemainingZombies() {
		return this.remainingZombies;
	}

	private boolean isPositionEmpty(int numCols, int row) {
		
		return !game.isFullyOcuppied(numCols, row);
	}

	public void reset(Level level, Random rand) {
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombiesAlived = 0;
	}

	public boolean zombiesLoose() {
		if(this.remainingZombies==0 && this.zombiesAlived==0) {
			return true;
		}
		return false;
	}
	
	public void reduceZombies() {
		zombiesAlived--;
	}

}
