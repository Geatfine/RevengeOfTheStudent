package modele;

import modele.Personnage.Hero.Hero;
import vue.VueTerrain;
import vue.vuePersonnage;

public class Jeu {
	private Hero hero;
	private Terrain terrain;
//private Controleur c;   
	//private arrayList<Movable> list;
	private Collision collision;
	

	
	
	public Jeu() {
	
   terrain = new Terrain(new TraduireTerrain().getTab());
	collision= new Collision(terrain);
		   this.hero= new Hero("Chang", collision);
	}
	
	
	//public void ajoutMovable(int a, int x, int y)
	//Movable m = CreateurDeMovable(a, x, y);
	//list.add(m)
	//c.addMovable(a);
	public Terrain getTerrain() {
		return this.terrain;
	}
	
	public Hero getHero() {
		return this.hero;
	}
	
	public void gravite() {
	}

	public void tour() {
		
	

		this.hero.tic();
		
	}
	
	
	

}
