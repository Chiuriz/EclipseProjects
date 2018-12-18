package it.rocco.tilegame.tiles;

import java.awt.image.BufferedImage;
import it.rocco.tilegame.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.stone, id);	
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
