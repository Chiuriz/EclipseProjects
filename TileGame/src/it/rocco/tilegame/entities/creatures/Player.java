package it.rocco.tilegame.entities.creatures;

import java.awt.Graphics;

import it.rocco.tilegame.Game;
import it.rocco.tilegame.gfx.Assets;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		if (game.getKeyManager().up)
			y -= 3;
		if (game.getKeyManager().down)
			y += 3;
		if (game.getKeyManager().left)
			x -= 3;
		if (game.getKeyManager().right)
			x += 3;
	}

	@Override
	/* uso il cast (int) perchè il metodo drawImage prende in ingresso int mentre
	 * x ed y di queste classi sono float (vedi classe madre Entity) */
	
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null); 
	}

}
