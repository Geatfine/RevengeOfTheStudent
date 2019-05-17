package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Deplacement {

	private IntegerProperty x;
	private IntegerProperty y;

	public Deplacement ( int x, int y) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
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

	public void deplacementDroite() {
		this.x.set(this.x.get()+3);
	}
	public void deplacementGauche() {
		this.x.set(this.x.get()-3);
	}
	public void deplacementBas() {
		this.y.set(this.y.get()+3);
	}
	public void deplacementHaut() {
		this.y.set(this.y.get()-3);
	}

	public void deplacementHautDroite() {
		this.x.set(this.x.get()+3);
		this.y.set(this.y.get()-3);
	}
	public void deplacementHautGauche() {
		this.y.set(this.y.get()-3);
		this.x.set(this.x.get()-3);
	}
	public void deplacementBasDroite() {
		this.y.set(this.y.get()+3);
		this.x.set(this.x.get()+3);
		
	}
	public void deplacementBasGauche() {
		this.y.set(this.y.get()+3);
		this.x.set(this.x.get()-3);
	}
}
