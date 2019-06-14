package Controleur;

import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.Personnage.Personnages;
import modele.Personnage.Hero.Hero;
import vue.Vue;
import vue.vuePersonnage;

public class OberservablePersonnage implements ChangeListener<String>{
	
	private Personnages perso;
	private Vue vue;
	
	

	public OberservablePersonnage(Personnages perso, Vue  vue) {
		super();
		this.perso = perso;
		this.vue = vue;
	}



	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		
		this.vue.setStr(this.perso.getIdArme()+newValue);
		try {
			this.vue.setImageV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	

}
}