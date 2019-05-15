package modele;

public abstract class Outils {
	private String nom;
	private int degat;
	
	protected Outils(String nom, int degat) {
		this.nom= nom;
		this.degat=degat;
	}
	
	public abstract boolean couperBois();
	
	public abstract boolean casserMinerai();

}
