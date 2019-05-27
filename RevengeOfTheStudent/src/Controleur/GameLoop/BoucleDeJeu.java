package Controleur.GameLoop;

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
				(ev->turn())
		);
		this.tour.getKeyFrames().add(frame);
	}

	private Object turn() {
		
		this.controleur.tour();



return null;
	}

}
