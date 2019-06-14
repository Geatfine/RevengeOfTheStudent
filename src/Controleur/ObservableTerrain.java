package Controleur;

import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import modele.Terrain;
import vue.VueTerrain;

/**
 * Class Observant le terrain detectant un changement dans les blocks
 */
public class ObservableTerrain implements ListChangeListener<Number> {

	private Terrain terrain;
	private VueTerrain vueTerrain;

	public ObservableTerrain(Terrain terrain, VueTerrain vueT) {
		this.terrain = terrain;
		this.vueTerrain = vueT;
	}

	@Override
	public void onChanged(Change<? extends Number> c) {

		if (c.next())
			try {
				this.vueTerrain.raffraichirTerrain();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

	}

}