package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {

	private double sirina;
	private double visina;
	private boolean pogodjenost = false;

	public Cigla(double sirina, double visina, Scena scena, double x, double y, Color boja, int period) {
		super(scena, x, y, Color.RED, period);
		this.sirina = sirina;
		this.visina = visina;
	}

	public double getSirina() {
		return sirina;
	}

	public double getVisina() {
		return visina;
	}

	public boolean getPogodjenost() {
		return pogodjenost;
	}

	public void setVisina(double visina) {
		this.visina = visina;
	}

	public void setSirina(double sirina) {
		this.sirina = sirina;
	}

	public void setPogodjenost(boolean pogodjenost) {
		this.pogodjenost = pogodjenost;
	}

	public void azurirajPoziciju(int perioda) throws InterruptedException {
		boja = Color.GRAY;
		pomeriFiguru(0, 5);
		Thread.sleep(perioda);
		scena.repaint();
	}

	@Override
	public void run() {
		try {
			while (!thread.isInterrupted()) {
				if (pogodjenost)
					azurirajPoziciju(20);
			}
		} catch (InterruptedException e) {
		}
	}

	@Override
	public char oznakaVrste() {
		return 'C';
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(boja);
		g.fillRect((int) (x - sirina / 2), (int) (y - visina / 2), (int) (sirina), (int) (visina));

	}

	@Override
	public void pomeriFiguru(double pomakx, double pomaky) {
		x += pomakx;
		if (y + pomaky >= scena.getHeight()) {
			unistiFiguru();
		} else {
			y += pomaky;
		}

	}

}
