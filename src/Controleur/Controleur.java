
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Collision;
import modele.Jeu;
import modele.Terrain;
import modele.TraduireTerrain;
import modele.Personnage.MarioCataldie;
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

	private Terrain terrain;

	private VueTerrain vueTerrain;
	private vuePersonnage vuePerso;
	private VueEnnemie vueEnnemie;

	private Hero perso;
	private MarioCataldie mario;
	private Collision collision;
	public static char toucheDirection;
	public static char toucheSaut;
	private BoucleDeJeu boucle;
	private Jeu jeu;
	private VueInventaire vueInven;
    @FXML
    private HBox inventaire;
	
	    
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
				
				

				this.jeu= new Jeu();
				this.mario= jeu.getMario();
				
			vueTerrain = new VueTerrain(jeu.getTerrain(), tilePane);
			vueEnnemie = new VueEnnemie(pane, mario);
			vuePerso = new vuePersonnage(pane, jeu.getHero());
			this.vueInven= new VueInventaire(inventaire);
			
			this.perso=jeu.getHero();
			
			
			
			boucle = new BoucleDeJeu(this);
			
			boucle.start();
		

			vueEnnemie.getImgVPerso().translateYProperty().bind(mario.getPosition().yProperty());
			vueEnnemie.getImgVPerso().translateXProperty().bind(mario.getPosition().xProperty());

				vuePerso.getImgVPerso().translateYProperty().bind(jeu.getHero().getPosition().yProperty());
				vuePerso.getImgVPerso().translateXProperty().bind(jeu.getHero().getPosition().xProperty());
				//ctlrDeplacement = new ControleurDeplacement(perso, borderPane);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		OberservableDirection obs = new OberservableDirection(perso, vuePerso);
		perso.idDeplacementProperty().addListener(obs);
		
		OberservableDirection homps = new OberservableDirection(mario, vueEnnemie);
		mario.idDeplacementProperty().addListener(homps);
		
		
		ObservableInventaire inv = new ObservableInventaire(perso, vueInven);
		perso.idDeplacementProperty().addListener(inv);
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
			while(this.inventaire.isVisible())
				this.inventaire.setVisible(true);
		}
	}
		
	
		

	
	
//	public void tour() {
//		this.Jeu.tour
//	}
	@FXML
	void keyRelease(KeyEvent event) {
		
		this.perso.merciHomps();
		
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
	//	perso.poserBlock((int)Math.floor(event.getScreenX()),(int)Math.floor(event.getSceneY()));

	}



/*
 * 
 */
	public void tour() {
		jeu.tour();
		//for(Movable c : list)
		//vue ajouter au pane le movable
		//vide la liste 
		
	}

}
