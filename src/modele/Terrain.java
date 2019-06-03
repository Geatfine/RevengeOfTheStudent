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
	
	public int[][] getTab () {
		return this.terrain;
	}
	public int getCase(int x,int y) {
		return this.terrain[x][y];
	}
	
	public void setCase(int x,int y,String i) {
		this.terrain[x][y] = Integer.parseInt(i);
	}
		
}