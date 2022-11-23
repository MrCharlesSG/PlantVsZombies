
package tp1.p2.logic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;

public class Game implements GameStatus, GameWorld{
	
	public static final int INITIAL_SUNCOINS=50;
	
	private boolean playerQuits;
	
	private int suncoins;
	
	GameObjectContainer container;
	
	ZombiesManager zombiesMan;
	
	Random rand;

	private Deque<GameAction> actions = new ArrayDeque<>();
	
	private int cycle;

	private long seed;

	private boolean finish;

	private Level level;
	
	private boolean theWinner; // si true ganan plantas, si false ganan zombies
	
	public Game(long seed, Level level) {
		this.suncoins=INITIAL_SUNCOINS;
		this.cycle=0;
		rand = new Random(seed);
		this.seed=seed;
		this.finish=false;
		this.playerQuits=false;
		container=new 	GameObjectContainer();
		this.level=level;
		this.theWinner=false;
		this.zombiesMan= new ZombiesManager(this, level, rand);
	}
	
	@Override
	public void playerQuits() {
		playerQuits=true;
	}

	@Override
	public boolean execute(Command command) {
		cycle++;
		return command.execute(this).draw();
	}

	@Override
	public boolean isEmpty(int col, int row) {
		return container.isFullyOccupied(col, row);
	}

	@Override
	public void addObj(GameObject obj) {
		container.addObject(obj);
	}
	
	@Override
	public boolean esSuficiente(int coste) {
		if(coste<=this.suncoins) {
			this.suncoins-=coste;
			return true;
		}
		return false;
	}

	@Override
	public void reset(Level level, long seed) {
		reset();
		this.level=level;
		rand = new Random(seed);
		this.seed=seed;
		this.zombiesMan.reset(level, rand);
	}
	
	@Override
	public void reset() {
		this.suncoins=INITIAL_SUNCOINS;
		this.cycle=0;
		container.reset();
	}

	@Override
	public int getCycle() {
		return cycle;
	}

	@Override
	public int getSuncoins() {	
		return suncoins;
	}

	@Override
	public boolean isPlayerQuits() {
		return playerQuits;
	}
	
	@Override
	public boolean isFinished() {
		return finish;
	}

	@Override
	public String positionToString(int col, int row) {
		
		return container.positionToString(col,row);
	}

	@Override
	public boolean ganador() {
		return theWinner;
	}

	@Override
	public int getRemainingZombies() {
		return zombiesMan.getRemainingZombies();
	}

	@Override
	public GameObject isInPosition(int col, int row) {
		return container.isInPosition(col, row);
	}

	@Override
	public void GeneraSunCoins(int numSunCoins) {
		this.suncoins+=numSunCoins;
	}

	@Override
	public void zombiesWin() {
		this.theWinner=false;
	}

	@Override
	public boolean playerWin() {
		if(zombiesMan.zombiesLoose()) {
			this.theWinner=true;
			return true;
		}
		return false;
	}

	@Override
	public GameItem getGameItemInPosition(int col, int row) {
		return this.isInPosition(col, row);
	}

	@Override
	public void reduceZombie() {
		zombiesMan.reduceZombies();
	}

	@Override
	public boolean catchSun(int col, int row) {
		return container.catchSun(col, row);
	}
	
	@Override
	public void update() {
		
	    // 1. Execute pending actions
			if(areTherePendingActions()) {
				executePendingActions();
			}
			
			// 2. Execute game Actions
			
			// 3. Game object updates
			this.container.update();
			// 4. & 5. Remove dead and execute pending actions
			boolean deadRemoved = true;
			while (deadRemoved || areTherePendingActions()) {
				// 4. Remove dead
				deadRemoved = container.removeDead();

				// 5. execute pending actions
				executePendingActions();
			}

			// 6. Notify commands that a new cycle started
			Command.newCycle();
	}

	@Override
	public void pushAction(GameAction gameAction) {
	    this.actions.addLast(gameAction);
	}

	private void executePendingActions() {
	   while (!this.actions.isEmpty()) {
	      GameAction action = this.actions.removeLast();
	      action.execute(this);
	   }
	}

	private boolean areTherePendingActions() {
	    return this.actions.size() > 0;
	}

	@Override
	public void convertSun(int valueOfChange) {
		suncoins+=valueOfChange;
	}
	
	/**
	 * Checks if a cell is fully occupied, that is, the position can be shared between an NPC (Plant, Zombie) and Suns .
	 * 
	 * @param col Column of the cell
	 * @param row Row of the cell
	 * 
	 * @return <code>true</code> if the cell is fully occupied, <code>false</code>
	 *         otherwise.
	 */
	@Override
	public boolean isFullyOcuppied(int col, int row) {
		return this.container.isFullyOccupied(col, row);
	}
	
}
