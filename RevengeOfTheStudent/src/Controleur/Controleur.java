package Controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Terrain;
import modele.TraduireTerrain;
import vue.VueTerrain;
import vue.vuePersonnage;

public class Controleur implements Initializable {

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilePane;

	private Terrain terrain;
	private TraduireTerrain terrainTraduit;
	private VueTerrain vueT;
	private vuePersonnage vueP;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			terrainTraduit = new TraduireTerrain("src/ressources/main.csv");
			
			terrain = new Terrain(terrainTraduit.getTab());
			terrain.AffTerrain();
			vueT = new VueTerrain(terrain, tilePane);
			
			vueP = new vuePersonnage(pane);
			vueP.initPerso();
			
			vueT.initMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}