package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Item.Item;
import modele.Personnage.Hero.Hero;

public class vuePersonnage {
	
	
	private Pane pane;
	private Image img_perso;
	private FileInputStream fichierPerso;
	private String s;
	
	private ImageView imgV_perso;
	
	public vuePersonnage(Pane pane, Hero hero) throws FileNotFoundException {
		this.pane = pane;
		this.s=hero.action();
		this.fichierPerso = new FileInputStream(this.add());
		this.img_perso = new Image(fichierPerso);
		imgV_perso = new ImageView(img_perso);
		initPerso();
	}
	
	public void initPerso() throws FileNotFoundException{
		//imgV_perso.setViewport(new Rectangle2D(0,0,128,128));
		
		
		this.pane.getChildren().add(this.imgV_perso);
	}
	
	public void setStr(String s) {
		this.s=s;
	}
	public String getString() {
		return this.s;
	}
	public void removeImage() {
		this.pane.getChildren().remove(imgV_perso);
	}
	
	public void setImageV() throws FileNotFoundException {
		this.imgV_perso.setImage(new Image(this.setFile()));
		this.pane.getChildren().remove(imgV_perso);
		this.pane.getChildren().add(this.imgV_perso);
	}
	
	public String add() {
		return "src/ressources/ImagePerso/" + this.s+".png";
	}
	public FileInputStream setFile() throws FileNotFoundException {
		return this.fichierPerso = new FileInputStream(this.add());
		
	}
	
//	public void changerImage(String s , int x, int y) throws FileNotFoundException {
//		this.fichierPerso = new FileInputStream("src/ressources/ImagePerso/" + s +".png");
//		this.img_perso = new Image(this.fichierPerso);
//		this.pane.getChildren().remove(this.imgV_perso);
//		this.pane.getChildren().add(new ImageView(img_perso));
//		
//	}
	

	
	
	
	
	
	
	/*public void deplacementX (int deplacement) {
		imgV_perso.setTranslateX(imgV_perso.getTranslateX()+deplacement);
	}
	public void deplacementY (int deplacement) {
		imgV_perso.setTranslateY(imgV_perso.getTranslateY()+deplacement);
	}*/
//	public void setImage () throws FileNotFoundException {
//		this.pane.getChildren().clear();//		this.fichierPerso = new FileInputStream("src/ressources/NewPiskel(1).png");
//		this.img_perso = new Image(fichierPerso);
//		imgV_perso=new ImageView(img_perso);
//		initPerso();
//	}
	public ImageView getImgVPerso () {
		return this.imgV_perso;
	}
	
}
