package it.rocco.tilegame.entities.creatures;

import java.awt.Graphics;

import it.rocco.tilegame.Game;
import it.rocco.tilegame.gfx.Assets;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	public void getInput () {
		/* riesco ad avere l'accesso a queste variabili della classe Creature perchè QUESTA classe (Player)
		 * estende la classe Creature e sono variabili di tipo PROTECTED. Le variabili protected sono
		 * accessibili da una classe che estende la classe che le contengono (se fossero PRIVATE non 
		 * avrei avuto l'accesso). */
		xMove = 0; 
		yMove = 0;
		if (game.getKeyManager().up)
			yMove = -speed;
		if (game.getKeyManager().down)
			yMove = speed;
		if (game.getKeyManager().left)
			xMove = -speed;
		if (game.getKeyManager().right)
			xMove = speed;
	}

	@Override
	/* uso il cast (int) perchè il metodo drawImage prende in ingresso int mentre
	 * x ed y di queste classi sono float (vedi classe madre Entity) */
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, widht, height, null); 
	}

}
