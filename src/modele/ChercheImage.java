package modele;

import modele.Personnage.Hero.Hero;

public class ChercheImage {
	private String idImage;
	
	
	public ChercheImage(Hero h) {
		this.idImage="src/ressource/ImagePerso/" + h.toString()+".png";
	}

}
