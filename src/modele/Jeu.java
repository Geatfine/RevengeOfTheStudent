package modele;

import java.util.ArrayList;

import Controleur.Controleur;
import modele.Movable.Movable;
import modele.Personnage.Homps;
import modele.Personnage.Personnages;
import modele.Personnage.Simonot;
import modele.Personnage.Hero.Hero;
import modele.Personnage.Item.Rety;

public  class Jeu {
	public static Jeu j;
	private Hero hero;
	private Homps mario;
	private Terrain terrain;
	private Collision collision;
	private ArrayList<Movable> list;
	private ArrayList <Movable> nouveauArrivant;
	private int nombreDeRety;

	private int nombreDeHomps;

	private int nombreDeSimonot;
	private int compteur=100;
	private Position positionGolven;
	

	
	
	public Jeu() {
		Jeu.j=this;
		this.nombreDeHomps=0;
		this.nombreDeRety=0;
		this.nombreDeSimonot=0;
		
		this.list=new ArrayList<>();
		this.nouveauArrivant=new ArrayList<>();
	
    terrain = new Terrain(new TraduireTerrain().getListTerrain());
	collision= new Collision(terrain);
	this.hero=new Hero("Chang", collision);
	this.addmovable(hero); 
	
	}
	
	public void creationEnnemi() {
		compteur--;
		if(compteur<0) {
		if(this.nombreDeHomps<1   ) {
			Homps echarpe = new Homps(collision);
			addNouveau(echarpe);
			this.nombreDeHomps++;
		}
		if(this.nombreDeRety<1 ) {
			Rety rety = new Rety(collision);
			addNouveau(rety);
			this.nombreDeRety++;
		}
		if(this.nombreDeSimonot<1 ) {
			Simonot velo = new Simonot(collision);
			addNouveau(velo);
			this.nombreDeSimonot++;
		}
		
			compteur=300;
		}
	}
	
	public void creeFleche() {
		Movable f= new Fleche(this.positionGolven);
		
		
		
		
	}
	
	
	private void ennemieMort(int i) {
		this.list.remove(i);
	}
	
	
	
	private void addmovable(Movable personnage) {
		this.list.add(personnage);
		
	}


	public void addNouveau(Movable m){
		nouveauArrivant.add(m);
		}
	

	
	public ArrayList<Movable> getList() {
		return this.nouveauArrivant;
	}
	
	public void modifieListe() {
		this.list.addAll(nouveauArrivant);
		nouveauArrivant.clear();
	}
	


	public Terrain getTerrain() {
		return this.terrain;
	}
	
	
	
	public Hero getHero() {
		return this.hero;
	}
	
	public Homps getMario() {
		return this.mario;
	}
	
	


	public int getTailleListNouveau() {
		return this.nouveauArrivant.size();
	}

	public void tour(Controleur c) {
		for(Movable m: list) {
			m.tic();
		}
		creationEnnemi();
		verifieSiEnVie(c);
		
	
		
	}
	
	public void verifieSiEnVie(Controleur c) {
		
		ArrayList suppprimer= new ArrayList<>();
		for (Movable m:this.list) {

			if (!m.enVie()) {
				suppprimer.add(m);
				c.supprimerMovable(m);
				if(m.getNom()!="Rety")
					this.nombreDeRety--;
				if(m.getNom()=="Homps")
					this.nombreDeHomps--;
				if(m.getNom()=="Simonot")
					this.nombreDeSimonot--;
			}
		}
		this.list.removeAll(suppprimer);
		
			
	}

	public int getTailleListPrincipale() {
		return this.list.size();
		
		
	}
	
	
	

}