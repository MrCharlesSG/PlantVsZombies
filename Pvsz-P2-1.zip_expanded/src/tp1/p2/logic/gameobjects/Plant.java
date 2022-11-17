package tp1.p2.logic.gameobjects;

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

	abstract public String getDescription();
	
	abstract public String getName();
	
	abstract public int getCoste();

	abstract public void onEnter();
	
	abstract public void onExit();

	public boolean haLlegado() {
		return false;
	}
}
