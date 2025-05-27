package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Usisivac extends Figura {

	public Usisivac(int x, int y) {
		super(x, y);
	}

	@Override
	public int getR() {
		return 15;
	}

	@Override
	public void crtaj(Graphics g) {
		g.setColor(Color.RED);
		int a = (int) (Math.sqrt(3) * getR()); // Duzina stranice jednakostranicnog trougla
        int[] xTacke = {getX(), getX() - a / 2, getX() + a / 2 };
        int[] yTacke = { getY()- getR(), getY() + getR() / 2, getY() +getR()/ 2 };
        Polygon trougao = new Polygon(xTacke, yTacke, 3);
        g.fillPolygon(trougao); // Crta popunjeni crveni trougao sa centrom u (x, y)
	}
	
	public int pomeraj() {
		return getR() / 2;
	}
}
