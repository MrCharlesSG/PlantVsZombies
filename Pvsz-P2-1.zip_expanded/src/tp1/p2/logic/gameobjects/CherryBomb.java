package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class CherryBomb extends Plant {
	
	public final int COSTE=50;
	public static final int DANO=10;
    public static final int INI_LIFES=2;
    public static final int TIME_TO_EXPLODE=2;
    
    CherryBomb(){
    	super();
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
    	this.damage=DANO;
    }

	@Override
	protected String getSymbol() {
		return Messages.CHERRY_BOMB_SYMBOL;
	}

	@Override
	public String getDescription() {
		String icon=String.format(Messages.PLANT_DESCRIPTION,getName(), COSTE, DANO, INI_LIFES);
		return icon;
	}	
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		this.lifes-=damage;
		return true;
	}
	
	@Override
	public int getCoste() {
		return this.COSTE;
	}

	@Override
	public String getName() {
		return Messages.CHERRY_BOMB_NAME_SHORTCUT;
	}

	@Override
	public void onEnter() {
		
	}
	
	@Override
	public void update() {
		
		if(this.cycles%TIME_TO_EXPLODE==0) {
			//Explotar jijijija
		}
		cycles++;
	}
	
	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

}
