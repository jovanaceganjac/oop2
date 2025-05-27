package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public abstract class Kvadrat extends Canvas {
	
	protected Color bojaPozadine;
	protected boolean oznacen;
	
	public Kvadrat(Color bojaPozadine) {
		setSize(75, 75);
		this.bojaPozadine=bojaPozadine;
		setBackground(bojaPozadine);
	}
	
	public boolean jeOznacen() { return oznacen;}
	
	
	public void postaviOznaku(boolean oznaka) throws GOznaka {
		if(!this.mozeDaSeOznaci()) {
			throw new GOznaka("Nije moguce oznaciti kvadrat!");
		}
		this.oznacen=oznaka;
		repaint();
	}
	
	
	protected abstract boolean mozeDaSeOznaci();
	
	public void paint(Graphics g) {
		if(this.jeOznacen() && this.mozeDaSeOznaci()) {
			g.setColor(Color.RED);
			g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		}
		
		
	}

}
