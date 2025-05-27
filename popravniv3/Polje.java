package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Polje extends Canvas {
	
	protected Teren teren;
	protected Color boja;
	protected Pozicija pozicija;
	protected Akter akter;

	private boolean oznacen;
	
	public Polje(Teren teren, Color boja, Pozicija pozicija) {
		setSize(50, 50);
		this.teren=teren;
		this.boja=boja;
		this.pozicija=pozicija;
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				teren.oznaci(Polje.this);
			}
		});
	}
	
	public Pozicija dohvPoziciju() {return pozicija;}
	
	public boolean jeOznacen() {return oznacen;}
	
	public abstract boolean mozeDaStane();
	
	public void postaviOznaku(boolean novaoznaka) {
		this.oznacen=novaoznaka;
		repaint();
	}
	
	public boolean imaAktera() {
		if(akter!=null) return true;
		return false;
	}
	
	public void postaviAktera(Akter a) {
		this.akter=a;
		repaint();
	}
	
	public void paint(Graphics g) {
        g.setColor(boja);
        g.fillRect(1, 1, getWidth() - 1, getHeight() - 1);
        if (this.jeOznacen()) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawRect(1, 1, getWidth() - 2, getHeight() - 2);
        
        /*ArrayList<Akter> akteriNaTerenu=teren.dohvAktere();
        for(Akter a:akteriNaTerenu) {
        	if(a.dohvPozicijuAktera().equals(this.dohvPoziciju()) && !(this instanceof Zid)) {
        		a.crtajAktera(g, this);
        	}
        }*/
        if(akter!=null) {
        	akter.crtajAktera(g, this);
        }
    }


	
	
	
	
	

}
