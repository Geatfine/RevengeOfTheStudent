package modele.Item;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public  class Item {
	
	private String nom;
	private int quantite_Max;
	private IntegerProperty id;

	
	public Item (int i,String nom,int quantite) {
		id = new SimpleIntegerProperty(i);
		this.nom=nom;
		this.quantite_Max=quantite;
		
	}
	
	public int getItem() {
		return this.id.get();
	}
	
	public IntegerProperty getItemProperty() {
		return this.id;
	}

}
