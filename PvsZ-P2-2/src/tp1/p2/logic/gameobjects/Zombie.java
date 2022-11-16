package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.view.Messages;

public class Zombie extends GameObject{
	
	public static final int DANO=1;
    public static final int INI_LIFES=5;

	
	public Zombie() {
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
		return Messages.ZOMBIE_SYMBOL;
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION;
	}

	private void avanza() {
		if(this.cycles%2==0 ) {
			this.col--;
		}
		cycles++;
	}
	
	@Override
	public void onEnter() {
		cycles=0;
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
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
					game.eliminate(obj);
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
	public boolean hasArrive() {
		return this.isInPosition(-1, this.row);
	}
	
	public boolean catchSun() {
		return false;
	}
}
