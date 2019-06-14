package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import modele.Terrain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import modele.Terrain;

public class VueTerrain {

	private Terrain terrain;
	private TilePane tileP;
	private Image imgTileSet;
	private ImageView afficheCarre;
	

	public VueTerrain(Terrain terrain, TilePane tileP) throws FileNotFoundException {

		this.terrain = terrain;
		this.tileP = tileP;
		initTerrain();
	}

	public void initTerrain() throws FileNotFoundException {
		FileInputStream fichierTileSet = new FileInputStream("src/ressources/Grassland_Terrain_Tileset.png");
		this.imgTileSet = new Image(fichierTileSet);

		this.tileP.setPrefColumns(50);
		for (int i = 0; i < this.terrain.getTailleX(); i++) {
			

				afficheCarre = new ImageView(this.imgTileSet);
				// System.out.println("i = " + i);
				afficherImage(afficheCarre, i);
			
		}
		// System.out.println("Largeur" + this.terrain.getTailleX());
		// System.out.println("Hauteur" + this.terrain.getTailleY());
	}

	public void afficherImage(ImageView img, int i) {
		// Recuperation du Tile

		int tile = this.terrain.getCase(i);

		// Conversion du premier charactere du tile ( correspondant aux coordonnée du
		// tile sur l'axe X du tile Set)

		int posY = tile % 10;

		// Recuperation du reste du tile correspondant aux coordonnée du tile sur l'axe
		// X du tileSet

		int posX = tile / 10;

		img.setViewport(new Rectangle2D(posX * 16, posY * 16, 16, 16));
		this.tileP.getChildren().add(img);
	}
	
	public void raffraichirTerrain() throws FileNotFoundException {
		this.tileP.getChildren().clear();
		initTerrain();
	}

}
