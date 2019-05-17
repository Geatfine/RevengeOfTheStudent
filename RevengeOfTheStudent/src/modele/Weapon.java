package modele;

public enum Weapon {
	
	epee ("epée", 15),
	pioche ("pioche en bois", 3),
	clavier("clavier legendaire de rety", 35);
	
	private final String nom;
	private final int degat;
	
	Weapon(String n, int deg){
		this.nom=n;
		this.degat=deg;
	}
	
	
	public String getNom() {
		return this.nom;
	} 
	
	public int getDegat() {
		return this.degat;
	}
	public void personnageAvecArme() {
		
		
		switch ()) {
		case epee:
			
			break;

		default:
			break;
		}
	}
	

}
