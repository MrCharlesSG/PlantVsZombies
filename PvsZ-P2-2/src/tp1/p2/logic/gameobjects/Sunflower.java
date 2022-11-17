package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	public static final int COSTE=20;
	public static final int DANO=1;
    public static final int INI_LIFES=3;
    public static final int NUMERO_SOLES_GENERADOS=1;
    
    Sunflower(){
    	super();
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
    }

	@Override
	public String getSymbol() {
		return Messages.SUNFLOWER_SYMBOL;
	}
	
	@Override
	protected String getShortcut() {
		return Messages.SUNFLOWER_NAME_SHORTCUT;
	}
	
	@Override
	public String getName() {
		return Messages.SUNFLOWER_NAME;
	}
	
	@Override
	public void update() {
		if(this.cycles%3==0) {
			game.GeneraSunCoins(NUMERO_SOLES_GENERADOS);
		}
	}

	@Override
	int getIniLifes() {
		return INI_LIFES;
	}

	
}
