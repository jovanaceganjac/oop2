package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Loptica extends AktivnaFigura {

	private int r;
	private double dx = 1, dy = 0;
	private int brojAzuriranja = 0;

	public Loptica(Scena scena, int x, int y, Color boja, int r, int period) {
		super(scena, x, y, Color.GREEN, period);
		this.r = r;
		dodeliBrzinu();
		pokreni();
	}

	@Override
	public void run() {
		try {
			while (!thread.isInterrupted()) {
				azurirajPoziciju(20);
			}
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void azurirajPoziciju(int perioda) throws InterruptedException {
		pomeriFiguru(dx, dy);
		scena.repaint();
		Thread.sleep(50);
	}

	private void proveriSudare() {
		if (x - r / 2 <= 0 || x + r / 2 >= scena.getWidth()) {
			dx *= -1;
		}
		if (y - r / 2 <= 0) {
			dy *= -1;
		}
		if (y + r / 2 >= scena.getHeight()) {
			this.unistiFiguru();
			return;
		}
		
		synchronized(this) {
			for (Figura f : scena.dohvatiFigure()) {
				if (f instanceof Cigla && !((Cigla) f).getPogodjenost()) {
					if (Math.abs(f.x - x) < r + ((Cigla) f).getSirina() / 2
							&& Math.abs(f.y - y) < r + ((Cigla) f).getVisina() / 2) {
						dy *= -1;
						((Cigla) f).setPogodjenost(true);
					}
				} else if (f instanceof Igrac) {
					Igrac igrac = (Igrac) f;
	
					if (this.y + r >= igrac.y && this.y + r <= igrac.y + igrac.getVisina() / 2 && this.x + r / 2 >= igrac.x
							&& this.x - r / 2 <= igrac.x + igrac.getSirina()) {
						dy *= -1;
					}
	
					if (this.x + r >= igrac.x && this.x <= igrac.x + igrac.getSirina() / 2
							&& this.y - r / 2 <= igrac.y + igrac.getVisina() && this.y + r / 2 >= igrac.y) {
						dx *= -1;
					}
	
					if (this.x - r <= igrac.x + igrac.getSirina() && this.x - r >= igrac.x + igrac.getSirina() / 2
							&& this.y - r / 2 <= igrac.y + igrac.getVisina() && this.y + r / 2 >= igrac.y) {
						dx *= -1;
					}
				}
			}
		}

		brojAzuriranja++;
		if (brojAzuriranja % 100 == 0) {
			dx *= 1.1;
			dy *= 1.1;
		}
	}

	@Override
	public char oznakaVrste() {
		return 'L';
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(boja);
		g.fillOval((int) (x - r / 2), (int) (y - r / 2), r, r);
	}

	@Override
	public void pomeriFiguru(double pomakx, double pomaky) {
		x += pomakx;
		y += pomaky;
		proveriSudare();
	}

	private void dodeliBrzinu() {
		dx = -1 + Math.random() * 2;
		dy = -1 + Math.random();
	}
}
