package modele.Personnage.Hero;

import Controleur.Controleur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Inventaire;
import modele.Katana;
import modele.Position;
import modele.Personnage.Personnages;
import modele.Personnage.Item.Arme;
import modele.item.Block;
import modele.item.Item;

public class Hero extends Personnages{
	
	
	private int mana;
	private Arme a;
	private StringProperty idArme ;
	private Item item;
	public static Hero h;
	private Inventaire inventaire;


	
	public Hero(String nom, Collision c) {
		
		super(nom, c);
		Hero.h=this;
		if(c == null)
			throw new Error("sss");
		this.a= new Katana();
		this.mana=0;
		item = new Item(10, "test", 20);
		this.inventaire=new Inventaire();
		this.idArme= this.a.idProperty();
		position = new Position (200,200, c);
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
	
	@Override
	public String getIdArme() {
		return this.idArme.get();
	}
	
	
	@Override
	public String action() {
		return this.idArme.get() + this.idDeplacement.get();
	}
	
	public StringProperty idArmeProperty() {
		return this.idArme;
	}
	
	public StringProperty idDeplacementProperty() {
		return this.idDeplacement;
	}

	@Override
	public int getDegatDattaque() {
		if(this.a == null)
			return this.attaque;
		return this.attaque + a.getDegat();
		//return (a==null)? this.attaque:this.attaque + a.getDegat();
	}

	public void attaquer (Personnages p) {
		p.recevoirDegat(this.getDegatDattaque());
	}

	public void recevoirDegat(int degat) {
		this.hp.set(this.hp.get()-degat);
		
	}
	protected void ajouterArme(Arme a) {
		this.perdreArme();
		this.a=a;	
	}
	public void perdreArme() {
		this.a=null;
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
	public void  merciHomps() {
		this.vitesse=1;
	}
	
//	public void tomber(int gravite) {
//		this.getDeplacement().deplacementBas();
//		
//		
//	}
//	public void poserBlock(int x,int y) {
//		this.position.transmetTerrain( x/50, y/16, this.item.get());
//	}


	public void game() {
		
		if(!this.colision.verifieCase(this.position.xProperty().get(), this.position.yProperty().get())){
			char c =Controleur.toucheSaut;
			Controleur.toucheSaut = Controleur.PASBOUGER;
			this.energie=0;
			//System.out.println(c);
			if(c==Controleur.DIRECTIONHAUT)
				this.energie+=90;
			
				
		}
		else 
			this.energie--;
		int y = this.position.testeTranslationSaut(energie);
		this.position.deplacementVertical(y);
		
		char d = Controleur.toucheDirection;
		Controleur.toucheDirection = Controleur.PASBOUGER;
		
		
		
		if(d==Controleur.DIRECTIONDROITE) {
			if (vitesse == 0)
				vitesse=1;
			vitesse++;
			if(vitesse>=13)
				vitesse=13;
		this.position.deplacementLateral(this.position.testeTranslationLateral(vitesse));
		
		}
		if( d==Controleur.DIRECTIONGAUCHE) {
			
		
			if (vitesse == 0) 
				vitesse=-1;
			vitesse--;
			
		
			if(vitesse<=(-13))
				vitesse=-13;
			
			this.position.deplacementLateral(this.position.testeTranslationLateral(vitesse));
			
			if(this.hp.get()<=0)
				super.tue();

			
		}
		
			
	}
	// non fini
	public void faireAction(int x, int y) {

		this.poserBlock(x, y);
		this.casserBlock(x, y);

	}

	public boolean estPlein() {
		return this.inventaire.estPlein();
	}

	public void prendreItemMain(Item item2) {

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

		this.position.transmetTerrain(x / 16, y / 16, 151);
		this.ramasserItem(new Block("grass", 24, 10));

	}
	
	

}