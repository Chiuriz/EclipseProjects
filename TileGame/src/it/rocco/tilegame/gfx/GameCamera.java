package it.rocco.tilegame.gfx;

import it.rocco.tilegame.Game;
import it.rocco.tilegame.entities.Entity;

public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	
	public GameCamera (Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - game.getWidht() / 2 + e.getWidht() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() /2;
	}
	
	public void move (float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
