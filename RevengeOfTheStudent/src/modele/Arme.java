package modele;

public abstract class Arme {
	private int degat;
	private String nom;
	
	public Arme(String nom, int deg) {
	
			this.nom= nom;
			this.degat=deg;
		
		
	}

	public int getDegat() {
		// TODO
		return this.degat;
				
	}

}
