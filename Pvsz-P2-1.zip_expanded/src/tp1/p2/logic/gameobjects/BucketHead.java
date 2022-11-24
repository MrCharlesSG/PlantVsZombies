package tp1.p2.logic.gameobjects;

import tp1.p2.view.Messages;

public class BucketHead extends Zombie {
	
	 public static final int INI_LIFES=8;
	   public static final int SPEED=4;

		public BucketHead() {
			super();
			this.lifes=INI_LIFES;
			this.speed=SPEED;
		}
		
		
		@Override
		public boolean receiveZombieAttack(int damage) {
			return false;
		}

		@Override
		public int getCoste() {
			return 0;
		}

		@Override
		protected String getSymbol() {
			return Messages.BUCKET_HEAD_ZOMBIE_SYMBOL;
		}

		@Override
		public String getName() {
			return Messages.BUCKET_HEAD_ZOMBIE_NAME;
		}

		@Override
		public int getIniLifes() {
			return INI_LIFES;
		}
}