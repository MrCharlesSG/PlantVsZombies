package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	public static final int COSTE=20;
	public static final int DANO=1;
    public static final int INI_LIFES=1;
    
    Sunflower(){
    	super();
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
    }

	Sunflower(GameWorld game, int col, int row) {
		super(game, col, row);
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
		if(this.cycles%3==0 && this.cycles!=0) {
			game.generaSunCoins();
		}
	}

	@Override
	int getIniLifes() {
		return INI_LIFES;
	}

	@Override
	public GameObject create(GameWorld game, int col, int row) {
		GameObject obj= new Sunflower( game,  col,  row);
		return obj;
	}

	
}
