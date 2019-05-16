package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Personnage;
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
	
	private Personnage perso;
	
	final BooleanProperty downPressed = new SimpleBooleanProperty(false);
	final BooleanProperty rightPressed = new SimpleBooleanProperty(false);
	final BooleanBinding downAndRightPressed = downPressed.and(rightPressed);
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			TraduireTerrain terrainTraduit = new TraduireTerrain("src/ressources/main.csv");

			terrain = new Terrain(terrainTraduit.getTab());
			//terrain.AffTerrain();
			vueT = new VueTerrain(terrain, tilePane);
			this.perso = new Personnage("test");
			vueP = new vuePersonnage(pane);
			vueP.initPerso();
			vueT.initMap();

			vueP.getImgVPerso().translateYProperty().bind(perso.getDeplacement().getY());
			vueP.getImgVPerso().translateXProperty().bind(perso.getDeplacement().getX());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void clavier(KeyEvent event) throws FileNotFoundException {
		if(event.getCode() == KeyCode.D) {
			perso.getDeplacement().setX(perso.getDeplacement().getX().get()+3);
					}
		if(event.getCode() == KeyCode.Q) {
			perso.getDeplacement().setX(perso.getDeplacement().getX().get()-3);
			//vueP.setImage();
		}
		if(event.getCode() == KeyCode.Z) {
			perso.getDeplacement().setY(perso.getDeplacement().getY().get()-3);
		}
		if(event.getCode() == KeyCode.S) {
			perso.getDeplacement().setY(perso.getDeplacement().getY().get()+3);
			
		}
		if(downAndRightPressed.get()) {

			perso.getDeplacement().setX(perso.getDeplacement().getX().get()+3);
			perso.getDeplacement().setY(perso.getDeplacement().getY().get()+3);
			
		}
    }
	@FXML
    void souris(MouseEvent event) {
		System.out.println("fghjklm");

    }

}