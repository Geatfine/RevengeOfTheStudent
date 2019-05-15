package Controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

	private VueTerrain vueT;
	private vuePersonnage vueP;
	
	//private Personnage perso;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			TraduireTerrain terrainTraduit = new TraduireTerrain("src/ressources/main.csv");
			
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
	
	@FXML
    void deplacementPersonnage(KeyEvent event) {
		KeyCode touche = event.getCode();
		System.out.println("touche");
		//if ( touche == KeyCode.D)
			//vueP.deplacementX(1);
    }
	
	@FXML
    void yes(ActionEvent event) {
		System.out.println("coucou");
    }
	
	
	

}