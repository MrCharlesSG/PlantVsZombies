
package tp1.p2.logic;


import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.control.exceptions.InvalidPositionException;
import tp1.p2.control.exceptions.NotCatchablePositionException;
import tp1.p2.control.exceptions.NotEnoughCoinsException;
import tp1.p2.control.exceptions.RecordException;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;


public class Game implements GameStatus, GameWorld{
	
	public static final int INITIAL_SUNCOINS=50;
	
	private boolean playerQuits;
	
	private int suncoins;
	
	private int score;
	
	GameObjectContainer container;
	
	ZombiesManager zombiesMan;
	
	Random rand;
	
	SunsManager sunMan;
	
	private Deque<GameAction> actions;
	
	private int cycle;

	private long seed;

	private boolean finish;

	private Level level;
	
	Record record;
	
	private boolean theWinner; // si true ganan plantas, si false ganan zombies
	
	public Game(long seed, Level level) throws GameException {
		this.seed = seed;
		this.level = level;
		this.container = new GameObjectContainer();
		this.zombiesMan= new ZombiesManager(this, level, rand);
		reset();
	}
	
	public void reset() throws GameException{
		reset(this.level, this.seed);
	}

	/**
	 * Resets the game with the provided level and seed.
	 * º
	 * @param level {@link Level} Used to initialize the game.
	 * @param seed Random seed Used to initialize the game.
	 */
	@Override
	public void reset(Level level, long seed) throws GameException {
		try {
			this.suncoins=INITIAL_SUNCOINS;
			this.cycle=0;
			rand = new Random(seed);
			this.finish=false;
			this.playerQuits=false;
			this.theWinner=false;
			this.actions = new ArrayDeque<>();
			this.sunMan=new SunsManager(this, rand);
			this.container.reset();
			this.zombiesMan.reset(level, rand);
			this.score=0;
			this.record=new Record(level, 0).loadRecord(level);
		}catch(CommandParseException a) {
			throw new CommandParseException(a);
		}
	}
	
	
	@Override
	public void playerQuits() {
		playerQuits=true;
	}

	@Override
	public boolean execute(Command command) throws GameException {
		return command.execute(this);
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
		
		return container.positionToString( col,row);
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
		return container.anObjectInPosition(col, row);
	}

	@Override
	public void generaSunCoins() {
		sunMan.addSun();
	}

	@Override
	public void zombiesWin() {
		this.theWinner=false;
		this.finish=true;
	}

	@Override
	public boolean playerWin() {
		if(zombiesMan.zombiesLoose()) {
			this.theWinner=true;
			this.finish=true;
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
	public void update() throws GameException{

	    // 1. Execute pending actions
			executePendingActions();

			// 2 & 3 Execute game Actions and Game object updates
			this.container.update();
			this.zombiesMan.update();
			this.sunMan.update();
			
			// 4. & 5. Remove dead and execute pending actions
			boolean deadRemoved = true;
			while (deadRemoved || areTherePendingActions()) {
				// 4. Remove dead
				deadRemoved = container.removeDead();

				// 5. execute pending actions
				executePendingActions();
			}

			this.cycle++;

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
	
	
	@Override
	public boolean isFullyOcuppied(int col, int row) {
		return this.container.isFullyOccupied(col, row);
	}

	@Override
	public int getGeneratedSuns() {
		return this.sunMan.getGeneratedSuns();
	}

	@Override
	public int getCaughtSuns() {
		return this.sunMan.getCatchedSuns();
	}

	@Override
	public void checkValidZombiePosition(int col, int row) throws GameException {
		if((col<0 && row<0 && col>NUM_COLS && row>NUM_ROWS) || container.isFullyOccupied(col, row)) {
			
			throw new InvalidPositionException(String.format(Messages.INVALID_POSITION, col, row));
			
		}	
	}

	@Override
	public void tryToCatchObject(int col, int row) throws GameException {
		if(!container.catchObject(col, row)) {
			throw new NotCatchablePositionException(String.format(Messages.NO_CATCHABLE_IN_POSITION, col, row));
		}
	}

	@Override
	public void tryToBuy(int cost) throws GameException {
		if(cost<=this.suncoins) {
			this.suncoins-=cost;
		}else {
			throw new NotEnoughCoinsException(Messages.NOT_ENOUGH_COINS);
		}
	}

	@Override
	public void checkValidPlantPosition(int col, int row) throws GameException {
		if((col<0 && row<0 && col>NUM_COLS && row>NUM_ROWS) || container.isFullyOccupied(col, row)) {
			
			throw new InvalidPositionException(String.format(Messages.INVALID_POSITION, col, row));
			
		}

	}

	@Override
	public void addItem(GameObject obj) {
		container.addItem(obj);
		
	}

	@Override
	public int getRecord() {
		return record.getCurrentRecord();
	}

	@Override
	public String getLevelName() {
		return record.getLevelName();
	}

	@Override
	public void incrementaPuntos() {
		this.score+=10;
	}

	public boolean newRecord() throws CommandParseException {
		if(getRecord()<=this.score) {
			try {
				Record aux=new Record(level, this.score);
				record.setRecord(aux);
				record.saveRecord();
				return true;
			}catch(RecordException a) {
				throw new CommandParseException(a);
			}
			
		}else {
			return false;
		}
	}

	@Override
	public int getScore() {
		return this.score;
	}
	
	
}
