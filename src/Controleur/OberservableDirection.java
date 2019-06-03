package Controleur;

import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.Personnage.Hero.Hero;
import vue.vuePersonnage;

public class OberservableDirection implements ChangeListener<String>{
	
	private Hero hero;
	private vuePersonnage vue;
	
	

	public OberservableDirection(Hero hero, vuePersonnage vue) {
		super();
		this.hero = hero;
		this.vue = vue;
	}



	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		
		this.vue.setStr(this.hero.getIdArme()+newValue);
		try {
			this.vue.setImageV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
