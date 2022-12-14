package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

/**
 * Base class for game non playable character in the game.
 *
 */
public abstract class GameObject implements GameItem {

	protected GameWorld game;

	protected int col;

	protected int row;
	
	protected int lifes;
	
	protected int coste;

	protected int cycles;

	protected int damage;
	
	GameObject() {
		this.cycles=0;
		this.coste=0;
		this.damage=0;
	}

	GameObject(GameWorld game, int col, int row) {
		this.game=game;
		this.col=col;
		this.row=row;
		this.cycles=0;
		this.coste=0;
		this.damage=0;
	}

	public boolean isInPosition(int col, int row) {
		return this.col == col && this.row == row;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	
	public boolean isAlive() {
		return this.lifes>0;
	}
	
	public String toString() {
		if (isAlive()) {
			return this.getIcon();
		} else {
			return null;
		}
	}
	
	protected static boolean posValida(int col, int row, int maxCol, int maxRow) {
		return(col<=maxCol && row <= maxRow && col>=0 && row>=0);
	}
	
	protected String getIcon() {
		return String.format(Messages.GAME_OBJECT_STATUS,this.getSymbol(),this.lifes);
	}
	
	abstract public int getCoste();
	
	abstract protected String getSymbol();
	
	abstract public String getDescription();
	
	abstract public String getName();

	abstract public void update();
	
	abstract public void onEnter(); // q gestione add
	
	abstract public void onExit();
	
	
	abstract public GameObject create(GameWorld game, int col, int row);

	public abstract boolean hasArrive();

	public boolean fillPosition() {
		return true;
	}

	public void addCycle() {
		this.cycles++;
	}


}
