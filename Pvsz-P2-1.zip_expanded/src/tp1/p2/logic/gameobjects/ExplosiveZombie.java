package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.view.Messages;

public class ExplosiveZombie extends Zombie{
	
	public static final int DANO=1;
    public static final int INI_LIFES=5;
    public static final int EXPLOSION=10;
	
    public static final int SPEED=2;
    
	public ExplosiveZombie() {
		super();
		this.lifes=INI_LIFES;
		this.damage=DANO;
	}
	
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public int getCoste() {
		return 0;
	}

	@Override
	protected String getSymbol() {
		return Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
	}

	@Override
	public String getDescription() {
		String icon=String.format(Messages.ZOMBIE_DESCRIPTION, getName(), SPEED, DANO, INI_LIFES);
		return icon;
	}

	private void avanza() {
		if(this.cycles%SPEED==0) {
			this.col--;
		}
		cycles++;
	}
	
	@Override
	public void onEnter() {
		cycles=0;
		game.aumentaNumOfZombies();
	}

	@Override
	public void onExit() {
		new ExplosionAction(row,col,EXPLOSION).execute(game);
		game.reduceZombie();
	}
	
	
	public void update() {
		GameItem obj=game.getGameItemInPosition(col-1, row);
		if(obj==null) {
			avanza();
		}
		else {
			if(obj.receiveZombieAttack(DANO)) {
				if(!obj.isAlive()) {
					game.eliminar(obj);
					onExit();
				}
			}
		}
	}
	

	public int getCycles() {
		return cycles;
	}


	@Override
	public boolean receivePlantAttack(int damage) {
		this.lifes-=damage;
		return true;
	}

	@Override
	public boolean haLlegado() {
		return this.isInPosition(-1, this.row);
	}
	

	@Override
	public String getName() {
		return Messages.EXPLOSIVE_ZOMBIE_NAME;
	}
	
}