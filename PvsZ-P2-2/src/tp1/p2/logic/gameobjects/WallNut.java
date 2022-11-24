package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class WallNut extends Plant {

	public static final int COSTE=50;
    public static final int INI_LIFES=10;

    
    WallNut(){
    	super();
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
    }
	
	public WallNut(GameWorld game, int col, int row) {
		super(game, col, row);
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
	}

	@Override
	public String getSymbol() {
		return Messages.WALL_NUT_SYMBOL;
	}
	
	@Override
	protected String getShortcut() {
		return Messages.WALL_NUT_NAME_SHORTCUT;
	}
	@Override
	public String getName() {
		return Messages.WALL_NUT_NAME;
	}
	
	@Override
	int getIniLifes() {
		return INI_LIFES;
	}

	

	@Override
	public void update() {
	}

	@Override
	public GameObject create(GameWorld game, int col, int row) {
		GameObject obj= new WallNut( game,  col,  row);
		return obj;
	}
	
}
