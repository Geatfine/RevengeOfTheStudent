package modele;

public class Terrain {
	
	
	
	private int[][] terrain ;
	
	
	public Terrain (int[][] terrain) {
		
		this.terrain = terrain;
		
	}
	
	public int getTailleX () {
		return this.terrain.length;
	}
	
	public int getTailleY() {
		return this.terrain[0].length;
	}
	
	public int[][] getList () {
		return this.terrain;
	}
		
}