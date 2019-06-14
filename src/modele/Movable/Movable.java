package modele.Movable;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import modele.Collision;
import modele.Position;
import modele.Terrain;
import modele.Personnage.Personnages;

public abstract class Movable {
	protected  Position position;
	protected Collision colision;
	protected StringProperty idDeplacement;
	
	public abstract String action();
	
	public abstract void tic();

	public abstract IntegerProperty hpProperty();

	public abstract Position getPosition();
	
	public abstract boolean enVie();

	public abstract String getNom();

	public abstract StringProperty idDeplacementProperty() ;

	
	


}
