package modele.Movable;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.Terrain;

public abstract class Movable {
	
	public abstract ArrayList<Moove> tour();
	private int row;
	private int column;
	private Terrain map;
	private int cycle;						// nombre de tour pour effectuer une action
	private int tour ;						// est un compteur relatif a cycle
	private double moveCoefficient;
	private IntegerProperty safeImageValueProperty;
	private IntegerProperty imageValueProperty;
	private int defaultImage;
private int baseCycle;


public Movable(Terrain map,int cycle, int row, int column,double moveCoefficient,int defaultImage) {
	if(cycle < 0 || moveCoefficient < 0 )
		throw new IllegalArgumentException("Invalid Parameter");
	setCellId(row, column);
	this.map = map;
	this.moveCoefficient = moveCoefficient;
	this.cycle = cycle;
	this.tour = 0;	
	this.baseCycle=cycle;
	this.defaultImage = defaultImage;
initialiseImageProperty();
}

private void initialiseImageProperty() {
	this.imageValueProperty = new SimpleIntegerProperty(this.defaultImage);
	this.safeImageValueProperty = MethodeUtil.copyIntegerProperty(imageValueProperty );
}
public final void setCellId(int row,int column) {
	
	if(Statics.isInMap(row, column)) {
		this.row = row;
		this.column = column;
	}
	else
		throw new IllegalArgumentException ("THE POSITION OF THE CHARACTER IS WRONG");	

} 

}
