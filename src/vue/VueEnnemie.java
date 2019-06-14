package vue;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import modele.Movable.Movable;

public class VueEnnemie extends Vue{
	
	private Label label;
	
	 public VueEnnemie(Pane pane, Movable mechant) {
		super(pane);
		this.s=mechant.action()+"Gauche";

		this.img_perso = new Image(this.concatenation());
		imgV_perso = new ImageView(img_perso);
		this.label = new Label();
		label.setTextFill(Color.web("#ff0000", 0.8));
		initPerso();
		this.label.textProperty().bind(mechant.hpProperty().asString());
	}
	
	public void initPerso() {
		this.pane.getChildren().add(this.imgV_perso);
		this.pane.getChildren().add(this.label);
	}
	
	public void setStr(String s) {
		this.s=s;
	}
	public String getString() {
		return this.s;
	}
	public void removeImage() {
		this.pane.getChildren().remove(imgV_perso);
		this.pane.getChildren().remove(this.label);
	}
	
	public void setImageV() {
		
			this.imgV_perso.setImage(new Image(this.concatenation()));
		
		this.pane.getChildren().remove(imgV_perso);
		this.pane.getChildren().add(this.imgV_perso);
	}
	
	public String concatenation() {
		return "/ressources/ImagePerso/" + this.s+".png";
	}
	
	
//	public void changerImage(String s , int x, int y) throws FileNotFoundException {
//		this.fichierPerso = new FileInputStream("src/ressources/ImagePerso/" + s +".png");
//		this.img_perso = new Image(this.fichierPerso);
//		this.pane.getChildren().remove(this.imgV_perso);
//		this.pane.getChildren().add(new ImageView(img_perso));
//		
//	}
	

	public Label getLabel () {
		return this.label;
	}
	
	
	
	
	
	
	
	
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
