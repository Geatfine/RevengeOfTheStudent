package modele;

public abstract class Arme {
	private int degat;
	private String nom;
	private int idArme;
	
	
	public Arme(String nom, int deg, int id) {
	
			this.nom= nom;
			this.degat=deg;
			this.idArme=id;
			
		
		
	}

	public int getDegat() {
		// TODO Auto-generated method stub
		return this.degat;
				
	}
	
	public int getId() {
		return this.idArme;
	}
	
	public String toString() {
		return this.nom;
	}

}
