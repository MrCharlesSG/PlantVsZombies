package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.control.exceptions.GameException;
import tp1.p2.control.exceptions.InvalidPositionException;
import tp1.p2.control.exceptions.NotEnoughCoinsException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class PlantFactory {

	/* @formatter:off */
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(),
		new Peashooter(),
		new WallNut(),
		new CherryBomb()
	);
	/* @formatter:on */

	public static boolean isValidPlant(String plantName) {
		for (Plant p : AVAILABLE_PLANTS) {
			if(p.getName().equals(plantName)|| p.getSymbol().equalsIgnoreCase(plantName)) {
				return true;
			}
		}

		return false;
	}

	public static GameObject spawnPlant(String plantName, GameWorld game, int col, int row, boolean consumeCoins) throws GameException {
		game.isValidPosition();
		for(Plant p: AVAILABLE_PLANTS) {
			if(p.getName().toLowerCase().equals(plantName)|| p.getSymbol().toLowerCase().equals(plantName)) {
				if(!consumeCoins){							
					game.tryToBuy(p.getCoste());
					return p.create(game, col, row);	
				}
			}
		}
		return null;
	}

	public static List<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}

	/*
	 * Avoid creating instances of this class
	 */
	private PlantFactory() {
	}
	
	
}
