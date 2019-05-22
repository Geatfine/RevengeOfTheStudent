
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Collision;
import modele.Personnage;
import modele.Terrain;
import modele.TraduireTerrain;
import vue.VueTerrain;
import vue.vuePersonnage;

public class Controleur implements Initializable {

	@FXML
	private Pane pane;
	@FXML
	private BorderPane borderPane;
	@FXML
	private TilePane tilePane;

	private Terrain terrain;

	private VueTerrain vueTerrain;
	private vuePersonnage vuePerso;
	private ControleurDeplacement ctlrDeplacement;
	private Personnage perso;
	private Collision collision;

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

			terrain = new Terrain(new TraduireTerrain().getTab());
			vueTerrain = new VueTerrain(terrain, tilePane);

			collision = new Collision(terrain);
			this.perso = new Personnage("Chang", collision);
			vuePerso = new vuePersonnage(pane);

			vuePerso.getImgVPerso().translateYProperty().bind(perso.getDeplacement().getY());
			vuePerso.getImgVPerso().translateXProperty().bind(perso.getDeplacement().getX());
			ctlrDeplacement = new ControleurDeplacement(perso, borderPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void clavier(KeyEvent event) throws FileNotFoundException {
		if (event.getCode() == KeyCode.D) {
			perso.getDeplacement().deplacementDroite();
			rightPressed.set(true);
		}
		if (event.getCode() == KeyCode.Q) {
			perso.getDeplacement().deplacementGauche();
			leftPressed.set(true);
		}
		if (event.getCode() == KeyCode.Z) {
			perso.getDeplacement().deplacementHaut();
			upPressed.set(true);
		}
		if (event.getCode() == KeyCode.S) {
			perso.getDeplacement().deplacementBas();
			downPressed.set(true);
		}
		// bas droite
		if (downAndRightPressed.get()) {
			perso.getDeplacement().deplacementBasDroite();
		}
		if (downAndLeftPressed.get()) {
			perso.getDeplacement().deplacementBasGauche();
		}
		if (upAndLeftPressed.get()) {
			perso.getDeplacement().deplacementHautGauche();
		}
		if (upAndRightPressed.get()) {
			perso.getDeplacement().deplacementHautDroite();
		}
	}

	@FXML
	void keyRelease(KeyEvent event) {
		if (event.getCode() == KeyCode.D)
			rightPressed.set(false);
		if (event.getCode() == KeyCode.Q)
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
