package modele.Personnage.Item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Arme {
	private int degat;
	private String nom;
	private StringProperty id;
	
	public Arme(String nom, int deg, String id) {
	
			this.nom= nom;
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
