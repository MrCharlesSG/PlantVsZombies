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
		StringBuilder buffer=null;
		int i=0, size=gameObjects.size(), cont=0;
		while(i<size && cont<2) {
			if(gameObjects.get(i).isInPosition(col, row)) {
				if(buffer==null) {
					buffer=new StringBuilder();
				}
				buffer.append(gameObjects.get(i).toString());
				cont++;
			}
		}
		if(buffer==null) {
			return Messages.NOTHING_ICON;
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
		int i=0, size=gameObjects.size();
		GameObject aux;
		while (i<size) {
			aux=gameObjects.get(i);
			if(aux.isInPosition(col, row)) {
				if(aux.catchSun()) {
					gameObjects.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public boolean removeDead() {
		boolean result=false;
		int i=0;
		for(GameObject obj: gameObjects) {
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

