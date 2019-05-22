/*
 * 
 */
package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TraduireTerrain {

	private File f;

	private int[][] tab;

	// static final pour taille tableau //class de parametrage / json
	public TraduireTerrain() throws IOException {

		this.f = new File("src/ressources/main.csv");
		this.tab = new int[50][50];
		this.initTerrain();

	}

	public int[][] getTab() {
		return this.tab;
	}

	public void initTerrain() throws IOException {

		BufferedReader bfr = new BufferedReader(new FileReader(f));
		int i = 0;

		String ligne;
		String[] all_Line;

		while ((ligne = bfr.readLine()) != null) {

			all_Line = ligne.split(",");

			for (int j = 0; j < all_Line.length; j++) {

				this.tab[i][j] = Integer.parseInt(all_Line[j]);

			}
			i++;

		}
		bfr.close();
	}
}