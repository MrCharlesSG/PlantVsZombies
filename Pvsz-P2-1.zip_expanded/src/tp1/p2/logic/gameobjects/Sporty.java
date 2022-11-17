package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.view.Messages;

public class Sporty extends Zombie {
	
	public static final int DANO=1;
    public static final int INI_LIFES=2;
    public static final int SPEED=1;
	
	public Sporty() {
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
		return Messages.SPORTY_ZOMBIE_SYMBOL;
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
		//reducir en numero zombies de zombie manager
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
		return Messages.SPORTY_ZOMBIE_NAME;
	}
	
}