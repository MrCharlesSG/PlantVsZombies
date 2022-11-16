package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

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
	abstract protected String getSymbol();

	@Override
	abstract public String getDescription();
	
	abstract public String getName();
	
	abstract public int getCoste();

	abstract public void onEnter();

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
