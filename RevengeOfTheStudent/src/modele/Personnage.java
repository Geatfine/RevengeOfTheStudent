package modele;

public class Personnage {
	
	private Deplacement moove;
	private String nom;
	private int hp;
	private int attaque;
	private int defense;
	private int mana;
	private int vitesse;
	private Inventaire inventaire;
	private Accessoire accessoire;
	private Arme a;
	private Collision colision;


	
	
	public Personnage(String nom) {
		this.nom=nom;
		this.hp=100;
		this.attaque=0;
		this.defense=0;
		this.mana=0;
		this.vitesse=1;
		this.inventaire= new Inventaire();
		moove = new Deplacement (0,0);
	}


	public int getDegatDattaque() {
		if(this.a == null)
			return this.attaque;
		return this.attaque + a.getDegat();
		//return (a==null)? this.attaque:this.attaque + a.getDegat();
	}

	public void attaquer (Personnage p) {
		p.recevoirDegagt(this.getDegatDattaque());
	}

	public void recevoirDegagt(int degat) {
		this.hp-= degat;
		
	}
	protected void ajouterArme(Arme a) {
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

	public Deplacement getDeplacement() {
		return this.moove;
	}
}
