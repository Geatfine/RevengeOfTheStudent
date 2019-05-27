package modele;


	import modele.Terrain;

	public class Collision {

	    private int[][] casesTerrain;

	    public Collision(Terrain terrain) {
	        this.casesTerrain = terrain.getList();
	    }
	    
	    
	    public boolean verifieCase(int x, int y) {
	    	x/=16;
	    	y/=16;
	    	if (x >= 0 && x < 50) 
	    		if(casesTerrain[y][x]==151)
	    			return true;
	    	
	    	return false;
	    }

	    public boolean verifieCaseDroite(int x, int y) {
	        if (x >= 0 && x < 50) 
	            if ( x< 48 && casesTerrain[y][x+2] == 151)
	                return true;
	        
	        return false;
	    }

	    public boolean verifieCaseGauche(int x, int y) {
	        if (x >= 0 && x < 50) 

	            if (x>0 && casesTerrain[y][x-1] == 151)
	                return true;
	        
	        return false;
	}

	    public boolean verifieCaseHaut(int x, int y) {
	        if (y >= 0 && y < 50) 
	            if (y >0 && casesTerrain[y-1][x] == 151)
	                return true;
	        
	        return false;
	    }
	    
	    
	    

	    public boolean verifieCaseBas(int x, int y) {
	        if (y >= 0 && y < 50) 
	            if (y< 48 && casesTerrain[y+2][x] == 151)
	                return true;
	        
	        return false;
	    }

	}


