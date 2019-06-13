package modele.Movable;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.Collision;
import modele.Position;
import modele.Terrain;
import modele.Personnage.Personnages;

public abstract class Movable {
	protected  Position position;
	protected Collision colision;
	
	public abstract void tic();
	


}
