package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class GameObjectContainer {

	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	// TODO add your code here
	public void addObject(GameObject obj) {
		gameObjects.add(obj);
		obj.onEnter();
	}
	
	public GameObject anObjectInPosition(int col, int row) {
		for (GameObject o: gameObjects) {
			if(o.isInPosition(col, row)) {
				if(o.fillPosition()) {
					return o;
				}
			}
		}
		return null;
	}

	public void reset() {
		gameObjects.clear();
	}
	
	public String positionToString(int col, int row) {
		StringBuilder buffer = new StringBuilder();
		boolean sunPainted = false;
		boolean sunAboutToPaint = false;

		for (GameObject g : gameObjects) {
			if(g.isAlive() && g.getCol() == col && g.getRow() == row) {
				String objectText = g.toString();
				sunAboutToPaint = objectText.indexOf(Messages.SUN_SYMBOL) >= 0;
				if (sunAboutToPaint) {
					if (!sunPainted) {
						buffer.append(objectText);
						sunPainted = true;
					}
				} else {
					buffer.append(objectText);
				}
			}
		}

		return buffer.toString();
	}
	
	public boolean finishedGame(GameWorld game) {
		if(zombiesArrive(game)) {
			game.zombiesWin();
			return true;
		}
		if(game.playerWin()) {
			return true;
		}
		return false;
	}

	private boolean zombiesArrive(GameWorld game) {
		for (GameObject o: gameObjects) {
			if(o.hasArrive()) {
				return true;
			}
		}
		return false;
	}

	public boolean catchSun(int col, int row) {
		int i=0;
		boolean cogido=false;
		GameObject aux;
		while (i<gameObjects.size()) {
			aux=gameObjects.get(i);
			if(aux.isInPosition(col, row)) {
				if(aux.catchSun()) {
					gameObjects.remove(i);
					cogido=true;
				}
			}
			i++;
		}
		return cogido;
	}

	public boolean removeDead() {
		boolean result=false;
		for(int i=0;i< gameObjects.size(); i++) {
			GameObject obj= gameObjects.get(i);
			if(!obj.isAlive()) {
				obj.onExit();
				gameObjects.remove(i);
				
				result=true;
			}	
			i++;
		}
		return result;
	}

	public void update() {
		// Can't use for-each loop (for(GameObject g : gameObjexts)) without errors.
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			if(g.isAlive()) {
				g.update();
				g.addCycle();
			}
		}
	}

	public boolean isFullyOccupied(int col, int row) {
		int i=0;
		boolean fullyOcuppied = false;

		while (i<gameObjects.size() && !fullyOcuppied) {
			GameObject g = gameObjects.get(i);
			if (g.isAlive() && g.isInPosition(col, row)) {
				fullyOcuppied = g.fillPosition();
			}
			i++;
		}

		return fullyOcuppied;
	}

	// TODO add your code here

}

