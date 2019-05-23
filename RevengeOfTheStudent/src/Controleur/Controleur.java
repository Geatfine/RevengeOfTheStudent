
package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Jeu;
import modele.Terrain;
import modele.TraduireTerrain;
import modele.Personnage.Hero.Hero;
import vue.ChargeurDImage;
import vue.VueTerrain;
import vue.vuePersonnage;

public class Controleur implements Initializable {

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilePane;

	private Terrain terrain;

	private VueTerrain vueTerrain;
	private vuePersonnage vuePerso;

	private Hero perso;
	public static char toucheDirection;
	public static char toucheSaut;

	final BooleanProperty downPressed = new SimpleBooleanProperty(false);
	final BooleanProperty rightPressed = new SimpleBooleanProperty(false);
	final BooleanProperty upPressed = new SimpleBooleanProperty(false);
	final BooleanProperty leftPressed = new SimpleBooleanProperty(false);
	final BooleanBinding downAndRightPressed = downPressed.and(rightPressed);
	final BooleanBinding downAndLeftPressed = downPressed.and(leftPressed);
	final BooleanBinding upAndRightPressed = upPressed.and(rightPressed);
	final BooleanBinding upAndLeftPressed = upPressed.and(leftPressed);

	public static ChargeurDImage chargeurFond;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		Jeu j = new Jeu();
		try {
			
			
			terrain = new Terrain(new TraduireTerrain("src/ressources/main.csv").getTab());
			vueTerrain = new VueTerrain(terrain, tilePane);
			this.perso = new Hero("Chang");
			vuePerso = new vuePersonnage(pane,perso);


			vuePerso.getImgVPerso().translateYProperty().bind(perso.getDeplacement().getY());
			vuePerso.getImgVPerso().translateXProperty().bind(perso.getDeplacement().getX());

		} catch (IOException e) {
			e.printStackTrace();
		}
		//Vue V = new Vue();
		
		OberservableDirection obs = new OberservableDirection(perso, vuePerso);
		perso.idDeplacementProperty().addListener(obs);
	}
	
	
	

	@FXML
	void clavier(KeyEvent event) throws FileNotFoundException {
		
//		if(event.getCode() == KeyCode.D) {
//		toucheDirection='D';
//		}
//		
//		if(event.getCode() == KeyCode.Q) {
//			toucheDirection = 'Q';
//		}
//		
//		if(event.getCode() == KeyCode.Z) {
//			toucheSaut= 'Z';
//		}
//	}
		
	
		
		
		if(event.getCode() == KeyCode.D) {
			perso.getDeplacement().deplacementDroite();
			rightPressed.set(true);
		}
		if(event.getCode() == KeyCode.Q) {
			perso.getDeplacement().deplacementGauche();
			leftPressed.set(true);
		}
		if(event.getCode() == KeyCode.Z) {
			perso.getDeplacement().deplacementHaut();
			upPressed.set(true);
		}
		if(event.getCode() == KeyCode.S) {
			perso.getDeplacement().deplacementBas();
			downPressed.set(true);
		}
		// bas droite
		if(downAndRightPressed.get()) {
			perso.getDeplacement().deplacementBasDroite();
		}
		if (downAndLeftPressed.get()){
			perso.getDeplacement().deplacementBasGauche();
		}
		if (upAndLeftPressed.get()) {
			perso.getDeplacement().deplacementHautGauche();
		}
		if (upAndRightPressed.get()){
			perso.getDeplacement().deplacementHautDroite();
		}
	}
	
//	public void tour() {
//		this.Jeu.tour
//	}
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
		

	}

}
