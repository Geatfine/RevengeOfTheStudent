package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Deplacement {
	
	private IntegerProperty x;
	private IntegerProperty y;
	
	public Deplacement ( int x, int y) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
	}
	
	public IntegerProperty getX() {
		return this.x;
	}
	
	public IntegerProperty getY() {
		return this.y;
	}
	
	public void setX(int x) {
		 this.x.set(x);;
	}
	public void setY(int y) {
		this.y.set(y);
	}
}
