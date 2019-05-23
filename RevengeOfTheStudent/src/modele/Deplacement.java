package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Deplacement {

	private IntegerProperty x;
	private IntegerProperty y;
	public StringProperty dernierDeplacement;

private Collision collision;
	final static double gravite = 0.6;
	private double  c;
	

	public Deplacement ( int x, int y, Collision c) {
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

	public void deplacementDroite() {
		if (collision.verifieCaseDroite(this.x.get() / 16, this.y.get() / 16))
			this.x.set(this.x.get() + 10);
		this.dernierDeplacement.set("Droite");
	}
	public void deplacementGauche() {
		if (collision.verifieCaseGauche(this.x.get() / 16, this.y.get() / 16))
			this.x.set(this.x.get() -10);
		this.dernierDeplacement.set("Gauche");
	}
	public void deplacementBas() {
		if (collision.verifieCaseBas(this.x.get() / 16, this.y.get() / 16)) 
		this.y.set(this.y.get() + 10);
	}
	public void deplacementHaut() {
		if (collision.verifieCaseHaut(this.x.get() / 16, this.y.get() / 16))
			this.y.set(this.y.get() - 10);
	}


	public void deplacementHautDroite() {
		this.deplacementHaut();
		this.deplacementDroite();
	}

	public void deplacementHautGauche() {
		this.deplacementHaut();
		this.deplacementGauche();
	}

	public void deplacementBasDroite() {
		this.deplacementBas();
		this.deplacementDroite();
	}

	public void deplacementBasGauche() {
		this.deplacementBas();
		this.deplacementGauche();
}
}
