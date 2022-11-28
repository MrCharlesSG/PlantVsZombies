package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ZombieSporty extends Zombie{

    public static final int INI_LIFES=2;
    public static final int SPEED=1;
	
    public ZombieSporty() {
    	super();
    	this.speed=SPEED;
    	this.lifes=INI_LIFES;
    }

	public ZombieSporty(GameWorld game, int col, int row) {
		super(game, col, row);
		this.speed=SPEED;
    	this.lifes=INI_LIFES;
	}

	@Override
	public int getIniLifes() {
		return INI_LIFES;
	}

	@Override
	protected String getSymbol() {
		return Messages.SPORTY_ZOMBIE_SYMBOL;
	}

	@Override
	public String getName() {
		return Messages.SPORTY_ZOMBIE_NAME;
	}



	@Override
	public GameObject create(GameWorld game, int col, int row) {
		return new ZombieSporty(game, col, row);
	}
}
