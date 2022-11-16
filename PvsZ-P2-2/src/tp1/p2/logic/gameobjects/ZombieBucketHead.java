package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class ZombieBucketHead extends Zombie{

	@Override
	protected boolean frecuencyOfRun() {
		return this.cycles%4==0;
	}

	@Override
	protected String getSymbol() {
		return Messages.BUCKET_HEAD_ZOMBIE_SYMBOL;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
