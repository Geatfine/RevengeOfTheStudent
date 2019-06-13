package modele;

import modele.Movable.Movable;
import modele.Personnage.Ennemie.MarioCataldie;
import modele.Personnage.Hero.Hero;
import vue.VueTerrain;
import vue.vuePersonnage;

public class Jeu {
	private Hero hero;
	private MarioCataldie mario;
	private Terrain terrain;
	private Collision collision;
	

	
	
	public Jeu() {
	
   terrain = new Terrain(new TraduireTerrain().getListTerrain());
	collision= new Collision(terrain);
	this.hero= new Hero("Chang", collision,terrain);
	this.mario = new MarioCataldie("mario", collision,terrain);	   
	}
	
	
//	public void ajoutMovable(int a, int x, int y) {
//	Movable m = CreateurDeMovable(a, x, y);
//	list.add(m);
//	c.addMovable(a);
//	}
//	


	public Terrain getTerrain() {
		return this.terrain;
	}
	
	public Hero getHero() {
		return this.hero;
	}
	
	public MarioCataldie getMario() {
		return this.mario;
	}
	
	public void gravite() {
	}

	public void tour() {
		
	
		this.terrain =new Terrain(new TraduireTerrain().getListTerrain());
		this.hero.tic();
		this.mario.tic();
		
	}
	
	
	

}
