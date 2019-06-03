package application;
	
import java.security.Permissions;

import Controleur.GameLoop.BoucleDeJeu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.Personnage.Hero.Hero;

/*
 * soulager controlleur
 * faire des sous package fait
 * respecter les convention de nommage des property
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../vue/vueJeu.fxml"));
			Scene scene = new Scene(root,800,800);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.requestFocus();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Revenge Of The Student");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
