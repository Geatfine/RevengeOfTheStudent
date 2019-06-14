package modele.Personnage.Item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.item.Item;

public abstract class Arme extends Item{
	private int degat;
	private String nom;
	private StringProperty id;
	
	public Arme(String nom, int deg, String id) {
		super(1, nom, 1);
			this.degat=deg;
			this.id=new SimpleStringProperty(id);
		
		
	}

	public int getDegat() {
		// TODO
		return this.degat;
				
	}
	
	public StringProperty idProperty() {
		return this.id;
	}

}
