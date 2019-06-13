package vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import modele.Personnage.Hero.Hero;

public class ChargeurDImage {
	
	private int width;
	private int pixel;
	private BufferedImage img;
	private HashMap<Integer, WritableImage> imageBuffer;
	private final static int IMAGE_VIDE = 3;
	public ChargeurDImage (String cheminImage, int width, int pixel) {
		try {
			this.img= ImageIO.read(new File(cheminImage).toURI().toURL());
		} catch (IOException e) {
			throw new Error("ERROR WHILE READING IMAGE");
		}
		
		this.width= width;
		this.pixel= pixel;
		this.imageBuffer = new HashMap<Integer, WritableImage>();
	}
	
	public WritableImage getImg(int val) {
		if( val == -1)
			val = IMAGE_VIDE;
		
		if (imageBuffer.get(val) == null) {
			imageBuffer.put(val, SwingFXUtils.toFXImage(img.getSubimage(val%width*pixel, val/width*pixel, pixel, pixel), null));
		}
		return imageBuffer.get(val);
	}
	
	private String nom;

}
