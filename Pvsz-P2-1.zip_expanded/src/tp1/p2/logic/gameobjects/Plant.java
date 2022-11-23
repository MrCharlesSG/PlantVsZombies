package tp1.p2.logic.gameobjects;

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
	
	abstract protected String getSymbol();

	@Override
	public String getDescription() {
		return String.format(Messages.PLANT_DESCRIPTION,getShortcut(), this.coste, this.damage, getIniLifes());
	}
	
	abstract public int getCoste();
	@Override
	public void onEnter() {}
	@Override
	public void onExit() {}

	public boolean haLlegado() {
		return false;
	}
	
	abstract public String getName();
	
	abstract protected String getShortcut();
	
	abstract int getIniLifes();
}
