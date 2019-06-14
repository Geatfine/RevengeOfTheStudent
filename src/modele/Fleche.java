package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import modele.Movable.Movable;
import modele.Personnage.Personnages;
import modele.Personnage.Hero.Hero;

public class Fleche extends Movable{
	
	private String direction;
	
	public static int degat = 10;
	private boolean vivant;
	
	
	public Fleche(Position posi) {
		this.direction="Gauche";
		this.position=posi;
		this.vivant=true;
		this.idDeplacement=this.position.dernierDeplacement;
		
	}
	
	@Override
	public String getNom() {
		return "fleche";
	}
	
	
	public void objectif(Personnages hero ) {
	
		int but = hero.getPosition().xProperty().get();
		int i = this.position.xProperty().get();
		int vecteur = 0;
		if(but-i<0) {
			vecteur=-1;


			this.idDeplacement.set("Gauche");
			this.position.deplacementLateral(vecteur);
			if(this.position.xProperty().get()==hero.getPosition().xProperty().get() && this.position.yProperty().get()==hero.getPosition().yProperty().get()) {
				this.tue();
				hero.recevoirDegat(20);
			
		}
			
		}
		if(but-i>=0) {
			vecteur=1;

			this.idDeplacement.set("Droite");
			this.position.deplacementLateral(vecteur);
			if(this.position.xProperty().get()==hero.getPosition().xProperty().get() && this.position.yProperty().get()==hero.getPosition().yProperty().get()) {
				this.tue();
				hero.recevoirDegat(10);
	}
		}
		
		if(i==but) {
			this.tue();
		}
		
		
			

		
		
		
			
			
	}



	
		
	
//		if (!this.colision.verifieCaseDroite(this.position.xProperty().get(), this.position.yProperty().get()) || !colision.verifieCaseGauche(this.position.xProperty().get(), this.position.yProperty().get()))
//			this.tue();
//		else
	
	

	
	
	public Position getPosition() {
		return this.position;
	}

	





	@Override
	public String action() {
		return "fleche";
	}



	@Override
	public IntegerProperty hpProperty() {
		return new SimpleIntegerProperty(0);
	}



	public final boolean enVie() {
		return vivant;
	}
	
	protected void tue() {
		vivant = false;
	}
	@Override
	public void tic() {
		this.objectif(Hero.h);
	}

	@Override
	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}

}