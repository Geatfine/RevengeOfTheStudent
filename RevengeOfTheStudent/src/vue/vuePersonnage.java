package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Personnage;

public class vuePersonnage {
	
	
	private Pane pane;
	private Image img_perso;
	private FileInputStream fichierPerso;
	private ImageView imgV_perso;
	private Personnage perso;
	
	public vuePersonnage(Pane pane) throws FileNotFoundException {
		this.pane = pane;
		this.fichierPerso = new FileInputStream("src/ressources/NewPiskel.png");
		this.img_perso = new Image(fichierPerso);
		imgV_perso = new ImageView(img_perso);
		this.perso = new Personnage("NomTest");
		perso.setPosition(250, 400);
	}
	
	public void initPerso() throws FileNotFoundException{
		imgV_perso.setViewport(new Rectangle2D(0,0,128,128));
		
		this.pane.getChildren().add(imgV_perso);
	}
	public void deplacementX (int deplacement) {
		perso.setPositionX(perso.getCoordX()+deplacement);
	}
}
