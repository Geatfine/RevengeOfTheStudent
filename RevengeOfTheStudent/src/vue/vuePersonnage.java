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
	
	public vuePersonnage(Pane pane) throws FileNotFoundException {
		this.pane = pane;
		this.fichierPerso = new FileInputStream("src/ressources/NewPiskel.png");
		this.img_perso = new Image(fichierPerso);
		imgV_perso = new ImageView(img_perso);
		initPerso();
	}
	
	public void initPerso() throws FileNotFoundException{
		//imgV_perso.setViewport(new Rectangle2D(0,0,128,128));
		
		this.pane.getChildren().add(imgV_perso);
	}
	
	
	/*public void deplacementX (int deplacement) {
		imgV_perso.setTranslateX(imgV_perso.getTranslateX()+deplacement);
	}
	public void deplacementY (int deplacement) {
		imgV_perso.setTranslateY(imgV_perso.getTranslateY()+deplacement);
	}*/
//	public void setImage () throws FileNotFoundException {
//		this.pane.getChildren().clear();
//		this.fichierPerso = new FileInputStream("src/ressources/NewPiskel(1).png");
//		this.img_perso = new Image(fichierPerso);
//		imgV_perso=new ImageView(img_perso);
//		initPerso();
//	}
	public ImageView getImgVPerso () {
		return this.imgV_perso;
	}
	
}
