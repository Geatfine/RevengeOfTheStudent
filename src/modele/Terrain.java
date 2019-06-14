package modele;

import javafx.collections.ObservableList;

public class Terrain {

	private ObservableList<Integer> listTerrain;

	/**
	 * 
	 * @param terrain
	 */
	public Terrain(ObservableList<Integer> terrain) {
		this.listTerrain = terrain;
	}

	/**
	 * @return la taille en int de la list
	 */
	public int getTailleX() {
		return this.listTerrain.size();
	}

	/**
	 * @param x ligne
	 * @param y colonne
	 * @return int value du block a une certaine position sur le terrain
	 */
	public int getCase(int x, int y) {
		// x = ligne
		// y = colonne
		int c;

		if (x == 0)
			c = listTerrain.get(y);
		else if (y == 0)
			c = listTerrain.get(this.getLongueurLigneTableau() * x);
		else
			c = listTerrain.get(x * this.getLongueurLigneTableau() + y);

		return c;
	}

	/**
	 * 
	 * @return la l'observableList du terrain
	 */
	public ObservableList<Integer> getListTerrain() {
		return this.listTerrain;
	}

	/**
	 * @return le block a une certaine positions x
	 */
	public int getCase(int x) {
		return this.listTerrain.get(x);
	}

	/**
	 * @param x               ligne
	 * @param y               colonne
	 * @param nouvelleElement qui remplaceras l'ancien block (d'air)
	 */
	public void setCase(int x, int y, int nouvelleElement) {

		if (nouvelleElement == 151 || this.getCase(x, y) == 151) {
			if (x == 0)
				listTerrain.set(y, nouvelleElement);
			else if (y == 0)
				listTerrain.set(this.getLongueurLigneTableau() * x, nouvelleElement);
			else
				listTerrain.set(x * this.getLongueurLigneTableau() + y, nouvelleElement);
		}

	}

	/**
	 * 
	 * @return un entier correspondant a la longueur d'une ligne de la liste
	 */
	public int getLongueurLigneTableau() {
		return (int) Math.sqrt(this.listTerrain.size());
	}

}