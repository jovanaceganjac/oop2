package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {

	private int sirina;
	private int visina;

	public Igrac(Scena scena, int x, int y, Color boja, int sirina, int visina) {
		super(scena, x, y, Color.BLUE);
		this.sirina = sirina;
		this.visina = visina;
	}

	public int getSirina() {
		return sirina;
	}

	public int getVisina() {
		return visina;
	}

	@Override
	public char oznakaVrste() {
		return 'I';
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(boja);
		g.fillRect((int) x-sirina/2, (int) y-visina/2, sirina, visina);

	}

	
	@Override
	public void pomeriFiguru(double pomakx, double pomaky) {
		if(x+pomakx-sirina/2 <= 0 || x+pomakx+sirina/2 > scena.getWidth()) return;
		x += pomakx;
		y += pomaky;
	}

	public void ispaliLopticu() {
		Loptica loptica = new Loptica(scena, (int)x, (int) y - visina, Color.GREEN, visina, 10);
	}
}
