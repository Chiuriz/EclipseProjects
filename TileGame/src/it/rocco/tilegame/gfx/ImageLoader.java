package it.rocco.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


// classe che carica le immagini dal path e termine l'esecuzione del programma se non carica niente.
public class ImageLoader {
	
	public static BufferedImage loadImage (String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
