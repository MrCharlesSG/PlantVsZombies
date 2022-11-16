package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.view.Messages;

public abstract class Zombie extends GameObject{
	
	protected int velocidad;
	
	public Zombie() {
		super();
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public int getCoste() {
		return 0;
	}


	protected abstract boolean frecuencyOfRun();
	
	private void advance() {
		if(frecuencyOfRun() ) {
			this.col-=this.velocidad;
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
			advance();
		}
		else {
			if(obj.receiveZombieAttack(this.damage)) {
				if(!obj.isAlive()) {
					game.eliminate(obj);
				}
			}
		}
	}
	

	@Override
	public String getDescription() {
		return Messages.format(Messages.ZOMBIE_DESCRIPTION,)
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
