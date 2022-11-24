package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class GameObjectContainer {

	private List<GameObject> gameObjects;

	private int numOfZombies;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
		numOfZombies=0;
	}
	
	// TODO add your code here
	public void addObject(GameObject obj) {
		obj.onEnter();
		gameObjects.add(obj);
	}

	public boolean isEmpty(int col, int row) {
		for (GameObject o: gameObjects) {
			if(o.isInPosition(col, row)) {
				return false;
			}
		}
		return true;
	}
	
	public GameObject isInPosition(int col, int row) {
		for (GameObject o: gameObjects) {
			if(o.isInPosition(col, row)) {
				return o;
			}
		}
		return null;
	}

	public void reset() {
		gameObjects.clear();
	}

	public String positionToString(int col, int row) {
		String pos;
		int i=0, size=gameObjects.size();
		while(i<size) {
			if(gameObjects.get(i).isInPosition(col, row)) {
				pos= gameObjects.get(i).toString();
				if(pos!=null) {
					return pos;
				}
			}
		}
		return Messages.NOTHING_ICON;
	}
	
	public void eliminar(GameItem obj) {
		int i=0, size=gameObjects.size();
		boolean eliminado=false;
		while(i<size && !eliminado) {
			if(obj==gameObjects.get(i)) {
				gameObjects.remove(i);
				eliminado=true;
			}
			else {
				i++;
			}
		}
	}

	public void update() {
		for (GameObject o: gameObjects) {
			o.update();
		}
	}
	
	public boolean finishedGame(int remainigZombies, GameWorld game) {
		if(zombiesLlegan(game)) {
			game.zombiesGanan();
			return true;
		}
		if(remainigZombies==0 && numOfZombies==0) {
			game.jugadorGana();
			return true;
		}
		return false;
	}

	private boolean zombiesLlegan(GameWorld game) {
		for (GameObject o: gameObjects) {
			if(o.haLlegado()) {
				return true;
			}
		}
		return false;
	}

	public void aumentaNumOfZombies() {
		numOfZombies++;
	}
}