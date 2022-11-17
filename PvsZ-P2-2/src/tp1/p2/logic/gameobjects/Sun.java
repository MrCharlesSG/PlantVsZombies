package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sun extends GameObject {
	
	public static int generatedSuns=0;
	
	public static int catchedSuns=0;
	
	public final static int VALUE_OF_CHANGE=10;

	public final static int TIME_ALIVE=10;
	
	public Sun(GameWorld game, int col, int row) {
		this.game=game;
		this.col=col;
		this.row=row;
		this.lifes=TIME_ALIVE;
	}

	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

	@Override
	public int getCoste() {
		return 0;
	}

	@Override
	protected String getSymbol() {
		return Messages.SUN_SYMBOL;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void update() {
		this.lifes--;
	}

	@Override
	public void onEnter() {
		Sun.generatedSuns++;
	}

	@Override
	public void onExit() {
		catchedSuns++;
	}

	@Override
	public boolean hasArrive() {
		return false;
	}
	
	public boolean catchSun() {
		game.convertSun(VALUE_OF_CHANGE);
		return true;
	}

	@Override
	public String getName() {
		return Messages.SUN_DESCRIPTION;
	}
	
	
}
