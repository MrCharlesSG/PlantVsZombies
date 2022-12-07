package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.view.Messages;

public class ZombieExplosive extends Zombie{

	public static int EXPLOSION_DAMAGE=3;
	
	public ZombieExplosive() {
		super();
	}
	
	public ZombieExplosive(GameWorld game, int col, int row) {
		super(game, col, row);
	}

	@Override
	protected String getSymbol() {
		return Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
	}

	@Override
	public String getName() {
		return Messages.EXPLOSIVE_ZOMBIE_NAME;
	}
	
	@Override
	public void onExit() {
		game.pushAction(new ExplosionAction(col,row, EXPLOSION_DAMAGE, false));
		game.reduceZombie();
	}

	@Override
	public int getIniLifes() {
		return INI_LIFES_DEFAULT;
	}

	@Override
	public GameObject create(GameWorld game, int col, int row) {
		return new ZombieExplosive(game, col, row);
	}

}
