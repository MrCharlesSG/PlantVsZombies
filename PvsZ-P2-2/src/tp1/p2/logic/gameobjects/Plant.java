package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public abstract class Plant extends GameObject {
	
	Plant(){
		super();
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		lifes-=damage;
		return true;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}
	
	@Override
	public String getDescription() {
		return String.format(Messages.PLANT_DESCRIPTION,getSymbol(), this.coste, this.damage, getIniLifes());
	}

	abstract int getIniLifes();
	
	@Override
	public void onExit() {
		
	}

	public boolean hasArrive() {
		return false;
	}
	
	public boolean catchSun() {
		return false;
	}
}
