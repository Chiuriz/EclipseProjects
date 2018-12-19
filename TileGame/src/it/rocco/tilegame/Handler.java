package it.rocco.tilegame;

import it.rocco.tilegame.gfx.GameCamera;
import it.rocco.tilegame.input.KeyManager;
import it.rocco.tilegame.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	public Handler (Game game) {
		this.game = game;
		
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidht();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
