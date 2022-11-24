package tp1.p2.logic.gameobjects;

import static tp1.p2.view.Messages.status;

import tp1.p2.logic.Game;
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
	
	protected int numSolesGenera;
	
	protected int speed;
	
	GameObject() {
		this.cycles=0;
		this.coste=0;
		this.numSolesGenera=0;
		this.damage=0;
		this.speed=0;
	}

	GameObject(GameWorld game, int col, int row) {
		this.create(game, col, row);
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
			return String.format(Messages.GAME_OBJECT_STATUS,this.getSymbol(),this.lifes);
		} else {
			return null;
		}
	}
	
	protected static boolean posValida(int col, int row, int maxCol, int maxRow) {
		return(col<=maxCol && row <= maxRow && col>=0 && row>=0);
	}
	
	abstract public int getCoste();
	
	abstract protected String getSymbol();

	abstract public String getDescription();
	
	abstract public String getName();

	abstract public void update();
	
	abstract public void onEnter(); // q gestione add
	
	abstract public void onExit();
	
	@Override
	public boolean fillPosition() {
		return true;
	}
	
	public void create(GameWorld game, int col, int row) {
		this.game=game;
		this.col=col;
		this.row=row;
	}
	
	public abstract boolean haLlegado();
	
	public boolean catchSun() {
		return false;
	}
}
