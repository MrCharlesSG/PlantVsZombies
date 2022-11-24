package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class DefaultZombie extends Zombie{

	public DefaultZombie() {
		super();
	}
	
	@Override
	protected String getSymbol() {
		return Messages.ZOMBIE_SYMBOL;
	}

	@Override
	public String getName() {
		return Messages.ZOMBIE_NAME;
	}

	@Override
	public int getIniLifes() {
		// TODO Auto-generated method stub
		return INI_LIFES_DEFAULT;
	}
	
}
