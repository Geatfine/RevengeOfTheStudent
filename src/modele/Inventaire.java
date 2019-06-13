package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Item.*;

/**
 * Inventaire du Hero , Posséde une liste Observable d'item.
 */
public class Inventaire {

    private ObservableList<Item> listItem;

    public Inventaire() {
        this.listItem = FXCollections.<Item>observableArrayList();
        this.initInventaireDeBase();
    }

    /**
     * Class initalisant l'inventaire avec les items de bases du personnages a
     * savoir une épée , hache ,pioche ...
     */
    public void initInventaireDeBase() {
        this.listItem.add(new Katana());
    }

    /**
     * @param Item i
     */
    public void addItem(Item i) {
        if (i != null)
            this.listItem.add(i);
        else
            throw new Error("ATTENTION : L'item est nul");
    }

    /**
     * @param int x represente la position de l'item dans l'inventaire.
     * @return Item si un item est presents sinon retourne null
     */
    public Item getItem(int x) {
        if (x < this.listItem.size() && x > 0)
            return this.listItem.get(x);
        else
            return null;
    }

    /**
     * @return int ( retourne le nombre d'item dans l'inventaire acutellement )
     */
    public int size() {
        return this.listItem.size();
    }

    public ObservableList<Item> getInventaireList() {
        return this.listItem;
    }

}
