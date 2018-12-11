package it.rocco.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player, dirt, grass, stone, tree;
	
	public static void init () {
		
		//creo un oggetto della classe "SpriteSheet" e gli passo come parametro il metodo di caricamento immagini della classe "ImageLoader"
		SpriteSheet sheet = new SpriteSheet (ImageLoader.loadImage("/textures/sheet2"));
		
	}
	
}
