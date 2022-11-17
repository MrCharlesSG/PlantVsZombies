package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class ZombieCommon extends Zombie {
	
	ZombieCommon(){
		super();
	}

	@Override
	protected String getSymbol() {
		return Messages.ZOMBIE_SYMBOL;
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION;
	}

	@Override
	public String getName() {
		return Messages.ZOMBIE_NAME;
	}

	@Override
	public int getIniLifes() {
		return INI_LIFES_DEFAULT;
	}	
}
