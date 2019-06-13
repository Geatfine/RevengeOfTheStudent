package modele.Personnage;

import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Position;
import modele.Personnage.Hero.Hero;

public class MarioCataldie extends Ennemie {

	public MarioCataldie(Collision c) {
		super("mario", c);
		if (c == null)
			throw new Error("sss");

		this.hp = 100;
		this.attaque = 0;
		this.defense = 0;
		this.idDeplacement = null;
		this.vitesse = 1;
		this.energie = 100;

		position = new Position(300, 200, c);
		this.colision = c;
		this.idDeplacement = this.position.dernierDeplacement;

	}

	@Override
	public String getIdArme() {
		return "epee";
	}

	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}

	public String iddeplac() {
		return this.position.dernierDeplacement.get();
	}

	public Position getPosition() {
		return this.position;
	}

	@Override
	public void ticEnnemie(Position PosiDuHero) {

		int but = PosiDuHero.xProperty().get();
		int i = this.position.xProperty().get();
		int vecteur;
		if (but - i < 0) {
			vecteur = -1;
		} else {
			vecteur = 1;
		}
		if (i + 40 == but || i - 40 == but)
			vecteur = 0;

		System.out.println(this.position.xProperty().get());
		if (!this.colision.verifieCase(this.position.xProperty().get(), this.position.yProperty().get())) {
			this.energie = 0;
			if (!this.colision.verifieCaseDroite(this.position.xProperty().get(), this.position.yProperty().get())
					|| !colision.verifieCaseGauche(this.position.xProperty().get(), this.position.yProperty().get()))
				this.position.deplacementLateral(vecteur);
		} else
			this.energie--;
		int y = this.position.testeTranslationSaut(energie);
		this.position.deplacementVertical(y);

	}

	@Override
	public void tic() {

	}

}
