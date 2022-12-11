package tp1.p2.logic;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.control.Level;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.view.Messages;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;


    void playerQuits();

    void update() throws GameException;
    
    boolean execute(Command command) throws GameException;
	
    void checkValidZombiePosition(int col, int row) throws GameException;

	void tryToCatchObject(int col, int row) throws GameException;
	
	boolean esSuficiente(int coste);

	void reset(Level level, long seed) throws GameException;
	
	void reset() throws GameException ;
	
	void tryToBuy(int cost) throws GameException;
	
	void checkValidPlantPosition(int col, int row) throws GameException;
	
	GameObject isInPosition(int col, int row);
		
	void generaSunCoins();
	
	void reduceZombie();

	void zombiesWin();

	boolean playerWin();

	GameItem getGameItemInPosition(int col, int row);
	
	public int getCycle();

	void convertSun(int valueOfChange);

	void pushAction(GameAction gameAction);
	
	boolean isFullyOcuppied(int col, int row);

	void addItem(GameObject spawnPlant);
}
