package Controleur.GameLoop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class BoucleDeJeu {
	public final static int FRAMEDURATION = 1000;
	
	private boolean estArreter;
	private Timeline tour ;	
	
	public BoucleDeJeu() {
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
		
System.out.println("caca");	



return null;
	}

}
