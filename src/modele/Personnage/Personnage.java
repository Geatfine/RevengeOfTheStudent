package modele.Personnage;

import javafx.beans.property.StringProperty;
import modele.Position;
import modele.Item.Arme;

public interface Personnage {
	

	public String getIdArme();
	
	public String action();
	
	public StringProperty idArmeProperty();
	
	public StringProperty idDeplacementProperty();
	
	public int getDegatDattaque();
	
	public void attaquer (Personnage p);
	
	public void recevoirDegagt(int degat);
	
	public void ajouterArme(Arme a);
	
	public void perdreArme();
	
	public int getDefense();
	
	public void setDefense(int defense);
	
	public Position getDeplacement();
	
}

