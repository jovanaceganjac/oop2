package igra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Teren extends Panel{
	
	private int brVrsta;
	private int brKolona;
	private Polje[][] matrica;
	private Polje oznaceno=null;
	private ArrayList<Akter> akteri=new ArrayList<>();
	
	
	public Teren(int brVrsta, int brKolona) {
		setLayout(new GridLayout(brVrsta, brKolona, 1, 1));
		this.brVrsta=brVrsta;
		this.brKolona=brKolona;
		matrica=new Polje[brVrsta][brKolona];
		for(int i=0; i<brVrsta; i++) {
			for(int j=0; j<brKolona; j++) {
				Prolaz p=new Prolaz(this, new Pozicija(i, j));
				this.add(p);
				matrica[i][j]=p;
			}
		}
	}
	
	public Polje dohvOznaceno() {
		if(oznaceno!=null) {
			return oznaceno;
		}
		else {
			return null;
		}
	}
	
	
	public ArrayList<Akter> dohvAktere(){
		return akteri;
	}
	
	public void oznaci(Polje polje) {
		if(oznaceno!=null) {
			oznaceno.postaviOznaku(false);
		}
		if(oznaceno!=polje) {
			oznaceno=polje;
			polje.postaviOznaku(true);
		}
		else {
			oznaceno=null;
		}
	}
	
	public void zameniPolje(Polje novopolje) {
		if(oznaceno==null) return;
		for(int i=0; i<brVrsta; i++) {
			for(int j=0; j<brKolona; j++) {
				if(matrica[i][j]==oznaceno) {
					remove(matrica[i][j]);
					matrica[i][j]=novopolje;
					add(novopolje, i*brKolona+j);
				}
			}
		}
		revalidate();
		repaint();
	}
	
	public Polje dohvPolje(Pozicija novapozicija) {
		for(int i=0; i<brVrsta; i++) {
			for(int j=0; j<brKolona; j++) {
				if(matrica[i][j].pozicija.equals(novapozicija)) {
					return matrica[i][j];
				}
			}
		}
		return null;
	}
	
	public void generisiSlucajno() {
		for(int i=0; i<brVrsta; i++) {
			for(int j=0; j<brKolona; j++) {
				if(matrica[i][j].imaAktera()) {
					continue;
				}
				double rand=Math.random();
				if(rand>0.3) {
					remove(matrica[i][j]);
					Prolaz prolaz=new Prolaz(this, new Pozicija(i, j));
					matrica[i][j]=prolaz;
					add(prolaz, i*brKolona+j);
					continue;
				}
		
				remove(matrica[i][j]);
				Zid zid=new Zid(this, new Pozicija(i, j));
				matrica[i][j]=zid;
				add(zid, i*brKolona+j);
			}
		}
		revalidate();
		repaint();
	}
	
	
	public void dodajAktera(Akter a) throws Greska {
		if(oznaceno==null) return;
		if(oznaceno instanceof Zid) throw new Greska("Oznaceno polje je zid!");
		akteri.add(a);
		oznaceno.postaviAktera(a);
		oznaceno.postaviOznaku(false);
		oznaceno=null;
	}
	
	@Override
	public void paint(Graphics g) {
		for(int i=0; i<brVrsta; i++) {
			for(int j=0; j<brKolona; j++) {
				matrica[i][j].paint(g);
			}
		}
	}
	
	
	
	
	
}
