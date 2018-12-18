package it.rocco.tilegame.entities;
import java.awt.Graphics;

public abstract class Entity {
	
	protected float x, y;
	protected int widht, height;
	
	
	public Entity (float x, float y, int widht, int height) {	
		this.x = x;
		this.y = y;
		this.widht = widht;
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render (Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidht() {
		return widht;
	}

	public void setWidht(int widht) {
		this.widht = widht;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
