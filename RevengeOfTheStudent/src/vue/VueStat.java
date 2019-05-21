package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.sun.javafx.geom.Rectangle;
import com.sun.prism.paint.Color;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Personnage;

public class VueStat {
	
	private Pane stats;
	private Image imgCoeur;
	private Personnage perso;
	private FileInputStream fichierPerso;
	 
	
	public VueStat(Pane p, Personnage perso) throws FileNotFoundException {
		this.stats = p;
		this.perso=perso;
		this.fichierPerso = new FileInputStream("src/ressources/coeur.png");
		this.imgCoeur = new Image(fichierPerso);
		ImageView imgV_Coeur = new ImageView(imgCoeur);
		
	}
	
	public void initialiserVueStat () {
	}
	

}
