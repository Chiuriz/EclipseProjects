package it.rocco.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import it.rocco.tilegame.display.Display;
import it.rocco.tilegame.gfx.Assets;
import it.rocco.tilegame.gfx.ImageLoader;
import it.rocco.tilegame.gfx.SpriteSheet;
import it.rocco.tilegame.state.GameState;
import it.rocco.tilegame.state.State;



// con "implements Runnable" permetto alla classe di essere eseguita all'interno di un thread
public class Game implements Runnable {
	
	private Display display;
	public int widht, height;
	public String title;
	private Thread thread; // (nota 1) se permetto alla classe il "runnable" devo creare questo oggetto di tipo thread
	private boolean running = false; //controlla il gameloop
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState;
	
	public Game (String title, int widht, int height) {
		/* assegno i parametri che servono
		 * a questa classe per far visualizzare il display */
		this.widht = widht;
		this.height = height;
		this.title = title;
	}
	
	/* questo metodo verr� eseguito una volta ogni volta che il metodo "run" lo chiamer� 
	 * ed inizializzer� tutta la grafica */
	
	public void init() {
		
		display = new Display (title, widht, height); // creo una istanza della classe Display 
		Assets.init();
		
		gameState = new GameState();
		State.setState(gameState);
		
	}
	


	// aggiorna variabili, posizioni, oggetti, ecc.
	public void tick () {
		
		if (State.getState() != null)
			State.getState().tick();
		
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
		
		if (State.getState() != null)
		State.getState().render(g);
	
		// end drawing
		bs.show();
		g.dispose();
		
	}
	
	
	/* Se permetto alla classe di avviare un thread dentro la classe deve esserci questo metodo (public void run()).
	 * Inizia il game loop (running diventa true) che richiama i metodi "tick" e "render" 
	 * e limita il richiamo di questi metodi a 60 volte al secondo (FPS) (serve per avere la stessa
	 * velocit� di esecuzione su tutti i tipo di computer, veloci e meno veloci) */
	public void run () {
		
		init(); 
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now  - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				ticks ++;
				delta --;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
				
		}
		stop(); //stoppa il thread se ancora non � stoppato (running diventa false)
				
	}
	
	/* i seguenti due metodi fanno partire o stoppare il
	 * thread che nel frattempo ho dichiarato nelle variabili (nota 1)
	 * la keyword "synchronized" di questi metodi si dovrebbe
	 * usare sempre quando si ha a che fare con i Thread */
	
	public synchronized void start() {
		//controlla se il gioco � gia avviato e in quel caso ignora tutto il resto
		if (running)
			return;
		
		//se running � false
		running = true; 
		
		/* inizializzo l'oggetto "thread", come nuovo thread, con il parametro "this"
		 * perch� voglio far partire ed eseguire QUESTA classe (Game), 
		 * che ha l'implementazione Runnable, all'interno di un thread */
		thread = new Thread(this); 
		
		// faccio partire il thread. In questo modo chiamo il metodo "public void run"
		thread.start();
		
	}
	
	public synchronized void stop() {
		//controlla se il gioco � gia stoppato (not running [!running oppure running=false]) e in quel caso ignora tutto il resto
		if (!running)
			return;
		
		/* se running � true, stoppo il thread. Il richiamo del metodo "thread.join"
		 * bisogna includerlo nello statement try --> catch 
		 * altrimenti viene generato un errore */
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}
	
}
