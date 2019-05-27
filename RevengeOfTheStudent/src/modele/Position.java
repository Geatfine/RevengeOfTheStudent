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
	final static double gravite = 0.8;
	private static double vitesse = 1;
	private double  c;
	

	public Position ( int x, int y, Collision c) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.dernierDeplacement=new SimpleStringProperty("Droite");
		this.collision= c;
		
	}
	
	public StringProperty DeplacementProperty() {
		return this.dernierDeplacement;
	}

	public IntegerProperty getX() {
		return this.x;
	}

	public IntegerProperty getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x.set(x);
	}
	public void setY(int y) {
		this.y.set(y);
	}
	
	public void graviter() {
		if(this.y.get()<100) {
			this.y.set( (this.y.get()+10));
		this.graviter();
		}
			
			
			
	}

	public int testeTranslationSaut(int a) {
		if(a<0) 
		for (int i = this.y.get()-1; i<=this.y.get()+a; i--) {
			if(this.collision.verifieCase(this.x.get(), i))
					return i-this.y.get();
		}
		
		
		if (a>0) {
			
			for (int i = this.x.get()+1; i >= this.x.get() +a; i++)
				if(this.collision.verifieCase(i, this.y.get()))
					return i +this.x.get();
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
//	public void deplacementGauche(int a) {
//		if (collision.verifieCaseGauche(this.x.get() / 16, this.y.get() / 16))
//			this.x.set(this.x.get() -a);
//		this.dernierDeplacement.set("Gauche");
//	}
//	public void deplacementBas(int a) {
//		if (collision.verifieCaseBas(this.x.get() / 16, this.y.get() / 16)) 
//		this.y.set (this.y.get() +a);
//	}
//	
//	public void tomber(int i ) {
//		if (collision.verifieCaseBas(this.x.get() / 16, this.y.get() / 16))
//			this.y.set(this.y.get()+ 1*i);
//		
//	}
	public void deplacementVertical(int a) {
		a=a/50;
		//if (collision.verifieCaseHaut(this.x.get() / 16, this.y.get() / 16) && collision.verifieCaseBas(this.x.get() / 16, this.y.get() /16))
			this.y.set(this.y.get() - a);
			
		
	}
	
	
	
	
	


}
