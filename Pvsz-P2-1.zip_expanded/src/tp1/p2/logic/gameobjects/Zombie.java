package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public abstract class Zombie extends GameObject{
	
	protected int speed;
	public static final int DANO_DEFAULT=1;
    public static final int INI_LIFES_DEFAULT=5;
    public static final int SPEED_DEFAULT=2;
	
	public Zombie() {
		super();
		this.defaultIni();
	}

	public Zombie(GameWorld game, int col, int row) {
		super(game, col, row);
		this.defaultIni();
	}

	private void defaultIni() {
		this.lifes=INI_LIFES_DEFAULT;
		this.damage=DANO_DEFAULT;
		this.speed=SPEED_DEFAULT;
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public int getCoste() {
		return 0;
	}

	
	private void advance() {
		if(this.cycles%this.speed==0 ) {
			this.col--;
			if(this.hasArrive()) {
				game.zombiesWin();
			}
		}
	}
	
	@Override
	public void onEnter() {
		cycles=0;
	}

	@Override
	public void onExit() {
		game.reduceZombie();
	}
	
	
	public void update() {
		if(this.isAlive()) {
			GameItem obj=game.getGameItemInPosition(col-1, row);
			if(obj==null) {
				advance();
			}
			else {
				obj.receiveZombieAttack(this.damage);
			}
		}
	}
	

	@Override
	public String getDescription() {
		return String.format(Messages.ZOMBIE_DESCRIPTION,this.getName(), this.speed, this.damage, this.getIniLifes());
	}
	
	public int getCycles() {
		return cycles;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		this.lifes-=damage;
		game.playerWin();
		return true;
	}

	@Override
	public boolean hasArrive() {
		return this.isInPosition(-1, this.row);
	}
	
	public boolean catchSun() {
		return false;
	}
	
	abstract public int getIniLifes();

}
