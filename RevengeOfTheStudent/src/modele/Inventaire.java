package modele;

import java.util.ArrayList;

public class Inventaire {
	private ArrayList<Arme> listeArmes;
	private ArrayList<Outils> listeOutils;
	private ArrayList<Consommable> listConso;

	public Inventaire() {
		this.listeOutils = new ArrayList<Outils>();
		this.listeOutils.add(new Pioche());

		this.listeArmes = new ArrayList<Arme>();

	}

	public void ajouterOutils(Outils o) {
		this.listeOutils.add(o);

	}

}
