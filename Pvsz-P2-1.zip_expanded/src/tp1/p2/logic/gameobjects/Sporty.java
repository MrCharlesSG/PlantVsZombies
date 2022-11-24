package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class Sporty extends Zombie {
	
	public static final int INI_LIFES=8;
    public static final int SPEED=4;
	
    public Sporty() {
    	super();
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
	
}