package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Personnage.Hero.Hero;
import modele.Personnage.Item.Arme;

public class vuePerso {
	
	
	private Pane pane;
	private Image img_perso;
	private FileInputStream fichierPerso;
	private ImageView imgV_perso;
	private Hero perso;
	
	public vuePerso(Pane pane) throws FileNotFoundException {
		this.pane = pane;
		this.fichierPerso = rechercheImage();
		this.img_perso = new Image(fichierPerso);
		imgV_perso = new ImageView(img_perso);
		this.perso = new Hero("NomTest");
		perso.setPosition(250, 400);
	}
	
	
	
	
	private FileInputStream rechercheImage() throws FileNotFoundException {
	int id = this.perso.armeEquiper().getId();
	
	if(id ==1) {
		return new FileInputStream("src/ressources/NewPiskel.png");
	}
	
	return null;
	}
	




	public void initPerso() throws FileNotFoundException{
		imgV_perso.setViewport(new Rectangle2D(0,0,128,128));
		
		this.pane.getChildren().add(imgV_perso);
	}
	public void deplacementX (int deplacement) {
		perso.setPositionX(perso.getCoordX()+deplacement);
	}
	
	
}


