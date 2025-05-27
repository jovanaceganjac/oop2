package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Scena extends Canvas implements Runnable {

	private Skup figure = new Skup();
	private Usisivac usisivac;
	private Thread thread = new Thread(this);
	private boolean radi;

	private void dodajOsluskivace() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getParent().requestFocus();
				if (e.getButton() == MouseEvent.BUTTON1) {
					dodajFigure(new Kamencic(e.getX(), e.getY()));
				}
			}
		});
	}

	private synchronized void dodajFigure(Figura f) {
		try {
			figure.prvaJeTek();
			boolean preklopljena= false;
			while (true) {
				Figura fig = figure.dohvatiTek();
				if (f.preklapaSe(fig)) {
					preklopljena = true;
					break;
				}
				if (figure.postojiSled()) {
					figure.predjiNaSled();
				} else {
					break;
				}
			}
			
			 if (f.getX() < f.getR() || f.getY() - f.getR() < 0 || f.getX() + f.getR() > this.getWidth() ||
			     f.getY() + f.getR() > this.getHeight() || preklopljena) return; 
			if (!preklopljena) {
				figure.dodajFiguru(f);
			}
		} catch (Greska e) {
			e.printStackTrace();
		}

		repaint();
	}

	public Scena() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(500, 300));
		try {
			usisivac = new Usisivac(getPreferredSize().width / 2, getPreferredSize().height / 2);
			figure.dodajFiguru(usisivac);
		} catch (Greska e) {
			e.printStackTrace();
		}
		dodajOsluskivace();
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // Ciscenje kanvasa pre crtanje novih figura
		figure.prvaJeTek();
		while (true) {
			Figura f = figure.dohvatiTek();
			f.crtaj(g);
			if (figure.postojiSled()) {
				try {
					figure.predjiNaSled();
				} catch (Greska e) {
					break;
				}
			} else {
				break;  // Nema vise figura za crtanje
			}
		}
	}

	private synchronized void pomeriUsisivac() {
		if (figure.brojFigura() <= 1) { //usisivac je jedina figura
			return;
		}

		figure.prvaJeTek();
		Figura najbliza = null;
		int minRastojanje = Integer.MAX_VALUE;

		while (true) {
			Figura f = figure.dohvatiTek();
			if (f != usisivac) {
				int trenRastojanje = usisivac.getRastojanje(f); //rastojanje izmedju neke figure i usisivaca
				if (trenRastojanje < minRastojanje) {
					minRastojanje = trenRastojanje;
					najbliza = f;
				}
			}
			if (figure.postojiSled()) {
				try {
					figure.predjiNaSled();
				} catch (Greska e) {
					break;
				}
			} else {
				break;
			}
		}

		if (najbliza!= null) {
			int dx =najbliza.getX() - usisivac.getX();
			int dy =najbliza.getY() - usisivac.getY();
			if (Math.abs(dx) > usisivac.pomeraj()) {
				usisivac.setX(usisivac.getX() + (dx > 0 ? usisivac.pomeraj() : -usisivac.pomeraj()));
			} else {
				if (usisivac.preklapaSe(najbliza)) {
					figure.izbaciFiguru(najbliza);
				} else {
					usisivac.setY(usisivac.getY() + (dy > 0 ? usisivac.pomeraj() : -usisivac.pomeraj()));
				}
			}
		}
	}

	@Override
	public void run() {
		try {
			while (!thread.isInterrupted()) {
				synchronized (this) {
					while (!radi) {
						wait();
					}
				}
				Thread.sleep(50);
				pomeriUsisivac();
				repaint();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	 public synchronized void pocni() {
		radi = true;
		notify();
	}

	public synchronized void pause() {
		radi = false;
	}

	public synchronized boolean daLiRadi() {
		return radi;
	}

	public synchronized void interrupt() {
		thread.interrupt();
	}

	public synchronized void startStopScena() {
		if (!radi) {
			pocni();
		} else {
			pause();
		}
	}
}
