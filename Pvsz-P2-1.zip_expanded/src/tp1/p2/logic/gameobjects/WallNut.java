package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class WallNut extends Plant{

	public static final int COSTE=50;
	public static final int DANO=0;
    public static final int INI_LIFES=10;
    
	@Override
	protected String getSymbol() {
		return Messages.WALL_NUT_SYMBOL;
	}

	public String getShortcut() {
		return Messages.WALL_NUT_NAME_SHORTCUT;
	}
	
	@Override
	public int getCoste() {
		return COSTE;
	}
	
	@Override
	public int getIniLifes() {
		return INI_LIFES;
	}

	@Override
	public String getName() {
		return Messages.WALL_NUT_NAME;
	}

	@Override
	public void update() {}
	
}