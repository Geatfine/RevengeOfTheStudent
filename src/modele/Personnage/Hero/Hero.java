package modele.Personnage.Hero;

import Controleur.Controleur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Position;
import modele.Terrain;
import modele.Item.Arme;
import modele.Item.Item;
import modele.Item.Katana;
import modele.Movable.Movable;
import modele.Personnage.Personnage;
import modele.Inventaire;

public class Hero extends Movable implements Personnage {

	private Position position;

	private String nom;
	private int hp;
	private int attaque;
	private int defense;
	private int mana;
	private int vitesse;
	private int energie;
	private Inventaire inventaire;
	// private Accessoire accessoire;
	private Item item;
	private Arme arme;
	private StringProperty idArme;
	private StringProperty idDeplacement;
	private Collision colision;
	private StringProperty itemProperty;

	public Hero(String nom, Collision c, Terrain terrain) {
		if (c == null)
			throw new Error("sss");
		this.nom = nom;
		this.arme = new Katana();
		this.hp = 10;
		this.attaque = 0;
		this.defense = 0;
		this.mana = 0;
		this.vitesse = 1;
		this.inventaire = new Inventaire();
		this.idArme = this.arme.idProperty();
		this.energie = 10;
		item = new Item(10, "test", 20);
		position = new Position(300, 200, c, terrain);
		this.colision = c;
		this.idDeplacement = this.position.dernierDeplacement;
	}

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
		if (this.arme == null)
			return this.attaque;
		return this.attaque + arme.getDegat();
		// return (a==null)? this.attaque:this.attaque + a.getDegat();
	}

	public void attaquer(Personnage p) {
		p.recevoirDegagt(this.getDegatDattaque());
	}

	public void recevoirDegagt(int degat) {
		this.hp -= degat;

	}

	public void ajouterArme(Arme a) {
		this.perdreArme();
		this.arme = a;
	}

	public void perdreArme() {
		this.arme = null;
	}

	public int getDefense() {
		return this.defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Position getDeplacement() {
		return this.position;
	}

	public IntegerProperty idItemProperty() {
		return this.item.getItemProperty();
	}

	public void poserBlock(int x, int y) {
		this.position.transmetTerrain(x / 16, y / 16, this.item.getItem());
	}

	public Inventaire getInventaire() {
		return this.inventaire;
	}

	public void ramasserItem(Item i) {
		this.inventaire.addItem(i);
	}

	public void casserBlock(int x, int y) {
		// a revoir les conditions
		// if ((this.position.xProperty().get() + 10 > x &&
		// this.position.xProperty().get() + 10 > y)
		// && ((this.position.xProperty().get() - 10 < x &&
		// this.position.xProperty().get() - 10 < y)))
		this.position.transmetTerrain(x / 16, y / 16, 151);
		// else
		// System.out.println("ne peux pas casser");
	}

	public void tic() {
		if (!this.colision.estDansLair(this.position.xProperty().get(), this.position.yProperty().get())) {
			this.energie = 0;
			if (Controleur.toucheSaut == Controleur.DIRECTIONHAUT)
				this.energie = 90;
			Controleur.toucheSaut = Controleur.PASBOUGER;

		} else // il vole
			this.energie--;
		int y = this.position.testeTranslationSaut(energie);
		this.position.deplacementVertical(y);
		if (Controleur.toucheDirection == Controleur.DIRECTIONGAUCHE && this.colision
				.verifieCaseGauche((this.position.xProperty().get()) / 16, this.position.yProperty().get() / 16))
			this.position.deplacementLateral(-3);
		if (Controleur.toucheDirection == Controleur.DIRECTIONDROITE && this.colision
				.verifieCaseDroite((this.position.xProperty().get()) / 16, this.position.yProperty().get() / 16))
			this.position.deplacementLateral(3);
		Controleur.toucheDirection = Controleur.PASBOUGER;

	}

	// public StringProperty String() {
	// return this.idArme+this.idDeplacement;
	// }
}
