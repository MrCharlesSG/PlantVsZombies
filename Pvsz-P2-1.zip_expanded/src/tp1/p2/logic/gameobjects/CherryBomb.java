package tp1.p2.logic.gameobjects;

import tp1.p2.logic.actions.ExplosionAction;
import tp1.p2.view.Messages;

public class CherryBomb extends Plant {
	
	public static final int COSTE=50;
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
	public int getCoste() {
		return COSTE;
	}

	@Override
	public String getShortcut() {
		return Messages.CHERRY_BOMB_NAME_SHORTCUT;
	}
	
	@Override
	public String getName() {
		return Messages.CHERRY_BOMB_NAME;
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
		new ExplosionAction(row,col,damage).execute(game);
	}

	@Override
	int getIniLifes() {
		return INI_LIFES;
	}


}
