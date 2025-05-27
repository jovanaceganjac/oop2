package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

public class Scena extends Canvas {

	private ArrayList<Figura> figure;

	public Scena() {
		setSize(310, 310);
		setFocusable(true);
		figure = new ArrayList<>();
	}

	public synchronized void dodajFiguru(Figura f) {
		if (!figure.contains(f)) {
			figure.add(f);
			repaint();
		}
	}

	public synchronized void ukloniFiguru(Figura f) {
		if (figure.contains(f)) {
			figure.remove(f);
			repaint();
		}
	}

	public synchronized Figura dohvatiFiguru(int rb) {
		return figure.get(rb);
	}

	public synchronized ArrayList<Figura> dohvatiFigure() {
		return figure;
	}

	public void pokreni() {
		for (Figura f : figure) {
			if (f instanceof AktivnaFigura) {
				((AktivnaFigura) f).pokreni();
			}
		}
	}

	public void zaustavi() {
		for (Figura f : figure) {
			if (f instanceof AktivnaFigura) {
				((AktivnaFigura) f).zaustavi();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		ArrayList<Figura> novefigure;
		synchronized (this) {
			novefigure = (ArrayList<Figura>) figure.clone();
		}
		for (Figura f : novefigure)
			f.paint(g);
	}

}
