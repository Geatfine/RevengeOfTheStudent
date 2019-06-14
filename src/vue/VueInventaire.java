package vue;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class VueInventaire {

	private TilePane inventaire;
	private ArrayList<ImageView> list;
	private Image img = new Image("/ressources/coeur.png");
	private ImageView view = new ImageView(img);
	private String s;
	private int compteur = -1;

	public VueInventaire(TilePane inventaire) {

		this.inventaire = inventaire;
		this.s = "/ressources/ImagePerso/" + "Katana" + ".png";
		this.list = new ArrayList<>();
		this.inventaire.setMaxHeight(32);
		this.inventaire.setMaxWidth(288);
		inventaire.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.remplir();
	}

	public void initInventaire() {
		inventaire.getChildren().add(list.get(this.compteur));
	}

	public void removeImage() {
		this.inventaire.getChildren().remove(this.list.size() - 1);
	}

	public boolean ajouteImage() {
		if (this.list.size() < this.inventaire.getMaxWidth() / 32 && this.list.size() < 9) {
			ImageView imgView = new ImageView(new Image(s));
			this.list.add(imgView);
			this.compteur++;
			return true;
		}
		return false;
	}

	public void changerImage(String s) {
		this.s = "/ressources/ImagePerso/" + "Katana" + ".png";
	}

	public void remplir() {
		if (this.ajouteImage())
			this.initInventaire();
	}

	public void reduireOpacité(int x, int y) {
		inventaire.setOpacity(0.5);
	}

	public int getCompteur() {
		return this.compteur;
	}

	public boolean verifieSiCoordonneeExact(int x, int y) {
		System.out.println(x / 32);
		if (x / 32 < this.list.size() && y / 32 == 0)
			return true;

		return false;
	}

	public int getPosItem(int x, int y) {
		int pos = 0;
		if (verifieSiCoordonneeExact(x, y))
			pos = x / 32;

		return pos;
	}
}