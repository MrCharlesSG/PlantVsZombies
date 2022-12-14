package tp1.p2.logic.actions;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;

public class ExplosionAction implements GameAction {

	public class execute {

	}

	private int col;

	private int row;

	private int damage;
	
	private boolean plantExplosion;

	public ExplosionAction(int col, int row, int damage, boolean plantExplosion) {
		this.col = col;
		this.row = row;
		this.damage = damage;
		this.plantExplosion=plantExplosion;
	}

	@Override
	public void execute(GameWorld game) {
		for(int col=this.col-1; col <= this.col+1; col++) {
			for(int row=this.row-1; row<=this.row+1; row++) {
				GameItem o = game.getGameItemInPosition(col, row);
				if(o!=null) {
					if(!plantExplosion) {
						o.receiveZombieExplosion(damage);
					}else {
						o.receivePlantExplosion(damage);
					}

				}
			}
		}
	}

}
