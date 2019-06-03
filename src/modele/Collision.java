package modele;


	import modele.Terrain;

	public class Collision {

	    private Terrain terrain;

	    public Collision(Terrain terrain) {
	        this.terrain = terrain;
	    }
	    
	    
	    public boolean verifieCase(int x, int y) {
	    	x/=16;
	    	y/=16;
	    	if (x >= 0 && x < 50) 
	    		if(this.terrain.getCase(y+2, x)==151)
	    			return true;
	    	
	    	return false;
	    }

	    public boolean verifieCaseDroite(int x, int y) {
	        if (x >= 0 && x < 50) 
	            if ( x< 48 && this.terrain.getCase(y, x) == 151)
	                return true;
	        
	        return false;
	    }

	    public boolean verifieCaseGauche(int x, int y) {
	        if (x >= 0 && x < 50) 

	            if (x>0 && this.terrain.getCase(y, x) == 151)
	                return true;
	        
	        return false;
	}

	    public boolean verifieCaseHaut(int x, int y) {
	        if (y >= 0 && y < 50) 
	            if (y >0 && this.terrain.getCase(y-1, x) == 151)
	                return true;
	        
	        return false;
	    }
	    
	    
	    

	    public boolean verifieCaseBas(int x, int y) {
	        if (y >= 0 && y < 50) 
	            if (y< 48 && this.terrain.getCase(y+2, x) == 151)
	                return true;
	        
	        return false;
	    }

	}


