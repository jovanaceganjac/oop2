package gui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AktivnaFigura extends Figura implements Runnable {

	protected Thread thread;
	protected int period;

	public AktivnaFigura(Scena scena, double x, double y, Color boja, int period) {
		super(scena, x, y, boja);
		this.period = period;
	}

	public void pokreni() {
		if (thread == null || !thread.isAlive()) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void zaustavi() {
		if (thread != null) {
			thread.interrupt();
		}
	}

	@Override
	public void unistiFiguru() {
		zaustavi();
		super.unistiFiguru();
	}

	public abstract void azurirajPoziciju(int perioda) throws InterruptedException;

}
