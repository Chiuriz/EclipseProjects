package it.rocco.tilegame;

import it.rocco.tilegame.display.Display;

public class Launcher {

	public static void main (String[] args) {
			
		Game game = new Game ("Tile Game", 640, 360); //creo un'istanza della classe "Game"
		game.start(); //richiamo il metodo start della classe game
			
	}
}
