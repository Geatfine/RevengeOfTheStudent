package Controleur;

import javafx.collections.ListChangeListener;
import modele.item.Item;
import modele.Personnage.Hero.Hero;
import vue.VueInventaire;

public class ObservableInventaire implements ListChangeListener<Item> {

	private Hero hero;
	private VueInventaire inventaire;

	public ObservableInventaire(Hero hero, VueInventaire inventaire) {
		this.hero = hero;
		this.inventaire = inventaire;
	}

	@Override
	public void onChanged(Change<? extends Item> c) {
		System.out.println("change");
		if (c.next()) {
			this.inventaire.changerImage(Integer.toString(
					this.hero.getInventaire().getItem(this.hero.getInventaire().size() - 1).getItemProperty().get()));
			this.inventaire.ajouteImage();
			this.inventaire.remplir();
		}
	}

}