package tp1.p2.logic.actions;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Zombie;

public class ExplosionAction implements GameAction {

	private int col;

	private int row;

	private int damage;

	public ExplosionAction(int col, int row, int damage) {
		this.col = col;
		this.row = row;
		this.damage = damage;
	}

	@Override
	public void execute(GameWorld game) {
		for(int i=this.col-1;i<=this.col+1;i++) {
			for(int j=this.row-1;j<=this.row+1;j++) {
				GameItem obj = game.getGameItemInPosition(i, j);
				if(!obj.receivePlantAttack(damage)) {
					obj.receiveZombieAttack(damage);
				}
			}
		}
	}
}
