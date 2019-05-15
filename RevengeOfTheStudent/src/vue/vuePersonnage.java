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
	
	public vuePersonnage(Pane pane) throws FileNotFoundException {
		this.pane = pane;
		this.fichierPerso = new FileInputStream("src/ressources/NewPiskel.png");
		this.personnage = new Image(fichierPerso);
	}
	
	public void initPerso() throws FileNotFoundException{
		ImageView perso = new ImageView(personnage);
		perso.setViewport(new Rectangle2D(0,0,128,128));
		perso.setLayoutY(308);
		this.pane.getChildren().add(perso);
	}

}
