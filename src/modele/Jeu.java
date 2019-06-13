package modele;

import modele.Movable.Movable;
import modele.Personnage.MarioCataldie;
import modele.Personnage.Hero.Hero;
import vue.VueTerrain;
import vue.vuePersonnage;

public class Jeu {
	private Hero hero;
	private MarioCataldie mario;
	private Terrain terrain;
	private Collision collision;
	

	
	
	public Jeu() {
	
   terrain = new Terrain(new TraduireTerrain().getTab());
	collision= new Collision(terrain);
	this.hero= new Hero("Chang", collision);
	this.mario = new MarioCataldie(collision);	   
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
		
	

		this.hero.tic();
		this.mario.ticEnnemie(this.hero.getPosition());
		
	}
	
	
	

}
