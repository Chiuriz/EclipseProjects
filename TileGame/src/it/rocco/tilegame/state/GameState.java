package it.rocco.tilegame.state;

import java.awt.Graphics;

import it.rocco.tilegame.gfx.Assets;


/* questa classe estende la classe "State"
 * Siccome la classe "State" e' una classe astratta
 * questa classe (GameState) dovrà obbligatoriamente
 * contenere i metodi astratti della classe che estende.
 * (public void tick) e (public void render) che andranno
 * chiaramente in Override. */


public class GameState extends State {

	public GameState() {
		
	}
	
	
	
	
	@Override
	public void tick() {

		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dirt, 0, 0, null);
		
	}
		

}
