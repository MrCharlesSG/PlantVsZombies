package tp1.p2.logic;

import java.util.Random;

import tp1.p2.logic.ZombiesManager;
import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.GameObjectContainer;

//TO-DO
//updates

public class Game implements GameStatus, GameWorld{
	
	public static final int INITIAL_SUNCOINS=50;
	
	private boolean playerQuits;
	
	private int suncoins;
	
	GameObjectContainer contenedor;
	
	ZombiesManager zombiesMan;
	
	Random rand;
	
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
		contenedor=new 	GameObjectContainer();
		this.level=level;
		this.theWinner=false;
		this.zombiesMan= new ZombiesManager(this, level, rand);
	}
	
	@Override
	public void playerQuits() {
		playerQuits=true;
	}

	@Override
	public void update() {
		zombiesMan.addZombie();
		contenedor.update();
		
		
	}

	@Override
	public boolean execute(Command command) {
		cycle++;
		return command.execute(this).draw();
	}

	@Override
	public boolean isEmpty(int col, int row) {
		return contenedor.isEmpty(col, row);
	}

	@Override
	public void addItem (GameObject obj) {
		contenedor.addObject(obj);
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
		contenedor.reset();
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
		
		return contenedor.positionToString( col,row);
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
		return contenedor.isInPosition(col, row);
	}

	@Override
	public void GeneraSunCoins(int numSunCoins) {
		this.suncoins+=numSunCoins;
	}

	@Override
	public void eliminate(GameItem obj) {
		contenedor.eliminate(obj);
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
		return contenedor.catchSun(col, row);
	}
}
