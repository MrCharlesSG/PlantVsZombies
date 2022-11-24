package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

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
			if(p.getName().equals(plantName)) {
				return true;
			}
		}

		return false;
	}

	public static GameObject spawnPlant(String plantName, GameWorld game, int col, int row, boolean consumeCoins) {
		if(GameObject.posValida(col, row, GameWorld.NUM_COLS, GameWorld.NUM_ROWS)){
			if(!game.isFullyOcuppied(col, row)) {
				for(Plant p: AVAILABLE_PLANTS) {
					if(p.getName().toLowerCase().equals(plantName)|| p.getSymbol().toLowerCase().equals(plantName)) {
						if(game.esSuficiente(p.getCoste())|| !consumeCoins) {
							return p.create(game, col, row);	
						}
					}
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
