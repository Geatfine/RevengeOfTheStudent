package vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Fleche;
import modele.Personnage.Ennemie;
import modele.Personnage.Personnages;
import modele.Personnage.Item.Rety;

public class VueFleche extends Vue {
	

	private Pane pane;
	private Image img_perso;
	private FileInputStream fichierPerso;
	private String s;

	private ImageView imgV_fleche;
	
	 public VueFleche(Pane pane, Fleche fleche, Rety mechant) throws FileNotFoundException   {
		 super(pane);
		 this.s="fleche" +mechant.iddeplac();
		this.fichierPerso = new FileInputStream(this.add());
		this.img_perso = new Image(fichierPerso);
		imgV_fleche = new ImageView(img_perso);
	}

	 public void initPerso() throws FileNotFoundException{
			//imgV_perso.setViewport(new Rectangle2D(0,0,128,128));
			
			
			this.pane.getChildren().add(this.imgV_fleche);
		}
	@Override
	public void setStr(String s) {
		this.s=s;
		
	}
	public String add() {
		return "src/ressources/ImagePerso/" + this.s+".png";
	}

	@Override
	public void setImageV() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
