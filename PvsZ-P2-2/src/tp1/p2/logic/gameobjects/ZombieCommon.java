package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class ZombieCommon extends Zombie {

	public static final int DANO=1;
    public static final int INI_LIFES=5;
    public static final int VELOCIDAD=1;
	
	ZombieCommon(){
		this.lifes=INI_LIFES;
		this.damage=DANO;
		this.velocidad=VELOCIDAD;
	}

	@Override
	protected String getSymbol() {
		return Messages.ZOMBIE_SYMBOL;
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION;
	}

	@Override
	protected boolean frecuencyOfRun() {
		return cycles%2==0;
	}

	@Override
	public String getName() {
		return Messages.ZOMBIE_NAME;
	}	
}
