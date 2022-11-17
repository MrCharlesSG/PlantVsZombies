package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class WallNut extends Plant{

	public final int COSTE=50;
	public static final int DANO=0;
    public static final int INI_LIFES=10;
    
	@Override
	protected String getSymbol() {
		return Messages.WALL_NUT_SYMBOL;
	}

	@Override
	public String getDescription() {
		String icon=String.format(Messages.PLANT_DESCRIPTION,getName(), COSTE, DANO, INI_LIFES);
		return icon;
	}

	public String getName() {
		return Messages.WALL_NUT_NAME_SHORTCUT;
	}
	
	@Override
	public int getCoste() {
		return this.COSTE;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}