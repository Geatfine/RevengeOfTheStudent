package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Movable.Movable;

public abstract class Vue {

	protected Pane pane;

	protected Image img_perso;
	protected String s;
	protected ImageView imgV_perso;
	
	public Vue(Pane pane) {
		this.pane=pane;
		
		
	}

	public abstract void setStr(String s) ;

	public abstract void setImageV() throws FileNotFoundException ;
		// TODO Auto-generated method stub
		
	public abstract void clear();

}
