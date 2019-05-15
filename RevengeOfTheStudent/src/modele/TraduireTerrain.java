package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TraduireTerrain {
	
	private File f;
	
	private BufferedReader bfr;
	
	private String[][] tab;
	
	
	public TraduireTerrain (String fichier) throws IOException { 
		
		this.f = new File(fichier);
		this.bfr = new BufferedReader ( new FileReader(f));
		this.tab = new String[50][50];
		this.initTab();
		
	}
	
	public BufferedReader getBuffer () {
		return this.bfr;
	}

	public String[][] getTab (){
		return this.tab;
	}
	
	public void initTab () throws IOException {
		
		int i=0;
		
		String ligne;
		String[] all_Line ;
		
		while ((ligne = bfr.readLine()) !=null) {
			
			all_Line = ligne.split(",");
			
			for (int j = 0; j < all_Line.length; j++) {
				
				this.tab[i][j] = all_Line[j];

			}
			i++;
			
		}
	}
}