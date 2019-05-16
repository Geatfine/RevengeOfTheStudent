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
	final BooleanProperty upPressed = new SimpleBooleanProperty(false);
	final BooleanProperty leftPressed = new SimpleBooleanProperty(false);
	final BooleanBinding downAndRightPressed = downPressed.and(rightPressed);
	final BooleanBinding downAndLeftPressed = downPressed.and(leftPressed);
	final BooleanBinding upAndRightPressed = upPressed.and(rightPressed);
	final BooleanBinding upAndLeftPressed = upPressed.and(leftPressed);

	

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
					rightPressed.set(true);
						}
			if(event.getCode() == KeyCode.Q) {
				perso.getDeplacement().setX(perso.getDeplacement().getX().get()-3);
				leftPressed.set(true);
				//vueP.setImage();
			}
			if(event.getCode() == KeyCode.Z) {

				upPressed.set(true);
				perso.getDeplacement().setY(perso.getDeplacement().getY().get()-3);
			}
			if(event.getCode() == KeyCode.S) {
				perso.getDeplacement().setY(perso.getDeplacement().getY().get()+3);
				downPressed.set(true);
				
			}
			// bas droite
			if(downAndRightPressed.get()) {
				perso.getDeplacement().setX(perso.getDeplacement().getX().get()+3);
				perso.getDeplacement().setY(perso.getDeplacement().getY().get()+3);
			}
			if (downAndLeftPressed.get()){
				perso.getDeplacement().setX(perso.getDeplacement().getX().get()-3);
				perso.getDeplacement().setY(perso.getDeplacement().getY().get()+3);
			}
			if (upAndLeftPressed.get()) {
				perso.getDeplacement().setY(perso.getDeplacement().getY().get()-3);
				perso.getDeplacement().setX(perso.getDeplacement().getX().get()-3);
			}
			if (upAndRightPressed.get()){
				perso.getDeplacement().setY(perso.getDeplacement().getY().get()-3);
				perso.getDeplacement().setX(perso.getDeplacement().getX().get()+3);
			}
		}
		@FXML
    void keyRelease(KeyEvent event) {
			if (event.getCode() == KeyCode.D)
				rightPressed.set(false);
			if(event.getCode() == KeyCode.Q)
				leftPressed.set(false);
			if (event.getCode() == KeyCode.Z)
				upPressed.set(false);
			if (event.getCode() == KeyCode.S)
				downPressed.set(false);
    }	
		
	@FXML
    void souris(MouseEvent event) {
		System.out.println("fghjklm");

    }

}