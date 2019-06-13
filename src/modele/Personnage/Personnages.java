package modele.Personnage;

import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Position;
import modele.Movable.Movable;
import modele.Personnage.Hero.Hero;

public abstract class Personnages extends Movable {

	protected  Position position;
	
	protected String nom;
	protected int hp;
	protected int attaque;
	protected int defense;
	protected int vitesse;
	protected int energie;
	protected StringProperty idDeplacement;

	
	
	public Personnages(String nom, Collision c) {
		this.hp=100;
		this.attaque=0;
		this.defense=0;
		this.vitesse=0;
		this.energie=0;
		this.colision=c;
		//this.idDeplacement=this.position.dernierDeplacement;
	}
	
	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}

	public abstract Position getPosition();

	public abstract String getIdArme() ;
	
	
	
	
	
}

