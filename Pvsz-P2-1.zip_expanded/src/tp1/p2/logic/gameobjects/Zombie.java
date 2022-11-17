package tp1.p2.logic.gameobjects;

public abstract class Zombie extends GameObject {
	
	protected int SPEED=2;
	
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

	public void frequencyOfRun() {
		if(this.cycles%SPEED==0) {
			this.col--;
		}
		this.cycles++;
	}
	
	public boolean haLlegado() {
		return this.isInPosition(-1, this.row);
	}
	
}