package gui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	protected Scena scena;
	protected double x;
	protected double y;
	protected Color boja;
	
	public Figura(Scena scena, double x, double y, Color boja) {
		this.scena=scena;
		this.x=x;
		this.y=y;
		this.boja=boja;
		scena.dodajFiguru(this);
	}
	
	public abstract char oznakaVrste();
	
	public void unistiFiguru() {
		scena.ukloniFiguru(this);
	}
	
	public abstract void paint(Graphics g);
	
	public abstract void pomeriFiguru(double pomakx, double pomaky);

}
