package modele.item;

public class Block extends Item{

	private int idBlock;
	
	public Block(String nom, int quantite,int id) {
		super(10,nom, quantite);
		this.idBlock=id;
		
	}
	
	public int getIdBlock() {
		return this.idBlock;
	}
	
	

}
