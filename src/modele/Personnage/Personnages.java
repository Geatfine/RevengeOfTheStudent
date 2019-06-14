package modele.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Position;
import modele.Movable.Movable;
import modele.Personnage.Hero.Hero;

public abstract class Personnages extends Movable {

	
	protected String nom;
	protected IntegerProperty hp;
	protected int attaque;
	protected int defense;
	protected int vitesse;
	protected int energie;
	
	private boolean vivant;

	
	
	public Personnages(String nom, Collision c) {
		this.hp= new SimpleIntegerProperty(100);
		this.attaque=0;
		this.defense=0;
		this.vitesse=0;
		//this.energie=0;
		this.colision=c;
		this.vivant=true;
		//this.idDeplacement=this.position.dernierDeplacement;
	}
	
	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}
	
	public abstract void game();

	@Override
	public final void tic() {
		if (vivant)
			this.game();
	}

	public abstract String getIdArme() ;
	
	
	public abstract void attaquer(Personnages p);
	
	public abstract void recevoirDegat(int degat);
	
	public abstract int getDegatDattaque();
	
	public final boolean enVie() {
		return vivant;
	}
	
	protected void tue() {
		vivant = false;
	}
	
}
