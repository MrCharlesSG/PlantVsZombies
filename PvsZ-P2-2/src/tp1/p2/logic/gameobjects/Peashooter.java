package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Peashooter extends Plant {
	
	public final int COSTE=50;
	public static final int DANO=1;
    public static final int INI_LIFES=3;
    
    Peashooter(){
    	super();
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
    	this.damage=DANO;
    }

	public Peashooter(GameWorld game, int col, int row) {
		super(game, col, row);
		this.lifes=INI_LIFES;
    	this.coste=COSTE;
    	this.damage=DANO;
	}

	@Override
	protected String getSymbol() {
		return Messages.PEASHOOTER_SYMBOL;
	}	
	
	@Override
	protected String getShortcut() {
		return Messages.PEASHOOTER_NAME_SHORTCUT;
	}
	
	@Override
	public String getName() {
		return Messages.PEASHOOTER_NAME;
	}
	
	@Override
	public int getIniLifes() {
		return INI_LIFES;
	}
	
	@Override
	public void update() {
		peashooterDispara();
	}
	
	private void peashooterDispara() {

		game.peashooterDispara(this.col+1, this.row, DANO);
		
	}

	@Override
	public GameObject create(GameWorld game, int col, int row) {
		return new Peashooter(game, col, row);
	}



}
