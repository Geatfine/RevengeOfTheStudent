package vue;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class VueInventaire {
	
	private TilePane inventaire;
	private ArrayList<ImageView> list;
	private Image img = new Image("/ressources/coeur.png");
	private ImageView view = new ImageView(img);
	private String s;
	private int compteur = -1;
	public VueInventaire(TilePane inventaire) {
		
		this.inventaire= inventaire;
		this.s="/ressources/vide.png";
		this.list= new ArrayList<>();
		this.remplir();
		this.inventaire.setMaxHeight(320);
		this.inventaire.setMaxWidth(800);
		this.inventaire.setVisible(false);
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
	
	public void reduireOpacité(int x , int y ) {
		inventaire.setOpacity(0.5);
	}
	

}
