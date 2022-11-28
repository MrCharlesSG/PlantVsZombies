package tp1.p2.logic;

public interface GameStatus {

	int getCycle();

	int getSuncoins();

	String positionToString(int col, int row);

	// TODO add your code here
	public boolean ganador();
	
	public boolean isFinished();
	
	public int getRemainingZombies();
	
	public boolean isPlayerQuits();
	
	public int getGeneratedSuns();
	
	public int getCaughtSuns();
}
