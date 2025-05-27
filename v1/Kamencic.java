package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Kamencic extends Figura {

	public Kamencic(int x, int y) {
		super(x, y);
	}

	@Override
	public int getR() {
		return 5;
	}

	@Override
	public void crtaj(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(getX() - getR(), getY() - getR(), 2 * getR(), 2 * getR());
	}
}
