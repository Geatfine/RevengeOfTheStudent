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

	public Position(int x, int y, Collision c) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.dernierDeplacement = new SimpleStringProperty("Droite");
		this.collision = c;

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

	// methode qui teste ce qu'il y a entre le personnage et la position d'arrive et
	// retourne la position a la quelle il peut aller
	public int testeTranslationSaut(int energie) {
		if (energie < 0)
			for (int i = this.y.get() - 1; i < this.y.get() + energie; i--) {
				
				if (this.collision.verifieCase(this.x.get(), i))
					return i - this.y.get();
			}

		if (energie > 0) {
			for (int i = this.y.get() + 1; i > this.y.get() + energie; i++)
				if (this.collision.verifieCase(this.x.get(), i))
					return i + this.y.get();
		}
		if (energie == 0) {
			return 1;
		}
		return energie;
	}

	public int testeTranslationLateral(int a) {
		System.out.println(a);
		if (a < 0)
			for (int i = this.x.get() - 1; i >= this.x.get() - a; i++) {

				if (this.collision.verifieCaseGauche(i, this.y.get())) {
					//System.out.println(i - this.x.get());
					return i - this.x.get();
				}
			}

		if (a > 0) {

			for (int i = this.x.get() + 1; i <= this.x.get() + a; i++) {
				
				if (this.collision.verifieCaseDroite(i, this.y.get() )) {
					//System.out.println(i - this.x.get());
					return i + this.x.get();
				}

			}
		}
		if (a==2) {
			//System.out.println("2");
			return 0;
		}
		if (a ==0) {
			//System.out.println("0");
			return 0;
		}
		//System.out.println("ici");
		return a;
		
	}

	public void deplacementLateral(int vitesse) {
		System.out.println(vitesse);
		if (collision.verifieCaseDroite(this.x.get()/16, this.y.get()/16 ) || collision.verifieCaseGauche(this.x.get(), this.y.get())) {
			if (vitesse > 0)
				for (int i = 0 ; i < vitesse ; i++) {
					if (collision.verifieCaseDroite(this.x.get()/16, this.y.get()/16 )) 
						this.x.set(this.x.get() + 1);
					}
			if (vitesse < 0)
				for (int j = 0 ; j > vitesse ; j--) {
					if (collision.verifieCaseGauche((this.x.get()/16)-1, (this.y.get()/16)-1 )) 
						this.x.set(this.x.get() - 1);
					}
				}
		
		if (vitesse> 0)
			this.dernierDeplacement.set("Droite");
		if (vitesse < 0)
			this.dernierDeplacement.set("Gauche");
	}

	public void deplacementVertical(int a) {
		a = a / 30;
		this.y.set(this.y.get() - a);

	}

	public void transmetTerrain(int x, int y, int i) {
		this.collision.transmetTerrain(x, y, i);
	}


}
