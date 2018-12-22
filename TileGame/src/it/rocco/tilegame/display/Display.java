package it.rocco.tilegame.display;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;


	public class Display {
	
		private JFrame frame;
		private Canvas canvas;
		
		private String title;
		private int widht, height;
	
	//costruttore del frame. Riceve titolo, larghezza e altezza.
	public Display (String title, int widht, int height) {
		this.title = title;
		this.widht = widht;
		this.height = height;
		
		createDisplay();
		
	}
	
	private void createDisplay() {
		// assegno i parametri all'oggetto frame.
		frame = new JFrame (title);
		
		frame.setSize (widht, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		/* canvas è la "tela" dove tutta la grafica viene disegnata
		 * e le dimensioni vengono impostate creando una "new dimension"
		 * che gli assegna larghezza e altezza */
		canvas = new Canvas(); 
		canvas.setPreferredSize(new Dimension (widht, height));
		/* queste due righe di codice servono per essere sicuri che
		 * il canvas mantenga sempre le proporzioni della finestra */
		canvas.setMaximumSize(new Dimension (widht, height));
		canvas.setMinimumSize(new Dimension (widht, height));
		canvas.setFocusable(false);
		// aggiunge il canvas al frame
		
		frame.add(canvas); 
		// questo metodo serve per essere sicuri che il canvas venga visualizzato completamente nel frame
		frame.pack(); 
		
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}