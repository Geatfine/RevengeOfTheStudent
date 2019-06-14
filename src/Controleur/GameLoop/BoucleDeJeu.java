package Controleur.GameLoop;

import java.io.FileNotFoundException;

import Controleur.Controleur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import modele.Jeu;

public class BoucleDeJeu {
	public final static int FRAMEDURATION = 10;
	public final static int VITESSE = 40;

	
	private boolean estArreter;
	private Timeline tour ;	
	private Controleur controleur;
	
	
	public BoucleDeJeu(Controleur c) {
		this.controleur = c;
		
		this.tour= new Timeline();
		this.estArreter=false;
		initialiseBoucle();
	}
	
	public void start() {
		this.tour.play();
		this.estArreter=false;
	}
	
	/*
	 * Arrete la gameLoop
	 */
	public void stop() {
		this.tour.stop();
		this.estArreter=true;
	}
	
	private void initialiseBoucle() {
		this.tour.setCycleCount(Timeline.INDEFINITE);
		KeyFrame frame = new KeyFrame(
				Duration.millis(FRAMEDURATION),
				(ev->{
					try {
						turn();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				})
		);
		this.tour.getKeyFrames().add(frame);
	}

	private Object turn() throws FileNotFoundException {
		
		this.controleur.tour();



return null;
	}

}
