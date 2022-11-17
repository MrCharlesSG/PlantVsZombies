package tp1.p2.logic.actions;

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
		// TODO add your code here
		int[] array = {-1,-1,1,1,1,1,-1,-1};//Array para recorrer el area de la explosion
		int x = this.row, y = this.col;
		int inicio=y-1;
		boolean vuelta=false;
		while(!vuelta) {
			
			
			
			
		}
	}

}
