package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
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
		peashooterDispara(row, DANO);
	}
	
	private void peashooterDispara(int row, int DANO) {
		int i=0;
		boolean yaDisparado=false;
		GameItem obj=game.getGameItemInPosition(i, row);
		while(i<GameWorld.NUM_COLS && !yaDisparado) {
			if(obj!=null) {
				if(obj.receiveZombieAttack(DANO)) {
					yaDisparado=true;
				}else {
					i++;
					obj=game.getGameItemInPosition(i,row);
				}
			} 
			else {
				i++;
				obj=game.getGameItemInPosition(i,row);
			}
		}
	}

	@Override
	public GameObject create(GameWorld game, int col, int row) {
		return new Peashooter(game, col, row);
	}



}
