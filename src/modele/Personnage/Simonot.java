package modele.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Position;
import modele.Personnage.Hero.Hero;

public class Simonot extends Ennemie {
	private int compteur;
	private int compteurSaut;






	public Simonot ( Collision c) {
		super("Simonot", c);
		if(c == null) 
			throw new Error("sss");
		this.compteur=0;
		this.compteurSaut=0;

		this.hp= new SimpleIntegerProperty(100);
		this.attaque=1;
		this.defense=0;
		this.idDeplacement=null;
		this.vitesse=1;
		this.energie=0;

		position = new Position (300,450, c);
		this.colision=c;
		this.idDeplacement=this.position.dernierDeplacement;

	}
	@Override
	public String getNom() {
		return this.nom;
	}




	public int getDegatDattaque() {
		return this.attaque ;
	}
	

	public void attaquer (Personnages p) {
		p.recevoirDegat(this.getDegatDattaque());
	}

	public void recevoirDegat(int degat) {
		this.hp.subtract(degat);
		
	}

	@Override
	public IntegerProperty hpProperty() {
		return this.hp;
	}



	@Override
	public String getIdArme() {
		return "epee";
	}


	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}


	public Position getPosition() {
		return this.position;
	}


	public void estAttaquer(int x) {
		
	}


	private  void ticEnnemie(Hero hero) {
		compteur--;


		int but = hero.getPosition().xProperty().get();
		int i = this.position.xProperty().get();
		int vecteur=0;
		if(but-i+20<0) {
			vecteur=-1;
			this.idDeplacement.set("Gauche");
		}
		if(but-i-20>0) {
			vecteur=1;
			this.idDeplacement.set("Droite");
		}
		if((i+20==but|| i-20 == but)   && compteur <0) {
			vecteur=0;
			this.hp.set(this.hp.get()-10);
			
			this.attaquer(hero);
			compteur=50;
		}
		if(this.hp.get()<=0)
			super.tue();

		if(!this.colision.verifieCase(this.position.xProperty().get(), this.position.yProperty().get())) {
			this.energie=0;

			if (!this.colision.verifieCaseDroite(this.position.xProperty().get(), this.position.yProperty().get()) || !colision.verifieCaseGauche(this.position.xProperty().get(), this.position.yProperty().get()) )
			{

				compteurSaut--;

				this.position.deplacementLateral(vecteur);

				if(compteurSaut<0) {
					this.energie=100;
					int y = this.position.testeTranslationSaut(energie);

					this.position.deplacementVertical(y);
					this.position.deplacementLateral(vecteur*10);
				
				compteurSaut=150;
				}

			}

		}
		
		else 


			this.energie--;
		int y = this.position.testeTranslationSaut(energie);

		this.position.deplacementVertical(y);





	}



	@Override
	public void game() {
		this.ticEnnemie(Hero.h);

	}




	@Override
	public String action() {
		return "Simonot" ;
	}
	
	

}