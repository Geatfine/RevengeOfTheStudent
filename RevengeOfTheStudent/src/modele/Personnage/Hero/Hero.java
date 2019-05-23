package modele.Personnage.Hero;

import javafx.beans.property.StringProperty;
import modele.Accessoire;
import modele.Arme;
import modele.Collision;
import modele.Deplacement;
import modele.Epee;
import modele.Inventaire;

public class Hero {
	

	private Deplacement moove;

	private String nom;
	private int hp;
	private int attaque;
	private int defense;
	private int mana;
	private int vitesse;
	private Inventaire inventaire;
	private Accessoire accessoire;
	private Arme a;
	private StringProperty idArme ;
	private StringProperty idDeplacement;
	private Collision colision;

	
	
	public Hero(String nom) {
		this.nom=nom;
		this.a= new Epee();
		this.hp=100;
		this.attaque=0;
		this.defense=0;
		this.mana=0;
		this.vitesse=1;
		this.inventaire= new Inventaire();
		this.idArme= this.a.idProperty();

		moove = new Deplacement (0,0);
		this.idDeplacement=this.moove.dernierDeplacement;
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

	public Deplacement getDeplacement() {
		return this.moove;
	}
	
	
//	public StringProperty String() {
//		return this.idArme+this.idDeplacement;
//	}
}
