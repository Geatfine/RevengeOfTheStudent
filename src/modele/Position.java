package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Position {

	
	private Terrain terrain;
	private IntegerProperty x;
	private IntegerProperty y;
	public StringProperty dernierDeplacement;

private Collision collision;
	

	public Position ( int x, int y, Collision c,Terrain terrain) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.dernierDeplacement=new SimpleStringProperty("Droite");
		this.collision= c;
		this.terrain=terrain;
		
	}
	
	public StringProperty DeplacementProperty() {
		return this.dernierDeplacement;
	}

	public IntegerProperty xProperty() {
		return this.x;
	}

	public IntegerProperty yProperty() {
		return this.y;
	}

	public void setX(int x) {
		this.x.set(x);
	}
	public void setY(int y) {
		this.y.set(y);
	}
	

	// methode qui teste ce qu'il y a entre le personnage et la position d'arrivee et retourne la position a laquelle il peut aller
	public int testeTranslationSaut(int energie) {
		if(energie<0) 
		for (int i = this.y.get()-1; i<this.y.get()+energie; i--) {
			if(this.collision.estDansLair(this.x.get(), i))
					return i-this.y.get();
		}

		if (energie>0) {
			for (int i = this.y.get()+1; i > this.y.get() +energie; i++)
				if(this.collision.estDansLair(this.x.get(), i))
					return i +this.y.get();
		}	
		return energie;
	}
	
	public int testeTranslationLateral(int a) {
		if(a<0) 
			for (int i = this.x.get()-1; i<=this.x.get()+a; i--) {
				if(this.collision.verifieCaseGauche(i, this.y.get()))
						return i-this.y.get();
			}
			
			
			if (a>0) {
				
				for (int i = this.x.get()+1; i >= this.x.get() +a; i++)
					if(this.collision.verifieCaseDroite(i, this.y.get()))
						return i +this.y.get();
			}
				
			return a;
		
	}
	
	
	public void deplacementLateral(int a) {
		//if (collision.verifieCaseDroite(this.x.get() / 16, this.y.get() / 16))
			this.x.set(this.x.get() + a);
		if (a >0)
		this.dernierDeplacement.set("Droite");
		if(a<0)
			this.dernierDeplacement.set("Gauche");
	}

	public void deplacementVertical(int a) {
		a=a/30;
		//if (collision.verifieCaseHaut(this.x.get() / 16, this.y.get() / 16) && collision.verifieCaseBas(this.x.get() / 16, this.y.get() /16))
			this.y.set(this.y.get() - a);
			
		
	}
	
	public void transmetTerrain(int x , int y, int i) {
		this.terrain.setCase(x, y, i);
	}
	
	
	
//	public void deplacementGauche(int a) {
//	if (collision.verifieCaseGauche(this.x.get() / 16, this.y.get() / 16))
//		this.x.set(this.x.get() -a);
//	this.dernierDeplacement.set("Gauche");
//}
//public void deplacementBas(int a) {
//	if (collision.verifieCaseBas(this.x.get() / 16, this.y.get() / 16)) 
//	this.y.set (this.y.get() +a);
//}
//
//public void tomber(int i ) {
//	if (collision.verifieCaseBas(this.x.get() / 16, this.y.get() / 16))
//		this.y.set(this.y.get()+ 1*i);
//	
//}
	
	
	
	
	


}
