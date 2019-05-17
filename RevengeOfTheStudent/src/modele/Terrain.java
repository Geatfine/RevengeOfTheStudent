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
		
}