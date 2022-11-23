package tp1.p2.logic.gameobjects;

import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.view.Messages;

public class ExplosiveZombie extends Zombie{
	
	public static int EXPLOSION_DAMAGE;
	
	public ExplosiveZombie() {
		super();
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
		game.pushAction(new ExplosionAction(col,row, EXPLOSION_DAMAGE));
		game.reduceZombie();
	}

	@Override
	public int getIniLifes() {
		return INI_LIFES_DEFAULT;
	}
	
}