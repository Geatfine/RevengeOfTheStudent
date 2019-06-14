package Controleur;

import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.Movable.Movable;
import modele.Personnage.Personnages;
import vue.Vue;

public class ObservableEnnemie implements ChangeListener<String> {
	private Movable perso;
	private Vue vue;
	
	

	public ObservableEnnemie(Movable perso, Vue  vue) {
		this.perso = perso;
		this.vue = vue;
	}



	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		
		this.vue.setStr(this.perso.action()+newValue);
		try {
			this.vue.setImageV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

}
}
