package tp1.p2.logic;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Peashooter;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;


    void playerQuits();

    void update();
    
    boolean execute(Command command);

	boolean isEmpty(int col, int row);
	
	void addItem(GameObject obj);
	
	boolean esSuficiente(int coste);

	void reset(Level level, long seed);
	
	void reset() ;
	
	GameObject isInPosition(int col, int row);
		
	void GeneraSunCoins(int numSunCoins);

	void eliminate(GameItem obj);
	
	void reduceZombie();

	void zombiesWin();

	boolean playerWin();

	GameItem getGameItemInPosition(int col, int row);
	
	public int getCycle();

	boolean catchSun(int col, int row);

}
