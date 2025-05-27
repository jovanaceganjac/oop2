package gui;

import java.awt.Graphics;

public abstract class Figura {

	private int x, y;

	public Figura(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract int getR();

	public abstract void crtaj(Graphics g);

	public int getRastojanje(Figura f) {
		return (int) Math.sqrt(Math.pow(x - f.x, 2) + Math.pow(y - f.y, 2));
	}

	public boolean preklapaSe(Figura f) {
		return getRastojanje(f) <= getR() + f.getR();
	}
}
