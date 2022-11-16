package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	public final int COSTE=20;
	public static final int DANO=1;
    public static final int INI_LIFES=3;
    public static final int NUMERO_SOLES_GENERADOS=10;
	
	protected int numSolesGenera;
    
    Sunflower(){
    	super();
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
    	this.numSolesGenera=NUMERO_SOLES_GENERADOS;
    }

	@Override
	public String getSymbol() {
		return Messages.SUNFLOWER_SYMBOL;
	}
	
	@Override
	public String getDescription() {
		return String.format(Messages.PLANT_DESCRIPTION,getSymbol(), COSTE, DANO, INI_LIFES);
	}

	@Override
	public int getCoste() {
		return this.COSTE;
	}
	
	public String getName() {
		return Messages.SUNFLOWER_NAME;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update() {
		if(this.cycles%2==0) {
			game.GeneraSunCoins(NUMERO_SOLES_GENERADOS);
		}
		
	}
}
