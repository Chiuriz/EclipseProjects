package it.rocco.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
		
		public SpriteSheet (BufferedImage sheet) {
			this.sheet = sheet;	
		}
		
		//questo metodo ritaglia una porzione dalla sheet image (secondo i parametri passati) e la ritorna come bufferedimage
		public BufferedImage crop (int x, int y, int widht, int height) {
			 return sheet.getSubimage(x, y, widht, height);
			
		}
	
}
