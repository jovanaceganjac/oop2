package gui;

import java.util.ArrayList;

public class Skup {
	private ArrayList<Figura> figure;
	private int tekuca;
	
	public Skup() {
		figure=new ArrayList<>();
		tekuca=-1;
	}
	
	public void dodajFiguru(Figura f) throws Greska {
		if(figure.contains(f)) throw new Greska("Figura se vec nalazi u skupu.");
		figure.add(f);
	}
	
	public void prvaJeTek() {
		tekuca=0;
	}
	
	public void predjiNaSled() throws Greska {
		if(!postojiSled()) throw new Greska("Nema sledece figure.");
		tekuca++;
	}
	
	public Figura dohvatiTek() {
		return figure.get(tekuca);
	}
	
	public boolean postojiSled() {
		return tekuca>=0 && tekuca<figure.size()-1;
	}
	
	public void isprazniSkup() {
		for(Figura f:figure) {
			figure.remove(f);
		}
	}
	
	public boolean nalaziSe(Figura f) {
		return figure.contains(f);
	}
	
	public void izbaciFiguru(Figura f) {
		if(nalaziSe(f)) figure.remove(f);
	}
	
	public int brojFigura() {
		return figure.size();
	}
	
	
	
	

}
