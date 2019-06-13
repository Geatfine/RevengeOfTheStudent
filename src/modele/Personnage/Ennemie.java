package modele.Personnage;

import modele.Collision;
import modele.Position;

public abstract class Ennemie extends Personnages{

	public Ennemie(String nom, Collision c) {
		super(nom, c);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void ticEnnemie(Position p); 

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
