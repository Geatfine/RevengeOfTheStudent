package modele.item;

/**
 * Outil
 */
public class Outil extends Item {

    private String nom;

    public Outil(String nom, int id, int quantité) {
        super(id, nom, 1);
    }

    public String getNom() {
        return this.nom;
    }

}