package Controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import modele.Personnage.Hero.Hero;

public class ControleurDeplacement {
	
	private Hero perso;
	
	private BorderPane borderPane;
	
	public ControleurDeplacement(Hero perso, BorderPane borderPane) {
		this.perso = perso;
		this.borderPane=borderPane;
	}
	public void keyPressed() {
		borderPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        public void handle(KeyEvent ke) {
	            if (ke.getCode() == KeyCode.ESCAPE) {
	            }
	        }
	    });
	}
	
	

}
