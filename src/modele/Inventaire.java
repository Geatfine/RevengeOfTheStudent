package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.item.Item;
import modele.item.Outil;

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
        this.listItem.add(new Outil("pioche", 1, 1));
        this.listItem.add(new Outil("hache", 2, 1));
    }

    /**
     * @param Item i
     */
    public void addItem(Item i) {
        if (i != null && this.listItem.size() < 13 && !this.estPresent(i))
            this.listItem.add(i);
    }

    public boolean estPresent(Item i) {
        for (Item j : this.listItem)
            if (j.getItemProperty().get() == i.getItemProperty().get())
                return true;

        return false;
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

    public boolean estPlein() {
        if (this.listItem.size() == 13)
            return true;
        return false;
    }
}
