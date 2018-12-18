package it.rocco.tilegame.state;

import java.awt.Graphics;

import it.rocco.tilegame.Game;
import it.rocco.tilegame.entities.creatures.Player;
import it.rocco.tilegame.gfx.Assets;

/* questa classe estende la classe "State"
 * Siccome la classe "State" e' una classe astratta
 * questa classe (GameState) dovrà obbligatoriamente
 * contenere i metodi astratti della classe che estende.
 * (public void tick) e (public void render) che andranno
 * chiaramente in Override. */

public class GameState extends State {
	
	private Player player;

	public GameState(Game game) {
		super(game);
		player = new Player(game,100,100);
	}

	@Override
	public void tick() {
		player.tick();		
	}

	@Override
	public void render(Graphics g) {
		player.render(g);		
	}
		
}
