package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Movable.Movable;
import modele.Personnage.Hero.Hero;

public class vuePersonnage extends Vue{
	
	
	
	
	public vuePersonnage(Pane pane, Movable hero) {
		super(pane);
		this.s=hero.action();
		this.img_perso = new Image(this.add());
		imgV_perso = new ImageView(img_perso);
		initPerso();
	}
	
	public void initPerso() {
		
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
	
	public void setImageV(){
		this.imgV_perso.setImage(new Image("/ressources/ImagePerso/" + this.s+".png"));
		this.pane.getChildren().remove(imgV_perso);
		this.pane.getChildren().add(this.imgV_perso);
	}
	
	public String add() {
	System.out.println("/ressources/ImagePerso/" + this.s+".png");
		return "/ressources/ImagePerso/" + this.s+".png";
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

	@Override
	public void clear() {
	this.pane.getChildren().remove(this.imgV_perso);
		
	}
	
}
