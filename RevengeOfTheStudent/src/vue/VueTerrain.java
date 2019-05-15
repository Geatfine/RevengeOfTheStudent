package vue;

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

	public VueTerrain(Terrain terrain,TilePane tileP) {

		this.terrain=terrain;
		this.tileP=tileP;

	}
	
	public void initMap() throws FileNotFoundException {
		FileInputStream fichierTileSet = new FileInputStream("src/ressources/Grassland_Terrain_Tileset.png");
		this.imgTileSet = new Image(fichierTileSet);
		
		this.tileP.setPrefColumns(50);
		for (int i = 0; i<this.terrain.getTailleY();i++) {
			for(int j = 0 ; j< this.terrain.getTailleX(); j++) {
		
				afficheCarre = new ImageView(this.imgTileSet);
		//	System.out.println("i = " + i);
				rechercherImage(afficheCarre,i,j);
			}
		}
		// System.out.println("Largeur" + this.terrain.getTailleX());
		// System.out.println("Hauteur" + this.terrain.getTailleY());
	}
	
	public void rechercherImage(ImageView img, int i , int j) {
		// Recuperation du Tile
		String tile = this.terrain.getList()[i][j];
		// Conversion du premier charactere du tile ( correspondant aux coordonnée du tile sur l'axe X du tile Set)
		char cY = tile.charAt(tile.length()-1);
		// Recuperation du reste du tile correspondant aux coordonnée du tile sur l'axe X du tileSet
		int posX = Integer.parseInt(tile.substring(0, tile.length() - 1));
		
		System.out.println(posX);
		int posY = Character.getNumericValue(cY);//

		System.out.println("Y : " + posY);
		img.setViewport(new Rectangle2D(posX*16,posY*16,16,16));
		this.tileP.getChildren().add(img);
	}
	

}