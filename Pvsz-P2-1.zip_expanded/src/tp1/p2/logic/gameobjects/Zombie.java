package tp1.p2.logic.gameobjects;

public abstract class Zombie extends GameObject {
	
	Zombie(){
		super();
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	
	@Override
	public boolean receivePlantAttack(int damage) {
		this.lifes-=damage;
		return true;
	}
	
	abstract protected String getSymbol();
	
	abstract public String getDescription();

	abstract public String getName();
	
	abstract public void onEnter();

	abstract public void onExit();

	public boolean haLlegado() {//No se si dejarlo aqui o que cada zombie implemente el suyo, no creo que tenga sentido hacerlo para todos
		return this.isInPosition(-1, this.row);
	}
	
}