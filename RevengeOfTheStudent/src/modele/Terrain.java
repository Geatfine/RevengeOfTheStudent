package modele;

public class Terrain {
	
	private String[][] listLine ;
	
	public Terrain (String[][] list) {
		
		listLine = list;
		
	}
	
	public int getTailleX () {
		return this.listLine.length;
	}
	
	public int getTailleY() {
		return this.listLine[0].length;
	}
	
	public String[][] getList () {
		return this.listLine;
	}
	
	public void AffTerrain () {
		
		for (int i = 0; i < listLine.length; i++) {
			for (int j = 0; j < listLine[0].length; j++) {
				System.out.print("  " + listLine[i][j]);
			}
			System.out.println();
		}
	}
	
	
}