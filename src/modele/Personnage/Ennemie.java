package modele.Personnage;

import modele.Collision;
import modele.Position;
import modele.Personnage.Hero.Hero;

public abstract class Ennemie extends Personnages{
	
	

	public Ennemie(String nom, Collision c) {
		super(nom, c);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract void recevoirDegat(int degat);
	
	public abstract int getDegatDattaque();


	

}