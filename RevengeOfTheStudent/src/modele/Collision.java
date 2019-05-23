package modele;

import modele.Terrain;

public class Collision {

    private int[][] casesTerrain;

    public Collision(Terrain terrain) {
        this.casesTerrain = terrain.getList();
    }

    public boolean verifieCaseDroite(int x, int y) {
        if (x >= 0 && x < 50) {
            System.out.println(casesTerrain[x + 1][y]);
            if (casesTerrain[x + 1][y] != 151)
                return true;
        }
        return false;
    }

    public boolean verifieCaseGauche(int x, int y) {
        if (x >= 0 && x < 50) {
            System.out.println(casesTerrain[x + 1][y]);

            if (casesTerrain[x - 1][y] != 151)
                return true;
        }
        return false;
    }

    public boolean verifieCaseHaut(int x, int y) {
        if (y >= 0 && y < 50) {
            System.out.println(casesTerrain[x][y - 1]);
            if (casesTerrain[x][y - 1] != 151)
                return true;
        }
        return false;
    }

    public boolean verifieCaseBas(int x, int y) {
        if (y >= 0 && y < 50) {
            if (casesTerrain[x][y + 1] != 151)
                return true;
        }
        return false;
    }

}
