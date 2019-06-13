package Controleur;

import javafx.collections.ListChangeListener;
import modele.Item.Item;
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
		System.out.println("ca marche");
		if (c.equals(new Item(10, "herbe", 20))) {
			this.hero.ramasserItem(new Item(10, "herbe", 20));
		}
	}

}
