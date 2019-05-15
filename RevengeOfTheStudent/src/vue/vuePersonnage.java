package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vuePersonnage {
	
	
	private Pane pane;
	private Image personnage;
	private FileInputStream fichierPerso;
	private ImageView perso;
	
	public vuePersonnage(Pane pane) throws FileNotFoundException {
		this.pane = pane;
		this.fichierPerso = new FileInputStream("src/ressources/NewPiskel.png");
		this.personnage = new Image(fichierPerso);
		perso = new ImageView(personnage);
	}
	
	public void initPerso() throws FileNotFoundException{
		perso.setViewport(new Rectangle2D(0,0,128,128));
		
		this.pane.getChildren().add(perso);
	}
	public void deplacementX (double deplacement) {
		perso.setTranslateX(perso.getTranslateX()+deplacement);
	}
}
