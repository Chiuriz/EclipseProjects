package it.rocco.tilegame.state;

import java.awt.Graphics;

import it.rocco.tilegame.Game;

public abstract class State {
	
	
	/* questa parte di codice crea un oggetto 
	 * currentstate che serve per stabilire in
	 * che "state" del programma siamo. Con il 
	 * getter e setter setto e prendo lo stato
	 * corrente.*/

	private static State currentState = null;
	
	public static void setState (State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}

	//class
	
	protected Game game;
	
	public State (Game game) {
		this.game = game;
	}
	
	public abstract void tick ();
	public abstract void render (Graphics g);
	

}
