package igra;

import java.awt.Graphics;

public abstract class Akter {
	
	protected Teren teren;
	protected Pozicija pozicija;
    protected Polje polje;
	
	public Akter(Teren t, Pozicija p) {
		this.teren=t;
		this.pozicija=p;
		this.polje=t.dohvPolje(p);
	}
	
	public Pozicija dohvPozicijuAktera() {return pozicija;}
	
	public abstract void crtajAktera(Graphics g, Polje polje);
}
