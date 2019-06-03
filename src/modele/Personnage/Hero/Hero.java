package modele.Personnage.Hero;

import Controleur.Controleur;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Epee;
import modele.Katana;
import modele.Position;
import modele.Movable.Movable;
import modele.Personnage.Item.Arme;

public class Hero extends Movable{
	

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
	private StringProperty item;
	


	
	
	public Hero(String nom, Collision c) {
		if(c == null)
			throw new Error("sss");
		this.nom=nom;
		this.a= new Katana();
		this.hp=100;
		this.attaque=0;
		this.defense=0;
		this.mana=0;
		this.vitesse=1;
		//this.inventaire= new Inventaire();
		this.idArme= this.a.idProperty();
		this.energie=0;
		this.item = new SimpleStringProperty("10");
		position = new Position (200,200, c);
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


	public int getDegatDattaque() {
		if(this.a == null)
			return this.attaque;
		return this.attaque + a.getDegat();
		//return (a==null)? this.attaque:this.attaque + a.getDegat();
	}

	public void attaquer (Hero p) {
		p.recevoirDegagt(this.getDegatDattaque());
	}

	public void recevoirDegagt(int degat) {
		this.hp-= degat;
		
	}
	protected void ajouterArme(Arme a) {
		this.perdreArme();
		this.a=a;	
	}
	public void perdreArme() {
		this.a=null;
	}

	public int getDefense() {
		return this.defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Position getDeplacement() {
		return this.position;
	}
	
//	public void tomber(int gravite) {
//		this.getDeplacement().deplacementBas();
//		
//		
//	}
//	public void poserBlock(int x,int y) {
//		this.position.transmetTerrain( x/50, y/16, this.item.get());
//	}


	public void tic() {
		if(!this.colision.verifieCase(this.position.xProperty().get(), this.position.yProperty().get())){
			char c =Controleur.toucheSaut;
			Controleur.toucheSaut = Controleur.PASBOUGER;
			this.energie=0;
			//System.out.println(c);
			if(c==Controleur.DIRECTIONHAUT)
				this.energie+=90;
			
				
		}
		else
			this.energie--;
		int y = this.position.testeTranslationSaut(energie);
		this.position.deplacementVertical(y);
		
		char d = Controleur.toucheDirection;
		Controleur.toucheDirection = Controleur.PASBOUGER;
		
		
		if(d==Controleur.DIRECTIONGAUCHE && this.colision.verifieCaseGauche((this.position.xProperty().get())/16, this.position.yProperty().get()/16))  
		this.position.deplacementLateral(-3);
		if(d==Controleur.DIRECTIONDROITE && this.colision.verifieCaseDroite((this.position.xProperty().get())/16, this.position.yProperty().get()/16))
			this.position.deplacementLateral(3);
		//System.out.println(energie+"   "+y);
		
	}
	
	
	
	
//	public StringProperty String() {
//		return this.idArme+this.idDeplacement;
//	}
}