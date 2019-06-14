
package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import Controleur.GameLoop.BoucleDeJeu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
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
import modele.Movable.Movable;
import modele.Personnage.Homps;
import modele.Personnage.Personnages;
import modele.Personnage.Hero.Hero;
import vue.ChargeurDImage;
import vue.Vue;
import vue.VueEnnemie;
import vue.VueInventaire;
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
	private VueEnnemie vueEnnemie;

	private Hero perso;
	private Homps mario;
	private Collision collision;
	public static char toucheDirection;
	public static char toucheSaut;
	private BoucleDeJeu boucle;
	private Jeu jeu;
	private VueInventaire vueInven;
	@FXML
	private TilePane inventaire;



	private HashMap<Movable,Vue> listMovView;

	private Image img = new Image("/ressources/coeur.png");

	//private ArrayList<Movable> listAjouter

	public final static char DIRECTIONHAUT = 'Z';
	public final static char DIRECTIONDROITE= 'D';
	public final static char DIRECTIONGAUCHE = 'Q';
	public final static char PASBOUGER = ' ';



	//	final BooleanProperty downPressed = new SimpleBooleanProperty(false);
	//public final static BooleanProperty rightPressed = new SimpleBooleanProperty(false);
	//	final BooleanProperty upPressed = new SimpleBooleanProperty(false);
	//public final static BooleanProperty leftPressed = new SimpleBooleanProperty(false);
	//	final BooleanBinding downAndRightPressed = downPressed.and(rightPressed);
	//	final BooleanBinding downAndLeftPressed = downPressed.and(leftPressed);
	//	final BooleanBinding upAndRightPressed = upPressed.and(rightPressed);
	//	final BooleanBinding upAndLeftPressed = upPressed.and(leftPressed);

	public static ChargeurDImage chargeurFond;

	@Override


	public void initialize(URL location, ResourceBundle resources) {
		try {

			this.listMovView = new HashMap<Movable,Vue>();
			this.jeu= new Jeu();
			//this.mario= jeu.getMario();
			vueTerrain = new VueTerrain(jeu.getTerrain(), tilePane);
			//vueEnnemie = new VueEnnemie(pane, mario);
			vuePerso = new vuePersonnage(pane, jeu.getHero());
			this.vueInven= new VueInventaire(inventaire);

			this.perso=jeu.getHero();

			boucle = new BoucleDeJeu(this);

			boucle.start();
			this.listMovView.put(jeu.getHero(), vuePerso);

			//			vueEnnemie.getImgVPerso().translateYProperty().bind(mario.getPosition().yProperty());
			//			vueEnnemie.getImgVPerso().translateXProperty().bind(mario.getPosition().xProperty());
			//			


			vuePerso.getImgVPerso().translateYProperty().bind(jeu.getHero().getPosition().yProperty());
			vuePerso.getImgVPerso().translateXProperty().bind(jeu.getHero().getPosition().xProperty());
			//ctlrDeplacement = new ControleurDeplacement(perso, borderPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

		OberservablePersonnage obs = new OberservablePersonnage(perso, vuePerso);
		jeu.getHero().idDeplacementProperty().addListener(obs);
		
		ObservableTerrain obsTerrain = new ObservableTerrain(jeu.getTerrain(), vueTerrain);
		jeu.getTerrain().getListTerrain().addListener(obsTerrain);

		ObservableInventaire inv = new ObservableInventaire(perso, vueInven);
		jeu.getHero().getInventaire().getInventaireList().addListener(inv);
	}

	@FXML
	void clavier(KeyEvent event) throws FileNotFoundException {

		if(event.getCode() == KeyCode.D) {
			toucheDirection=this.DIRECTIONDROITE;
		}

		if(event.getCode() == KeyCode.Q) {
			toucheDirection = this.DIRECTIONGAUCHE;
		}

		if(event.getCode() == KeyCode.Z) {
			toucheSaut= this.DIRECTIONHAUT;
		}

		if(event.getCode()== KeyCode.TAB) {

			if (inventaire.isVisible())
				inventaire.setVisible(false);
			else
				inventaire.setVisible(true);
		}
	}






	//	public void tour() {
	//		this.Jeu.tour
	//	}
	@FXML
	void keyRelease(KeyEvent event) {

		jeu.getHero().merciHomps();

		//		
		//		if (event.getCode() == KeyCode.D)
		//			rightPressed.set(false);
		//		if(event.getCode() == KeyCode.Q)
		//			leftPressed.set(false);
		//		if (event.getCode() == KeyCode.Z)
		//			upPressed.set(false);
		//		if (event.getCode() == KeyCode.S)
		//			downPressed.set(false);
	}	

	@FXML
	void souris(MouseEvent event) {
		if (event.getButton() == MouseButton.PRIMARY) {
			perso.poserBlock((int) Math.floor(event.getY()), (int) Math.floor(event.getX()));
		}
		if (event.getButton() == MouseButton.SECONDARY)
			perso.casserBlock((int) Math.floor(event.getY()), (int) Math.floor(event.getX()));
		
	}

	public void supprimerMovable(Movable m) {

		listMovView.get(m).clear();
		this.listMovView.remove(m);

	}


	/*
	 * 
	 */


	//recuperer la liste de jeu.nouveauArrivant et pour chacun cree une nouvelle vue et vider cette liste
	public void tour() throws FileNotFoundException {

		ArrayList<Movable> list = jeu.getList();
		for(Movable m: list)
		{
			VueEnnemie v =new VueEnnemie(pane, m);
			v.getImgVPerso().translateYProperty().bind(m.getPosition().yProperty());
			v.getImgVPerso().translateXProperty().bind(m.getPosition().xProperty());
			ObservableEnnemie observateurEnnemie = new ObservableEnnemie(m, v);
			m.idDeplacementProperty().addListener(observateurEnnemie);
			v.getLabel().translateYProperty().bind(m.getPosition().yProperty().add(-32));
			v.getLabel().translateXProperty().bind(m.getPosition().xProperty());

			this.listMovView.put(m, v);



		}
		this.jeu.modifieListe();
		jeu.tour(this);

		//for(Movable c : list)
		//vue ajouter au pane le movable
		//vide la liste 

	}

}
