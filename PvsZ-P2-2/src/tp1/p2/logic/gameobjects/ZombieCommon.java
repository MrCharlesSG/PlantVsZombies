package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ZombieCommon extends Zombie {
	
	ZombieCommon(){
		super();
	}

	public ZombieCommon(GameWorld game, int col, int row) {
		super(game, col, row);
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
		return INI_LIFES_DEFAULT;
	}

	@Override
	public GameObject create(GameWorld game, int col, int row) {
		return new ZombieCommon(game, col, row);
	}	
	
}
