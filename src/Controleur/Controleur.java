
package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controleur.GameLoop.BoucleDeJeu;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Collision;
import modele.Jeu;
import modele.Terrain;
import modele.TraduireTerrain;
import modele.Personnage.Ennemie.MarioCataldie;
import modele.Personnage.Hero.Hero;
import vue.ChargeurDImage;
import vue.VueEnnemie;
import vue.VueInventaire;
import vue.VueTerrain;
import vue.vuePersonnage;

public class Controleur implements Initializable {

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilePane;

	private VueTerrain vueTerrain;
	private vuePersonnage vuePerso;
	private VueEnnemie vueEnnemie;

	private Hero perso;
	private MarioCataldie mario;
	public static char toucheDirection;
	public static char toucheSaut;
	private BoucleDeJeu boucle;
	private Jeu jeu;
	private VueInventaire vueInven;
	@FXML
	private TilePane inventaire;

	// private ArrayList<Movable> listAjouter

	public final static char DIRECTIONHAUT = 'Z';
	public final static char DIRECTIONDROITE = 'D';
	public final static char DIRECTIONGAUCHE = 'Q';
	public final static char PASBOUGER = ' ';

	public static ChargeurDImage chargeurFond;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {

			this.jeu = new Jeu();
			this.mario = jeu.getMario();

			vueTerrain = new VueTerrain(jeu.getTerrain(), tilePane);
			vueEnnemie = new VueEnnemie(pane, mario);
			vuePerso = new vuePersonnage(pane, jeu.getHero());
			this.vueInven = new VueInventaire(inventaire);

			this.perso = jeu.getHero();

			boucle = new BoucleDeJeu(this);

			boucle.start();

			vueEnnemie.getImgVPerso().translateYProperty().bind(mario.getDeplacement().yProperty());
			vueEnnemie.getImgVPerso().translateXProperty().bind(mario.getDeplacement().xProperty());

			vuePerso.getImgVPerso().translateYProperty().bind(jeu.getHero().getDeplacement().yProperty());
			vuePerso.getImgVPerso().translateXProperty().bind(jeu.getHero().getDeplacement().xProperty());
			// ctlrDeplacement = new ControleurDeplacement(perso, borderPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

		OberservableDirection obs = new OberservableDirection(perso, vuePerso);
		perso.idDeplacementProperty().addListener(obs);

		ObservableInventaire inv = new ObservableInventaire(perso, vueInven);
		perso.getInventaire().getInventaireList().addListener(inv);

		ObservableTerrain obsTerrain = new ObservableTerrain(jeu.getTerrain(), vueTerrain);
		jeu.getTerrain().getListTerrain().addListener(obsTerrain);

	}

	@FXML
	void clavier(KeyEvent event) throws FileNotFoundException {

		if (event.getCode() == KeyCode.D) {
			toucheDirection = this.DIRECTIONDROITE;
		}

		if (event.getCode() == KeyCode.Q) {
			toucheDirection = this.DIRECTIONGAUCHE;
		}

		if (event.getCode() == KeyCode.Z) {
			toucheSaut = this.DIRECTIONHAUT;
		}
		if (event.getCode() == KeyCode.TAB) {
			if (inventaire.isVisible())
				inventaire.setVisible(false);
			else
				inventaire.setVisible(true);
		}
	}

	@FXML
	void keyRelease(KeyEvent event) {

	}

	@FXML
	void souris(MouseEvent event) {
		if (event.getButton() == MouseButton.PRIMARY)
			perso.poserBlock((int) Math.floor(event.getY()), (int) Math.floor(event.getX()));
		if (event.getButton() == MouseButton.SECONDARY)
			perso.casserBlock((int) Math.floor(event.getY()), (int) Math.floor(event.getX()));

		// vueInven.reduireOpacité((int)event.getScreenX(),(int)event.getScreenY());
	}

	/**
	 * Effectue un tour de jeu
	 */
	public void tour() {
		jeu.tour();
		// for(Movable c : list)
		// vue ajouter au pane le movable
		// vide la liste

	}

}
