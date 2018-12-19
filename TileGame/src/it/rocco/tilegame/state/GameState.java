package it.rocco.tilegame.state;

import java.awt.Graphics;

import it.rocco.tilegame.Game;
import it.rocco.tilegame.Handler;
import it.rocco.tilegame.entities.creatures.Player;
import it.rocco.tilegame.tiles.Tile;
import it.rocco.tilegame.worlds.World;

/* questa classe estende la classe "State"
 * Siccome la classe "State" e' una classe astratta
 * questa classe (GameState) dovrà obbligatoriamente
 * contenere i metodi astratti della classe che estende.
 * (public void tick) e (public void render)*/

public class GameState extends State {
	
	private Player player;
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World (handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler,100,100);
		
		
		
	}

	@Override
	public void tick() {
		player.tick();	
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		
	}
		
}
