package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.Accessoire.Accessoire;

public class Personnage {
	
	
	
	private Deplacement moove;
	private String nom;
	private IntegerProperty hp;
	private int attaque;
	private int defense;
	private IntegerProperty mana;
	private int vitesse;
	private Outils outils;
	private Inventaire inventaire;
	private Accessoire accessoire;
	private Arme a;
	
	
	public Personnage(String nom) {
		this.nom=nom;
		this.hp= new SimpleIntegerProperty(100);
		this.attaque=0;
		this.defense=0;
		this.mana= new SimpleIntegerProperty(0);
		this.vitesse=1;
		this.a=new Epee();
		this.outils=new Pioche();
		this.inventaire= new Inventaire();

	}
	
	
	public void personnageAvecArme() {
		
		
		
	
	}
	
	public final IntegerProperty gethpProperty() {
		return this.hp;
	}
	
	
	
	public Arme armeEquiper() {
		return this.a;
		
	}


public int getDegatDattaque() {
	if(this.a == null)
		return this.attaque;
	return this.attaque + a.getDegat();
	//return (a==null)? this.attaque:this.attaque + a.getDegat();
}

public void attaquer (Personnage p) {
	p.recevoirDegagt(this.getDegatDattaque());
}

public void recevoirDegagt(int degat) {
	this.hp.set(-degat);
	
}
protected void ajouterArme(Arme a) {
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


public void setPosition(int i, int j) {
	// TODO Auto-generated method stub
	
}


public int getCoordX() {
	// TODO Auto-generated method stub
	return 0;
}


public void setPositionX(int i) {
	// TODO Auto-generated method stub
	
}
}
