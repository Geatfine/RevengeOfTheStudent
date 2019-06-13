package vue;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VueInventaire {
	
	private HBox inventaire;
	private ArrayList<ImageView> list;
	private Image img = new Image("/ressources/coeur.png");
	private ImageView view = new ImageView(img);
	private String s;
	private int compteur = -1;
	public VueInventaire(HBox inventaire) {
		
		this.inventaire= inventaire;
		this.s="/ressources/vide.png";
		this.list= new ArrayList<>();
		this.remplir();
		this.inventaire.setMaxHeight(320);
		this.inventaire.setMaxWidth(800);
		
	}
	
	public void initInventaire() {
		inventaire.getChildren().add(list.get(this.compteur));
	}
	
	
	public void removeImage() {
		this.inventaire.getChildren().remove(0);
	}
	
	public boolean ajouteImage() {
		if (this.list.size() < this.inventaire.getMaxWidth()/32) {
		ImageView imgView = new ImageView(new Image(s))	;
		this.list.add(imgView);
		this.compteur++;
		return true;
	}
		return false;
	}
	
	public void changerImage(String s) {
		this.s="/ressources/ImagePerso/" +s+".png";
	}
	
	public void remplir() {
		
			
			if (this.ajouteImage())
			this.initInventaire();
	}
	
	
	

}
