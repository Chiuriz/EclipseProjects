package it.rocco.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static final int widht = 32, height = 32;
	public static BufferedImage player, dirt, grass, stone, tree;
	
	public static void init () {
		
		//creo un oggetto della classe "SpriteSheet" e gli passo come parametro il metodo di caricamento immagini della classe "ImageLoader"
		SpriteSheet sheet = new SpriteSheet (ImageLoader.loadImage("/textures/sheet.png"));
		
		player = sheet.crop(0, 0, widht, height);
		dirt = sheet.crop(widht, 0, widht, height);
		grass = sheet.crop(widht * 2, 0, widht, height);
		stone = sheet.crop(widht * 3, 0, widht, height);
		tree = sheet.crop(0, height, widht, height);
		
		

	}
	
}
