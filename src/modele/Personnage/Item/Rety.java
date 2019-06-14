package modele.Personnage.Item;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Fleche;
import modele.Jeu;
import modele.Position;
import modele.Personnage.Ennemie;
import modele.Personnage.Homps;
import modele.Personnage.Personnages;
import modele.Personnage.Hero.Hero;

public class Rety extends Ennemie{
	

	private int compteur;
	private Fleche fleche;
	






	public Rety( Collision c) {
		super("Rety", c);
		if(c == null) 
			throw new Error("sss");
		this.fleche=null;
		this.attaque=1;
		this.defense=0;
		this.idDeplacement=null;
		this.vitesse=1;
		this.energie=0;

		position = new Position (500,450, c);
		this.colision=c;
		this.idDeplacement=this.position.dernierDeplacement;

	}
	
	@Override
	public String getNom() {
		return this.nom;
	}
	
	@Override
	public IntegerProperty hpProperty() {
		return this.hp;
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
	public String getIdArme() {
		return "katana";
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


	
	private void creeFleche() {
		fleche = new Fleche(this.position);
	}
	
	private  void ticEnnemie(Hero hero) {
		compteur--;

		//this.hp.set(this.hp.get()-20);
		
		
		int positionDuHero = hero.getPosition().xProperty().get();
		int i = this.position.xProperty().get();
		int vecteur=0;
		if((i-200==positionDuHero || i+200==positionDuHero) && compteur<0)   {
			
			vecteur=0;

			this.hp.set(this.hp.get()-30);
		Position p = new Position(this.position.xProperty().get(), this.position.yProperty().get(), this.colision);
		Jeu.j.addNouveau(new Fleche(p));
			
			
			compteur=700;
			if(this.hp.get()<=0)
				super.tue();
		}
		
		if(positionDuHero-i<0) {
			if(positionDuHero-i <-200) {
				vecteur=-1;
			this.idDeplacement.set("Gauche");
			}
			else {
				//vecteur=+1;
			//this.idDeplacement.set("Droite");
			}
		}
		else {
			if(positionDuHero -i <200) {
				vecteur=1;
				this.idDeplacement.set("Droite");
			}
			else {
				vecteur=-1;
				this.idDeplacement.set("Gauche");
			}
			
		
	
		}
	
		
		
		
		if(!this.colision.verifieCase(this.position.xProperty().get(), this.position.yProperty().get())) {
			this.energie=0;


			if (!this.colision.verifieCaseDroite(this.position.xProperty().get(), this.position.yProperty().get()) || !colision.verifieCaseGauche(this.position.xProperty().get(), this.position.yProperty().get()))
			{
				this.position.deplacementLateral(vecteur);
				

			}


		}
		else 


			this.energie--;
		int y = this.position.testeTranslationSaut(energie);

		this.position.deplacementVertical(y);





	}



	



	private void removeFleche() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void game() {
		this.ticEnnemie(Hero.h);
		
	}



	@Override
	public String action() {
		return "archer";
	}


}