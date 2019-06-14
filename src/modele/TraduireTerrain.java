/*
 * 
 */
package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TraduireTerrain {

	private File f;

	private int[][] tab;
	private ObservableList<Integer> list;

	// static final pour taille tableau //class de parametrage / json
	public TraduireTerrain() {
		this.list = FXCollections.<Integer>observableArrayList();
		this.f = new File("src/ressources/main.csv");
		this.tab = new int[50][50];

		this.initTerrain();

	}

	public ObservableList<Integer> getListTerrain() {
		return this.list;
	}

	public int[][] getTab() {
		return this.tab;
	}

	public void initTerrain() {

		BufferedReader bfr = null;
		try {
			bfr = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;

		String ligne;
		String[] all_Line;

		try {
			while ((ligne = bfr.readLine()) != null) {

				all_Line = ligne.split(",");

				for (int j = 0; j < all_Line.length; j++) {

					this.tab[i][j] = Integer.parseInt(all_Line[j]);
					this.list.add(Integer.parseInt(all_Line[j]));

				}
				i++;

			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bfr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}