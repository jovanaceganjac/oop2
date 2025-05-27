package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Simulacija extends Frame {

	private Scena scena = new Scena();
	
	private void dodajKomponente() {
		setLayout(new BorderLayout());
		add(scena, BorderLayout.CENTER);
	}
	
	private void zaustavi() {
		scena.interrupt();
		dispose();
	}
	
	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				zaustavi();
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_ESCAPE: zaustavi();
				case KeyEvent.VK_SPACE: scena.startStopScena();
				}
			}
		});
	}
	
	public Simulacija() {
		setTitle("Simulacija");
		dodajKomponente();
		dodajOsluskivace();
		setLocation(500, 200);
		pack();
		setResizable(false);
		scena.pocni();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Simulacija();
	}
}
