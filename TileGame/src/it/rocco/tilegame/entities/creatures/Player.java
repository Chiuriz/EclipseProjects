package it.rocco.tilegame.entities.creatures;

import java.awt.Graphics;

import it.rocco.tilegame.Game;
import it.rocco.tilegame.Handler;
import it.rocco.tilegame.gfx.Assets;
import it.rocco.tilegame.tiles.Tile;

public class Player extends Creature {
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	public void getInput () {
		/* riesco ad avere l'accesso a queste variabili della classe Creature perchè QUESTA classe (Player)
		 * estende la classe Creature e sono variabili di tipo PROTECTED. Le variabili protected sono
		 * accessibili da una classe che estende la classe che le contengono (se fossero PRIVATE non 
		 * avrei avuto l'accesso). */
		xMove = 0; 
		yMove = 0;
		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;

	}

	@Override
	/* uso il cast (int) perchè il metodo drawImage prende in ingresso int mentre
	 * x ed y di queste classi sono float (vedi classe madre Entity) */
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), 
									(int) (y - handler.getGameCamera().getyOffset()), widht, height, null); 
	}

}
