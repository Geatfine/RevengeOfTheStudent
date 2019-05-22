package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.Collision;

public class Deplacement {

	private IntegerProperty x;
	private IntegerProperty y;
	private Collision collision;

	public Deplacement(int x, int y, Collision collision) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.collision = collision;// voir pour les attributs
		this.deplacementBas();
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
		if (collision.verifieCaseDroite(this.x.get() / 16, this.y.get() / 16))
			this.x.set(this.x.get() + 3);
	}

	public void deplacementGauche() {
		if (collision.verifieCaseGauche(this.x.get() / 16, this.y.get() / 16))
			this.x.set(this.x.get() - 3);
	}

	public void deplacementBas() {
		if (collision.verifieCaseBas(this.x.get() / 16, this.y.get() / 16)) {
			this.y.set(this.y.get() + 1);
			deplacementBas();
		}
	}

	public void deplacementHaut() {
		if (collision.verifieCaseHaut(this.x.get() / 16, this.y.get() / 16))
			this.y.set(this.y.get() - 3);
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
