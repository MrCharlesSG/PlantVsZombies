package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.view.Messages;

public class CherryBomb extends Plant {

	public static final int COSTE=50;
	public static final int DANO=10;
    public static final int INI_LIFES=2;
    
    CherryBomb(){
    	super();
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
    }
	
	public CherryBomb(GameWorld game, int col, int row) {
		super(game, col, row);
    	this.lifes=INI_LIFES;
    	this.coste=COSTE;
	}

	@Override
	protected String getSymbol() {
		return Messages.CHERRY_BOMB_SYMBOL;
	}

	@Override
	public String getName() {
		return Messages.CHERRY_BOMB_NAME;
	}
	
	@Override
	protected String getShortcut() {
		return Messages.CHERRY_BOMB_NAME_SHORTCUT;
	}
	
	@Override
	public void update() {
		if(this.cycles==2) {
			game.pushAction(new ExplosionAction(col,row, damage));
			this.lifes=0;
		}
	}

	@Override
	public void onExit() {
		
	}
	
	@Override
	int getIniLifes() {
		// TODO Auto-generated method stub
		return INI_LIFES;
	}

	@Override
	public GameObject create(GameWorld game, int col, int row) {
		GameObject obj=new CherryBomb(game, col, row);
		return obj;
	}



}
