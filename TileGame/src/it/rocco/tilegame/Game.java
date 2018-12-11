package it.rocco.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import it.rocco.tilegame.display.Display;
import it.rocco.tilegame.gfx.ImageLoader;
import it.rocco.tilegame.gfx.SpriteSheet;

/* questa sarà la classe principale del gioco.
 * Viene chiamata dalla classe "Launcher".
 * Qui verrà scritto il codice che farà girare
 * il gioco, lo visualizzerà, lo stopperà, ecc. */

// con "implements Runnable" permetto alla classe di essere eseguita all'interno di un thread
public class Game implements Runnable {
	
	private Display display;
	public int widht, height;
	public String title;
	private Thread thread; // (nota 1) se permetto alla classe il "runnable" devo creare questo oggetto di tipo thread
	private boolean running = false; //controlla il gameloop
	private BufferStrategy bs;
	private Graphics g;
	
	public Game (String title, int widht, int height) {
		/* assegno i parametri che servono
		 * a questa classe per far visualizzare il display */
		this.widht = widht;
		this.height = height;
		this.title = title;
	}
	
	/* questo metodo verrà eseguito una volta ogni volta che il metodo "run" lo chiamerà 
	 * ed inizializzerà tutta la grafica */
	
	public void init() {
		
		display = new Display (title, widht, height); // creo una istanza della classe Display 
		
		
	}
	
	// aggiorna variabili, posizioni, oggetti, ecc.
	public void tick () {
		
	}
	
	// disegna tutto sul canvas dopo l'update
	//le seguenti righe di codice inizilizzano la variabile bs con il canvas ed il buffer strategy attuale del display 
	public void render () {
		bs = display.getCanvas().getBufferStrategy();
			if (bs == null) { // crea il bufferstrategy sul canvas se attualmente non e' creato
				display.getCanvas().createBufferStrategy(3);
				return;
			}
		g = bs.getDrawGraphics();
		// cancella lo schermo
		g.clearRect(0, 0, widht, height);
		// start drawing
		
			
		
		
		// end drawing
		bs.show();
		g.dispose();
		
	}
	
	/* dentro la classe, o alla fine, deve esserci questo metodo (public void run() ).
	 * Se permetto alla classe di avviare un thread.
	 * in questo metodo verrà scritta la maggior parte del codice del gioco
	 * game loop compreso:
	 * 
     *     (DIAGRAMMA GAME LOOP)
	 * 				  ---------------------  
	 * 				  |                   | 
	 * --------------------------------   |
	 * | AGGIORNA TUTTE LE VARIABILI, |   | 	
	 * | POSIZIONI, OGGETTI, ECC. 	  |   |
	 * |   (con metodo "update")	  |   |
	 * --------------------------------   |
	 * 				  |                   |
	 * --------------------------------   |
	 * |    DISEGNA  TUTTO SULLO      |   |
	 * |  	       SCHERMO			  |	  |
	 * |     (con metodo "render") 	  |   |
	 * --------------------------------   |
	 * 				  |                   |
	 *                ---------------------
	 */ 
	public void run () {
		//richiama il metodo init che inizializza la grafica del gioco
		init(); 
		
		// inizia il game loop (running diventa true) che richiama i metodi "update" e "render"
		while (running) {  
			tick();
			render();
		}
		stop(); //stoppa il thread se ancora non è stoppato (running diventa false)
				
	}
	
	/* i seguenti due metodi fanno partire o stoppare il
	 * thread che nel frattempo ho dichiarato nelle variabili (nota 1)
	 * la keyword "synchronized" di questi metodi si dovrebbe
	 * usare sempre quando si ha a che fare con i Thread */
	
	public synchronized void start() {
		//controlla se il gioco è gia avviato e in quel caso ignora tutto il resto
		if (running)
			return;
		
		//se running è false
		running = true; 
		
		/* inizializzo l'oggetto "thread", come nuovo thread, con il parametro "this"
		 * perchè voglio far partire ed eseguire QUESTA classe (Game), 
		 * che ha l'implementazione Runnable, all'interno di un thread */
		thread = new Thread(this); 
		
		// faccio partire il thread. In questo modo chiamo il metodo "public void run"
		thread.start();
		
	}
	public synchronized void stop() {
		//controlla se il gioco è gia stoppato (not running [!running oppure running=false]) e in quel caso ignora tutto il resto
		if (!running)
			return;
		
		/* se running è true, stoppo il thread. Il richiamo del metodo "thread.join"
		 * bisogna includerlo nello statement try --> catch 
		 * altrimenti viene generato un errore */
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}
	
}
