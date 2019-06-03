package modele.Accessoire;

public class Accessoire {
	
	private int id;
	private String nom;
	private String description;
	private int caracteristique;
	
	public Accessoire(int id, String nom, String desc, int carac) {
		this.id=id;
		this.nom=nom;
		this.description=desc;
		this.caracteristique=carac;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getCaracteristique() {
		return this.caracteristique;
	}
	

}
