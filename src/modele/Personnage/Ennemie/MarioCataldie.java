package modele.Personnage.Ennemie;


import Controleur.Controleur;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Epee;
import modele.Katana;
import modele.Position;
import modele.Movable.Movable;
import modele.Personnage.Item.Arme;

public class MarioCataldie extends Movable {
	
	
	
	
	private Position position;
	private char mouvementSuivant;

	private String nom;
	private int hp;
	private int attaque;
	private int defense;
	private int mana;
	private int vitesse;
	private int energie;
	//private Inventaire inventaire;
	//private Accessoire accessoire;
	private Arme a;
	private StringProperty idArme ;
	private StringProperty idDeplacement;
	private Collision colision;

	
	
	
	public MarioCataldie(String nom, Collision c) {
		if(c == null)
			throw new Error("sss");
		this.nom=nom;
		this.a= new Epee();
		this.hp=100;
		this.attaque=0;
		this.defense=0;
		this.mana=0;
		this.vitesse=1;
		//this.inventaire= new Inventaire();
		this.idArme= this.a.idProperty();
		this.energie=100;

		position = new Position (300,200, c);
		this.colision=c;
		this.idDeplacement=this.position.dernierDeplacement;
		
	}
	
	
	public void nouveauDeplacement(char mouv) {
		this.mouvementSuivant=mouv;
		
	}
	
	public String getIdArme() {
		return this.idArme.get();
	}
	
	public String action() {
		return this.idArme.get() + this.idDeplacement.get();
	}
	
	public StringProperty idArmeProperty() {
		return this.idArme;
	}
	
	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}

	public Position getDeplacement() {
		return this.position;
	}
	
	
	@Override
	public void tic() {
		if(!this.colision.verifieCase(this.position.xProperty().get(), this.position.yProperty().get())) {
		
			this.energie=0;
		
			
				
		}
		else
		
			this.energie--;
		int y = this.position.testeTranslationSaut(energie);
		
		this.position.deplacementVertical(y);
			
			
			//this.energie--;
			
		
		}
		
	
	
	
	

}
