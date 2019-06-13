package modele.Personnage.Hero;

import Controleur.Controleur;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Epee;
import modele.Katana;
import modele.Position;
import modele.Movable.Movable;
import modele.Personnage.Personnages;
import modele.Personnage.Item.Arme;

public class Hero extends Personnages {
	/*
	 * test
	 */
	int tailleX = 2, tailleY = 2;

	private int mana;
	private Arme a;
	private StringProperty idArme;
	private StringProperty item;

	public Hero(String nom, Collision c) {
		super(nom, c);
		if (c == null)
			throw new Error("sss");
		this.a = new Katana();
		this.mana = 0;
		this.idArme = this.a.idProperty();
		this.item = new SimpleStringProperty("10");
		position = new Position(200, 200, c);
		this.idDeplacement = this.position.dernierDeplacement;

	}

	@Override
	public String getIdArme() {
		return this.idArme.get();
	}

	public String action() {
		return this.idArme.get() + this.idDeplacement.get();
	}

	public StringProperty idArmeProperty() {
		return this.idArme;
	}

	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}

	public int getDegatDattaque() {
		if (this.a == null)
			return this.attaque;
		return this.attaque + a.getDegat();
		// return (a==null)? this.attaque:this.attaque + a.getDegat();
	}

	public void attaquer(Hero p) {
		p.recevoirDegagt(this.getDegatDattaque());
	}

	public void recevoirDegagt(int degat) {
		this.hp -= degat;

	}

	protected void ajouterArme(Arme a) {
		this.perdreArme();
		this.a = a;
	}

	public void perdreArme() {
		this.a = null;
	}

	public int getDefense() {
		return this.defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Position getPosition() {
		return this.position;
	}

	public void merciHomps() {
		this.vitesse = 1;
	}

	// public void tomber(int gravite) {
	// this.getDeplacement().deplacementBas();
	//
	//
	// }

	public void tic() {
		if (!this.colision.verifieCase(this.position.xProperty().get(), this.position.yProperty().get())) {
			char c = Controleur.toucheSaut;
			Controleur.toucheSaut = Controleur.PASBOUGER;
			this.energie = 0;
			// System.out.println(c);
			if (c == Controleur.DIRECTIONHAUT)
				this.energie += 90;

		} else
			this.energie--;
		int y = this.position.testeTranslationSaut(energie);
		this.position.deplacementVertical(y);

		char d = Controleur.toucheDirection;
		Controleur.toucheDirection = Controleur.PASBOUGER;

		if (d == Controleur.DIRECTIONDROITE) {

			if (vitesse == 0)
				vitesse = 1;
			vitesse++;

			if (vitesse >= 13)
				vitesse = 13;
			this.position.deplacementLateral(this.position.testeTranslationLateral(vitesse));
			System.out.println("test  " + this.position.testeTranslationLateral(vitesse) + "   "
					+ this.position.xProperty().get());
		}
		if (d == Controleur.DIRECTIONGAUCHE) {

			if (vitesse == 0)
				vitesse = -1;
			vitesse--;

			if (vitesse <= (-13))
				vitesse = -13;

			this.position.deplacementLateral(this.position.testeTranslationLateral(vitesse));

			// System.out.println("test " + this.position.testeTranslationLateral(vitesse) +
			// " "
			// + this.position.xProperty().get());
			System.out.println(vitesse);
		}
		// System.out.println(energie+" "+y);

	}

	// public StringProperty String() {
	// return this.idArme+this.idDeplacement;
	// }
}
