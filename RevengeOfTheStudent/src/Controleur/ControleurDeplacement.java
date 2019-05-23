package Controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import modele.Personnage;

public class ControleurDeplacement {

	private Personnage perso;

	private BorderPane borderPane;

	public ControleurDeplacement(Personnage perso, BorderPane borderPane) {
		this.perso = perso;
		this.borderPane = borderPane;
	}

	public void keyPressed() {
		this.borderPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					System.out.println("sa marche");
				}
			}
		});
	}

}
