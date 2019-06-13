package modele.Personnage.Ennemie;


import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Position;
import modele.Terrain;
import modele.Item.Arme;
import modele.Item.Epee;
import modele.Movable.Movable;
import modele.Personnage.Personnage;

public class MarioCataldie extends Movable implements Personnage {
	
	
	
	
	private Position position;
	private char mouvementSuivant;

	private String nom;
	private int hp;
	private int attaque;
	private int defense;
	private int mana;
	private int vitesse;
	private int energie;
	//private Inventaire inventaire;
	//private Accessoire accessoire;
	private Arme arme;
	private StringProperty idArme ;
	private StringProperty idDeplacement;
	private Collision colision;

	
	
	
	public MarioCataldie(String nom, Collision c,Terrain terrain) {
		if(c == null)
			throw new Error("sss");
		this.nom=nom;
		this.arme= new Epee();
		this.hp=100;
		this.attaque=0;
		this.defense=0;
		this.mana=0;
		this.vitesse=1;
		//this.inventaire= new Inventaire();
		this.idArme= this.arme.idProperty();
		this.energie=100;

		position = new Position (300,200, c,terrain);
		this.colision=c;
		this.idDeplacement=this.position.dernierDeplacement;
		
	}
	
	
	public void nouveauDeplacement(char mouv) {
		this.mouvementSuivant=mouv;
		
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

	public Position getDeplacement() {
		return this.position;
	}
	
	
	@Override
	public void tic() {
		if(!this.colision.estDansLair(this.position.xProperty().get(), this.position.yProperty().get())) {
		
			this.energie=0;
		
			
				
		}
		else
		
			this.energie--;
		int y = this.position.testeTranslationSaut(energie);
		
		this.position.deplacementVertical(y);
			
			
			//this.energie--;
			
		
		}


	@Override
	public int getDegatDattaque() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void attaquer(Personnage p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void recevoirDegagt(int degat) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ajouterArme(Arme a) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void perdreArme() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getDefense() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setDefense(int defense) {
		// TODO Auto-generated method stub
		
	}
		
	
	
	
	

}
