package modele;

public class Terrain {
	
	private String[][] terrain ;
	
	public Terrain (String[][] terrain) {
		
		this.terrain = terrain;
		
	}
	
	public int getTailleX () {
		return this.terrain.length;
	}
	
	public int getTailleY() {
		return this.terrain[0].length;
	}
	
	public String[][] getList () {
		return this.terrain;
	}
	
	public void AffTerrain () {
		
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				System.out.print("  " + terrain[i][j]);
			}
			System.out.println();
		}
	}
	
	
}