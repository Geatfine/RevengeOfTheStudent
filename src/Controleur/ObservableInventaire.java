package Controleur;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.Personnage.Hero.Hero;
import vue.VueInventaire;

public class ObservableInventaire implements ChangeListener<String> {

	private Hero hero;
	private VueInventaire inventaire;
	
	
	public ObservableInventaire(Hero hero,VueInventaire inventaire) {
		this.hero=hero;
		this.inventaire=inventaire;
	}
	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		
		this.inventaire.changerImage(this.hero.getIdArme()+newValue);
		System.out.println(this.hero.getIdArme()+newValue);
		this.inventaire.remplir();
		
	}

}
