package igra;

public class Pozicija {

	public enum Smer {
		GORE, DOLE, LEVO, DESNO
	}

	private int vrsta;
	private int kolona;

	public Pozicija(int vrsta, int kolona) {
		this.vrsta = vrsta;
		this.kolona = kolona;
	}

	public int dohvVrstu() {
		return vrsta;
	}

	public int dohvKolonu() {
		return kolona;
	}

	public Pozicija dohvPozicijuPored(Smer s) {
		int novavrsta=this.vrsta;
		int novakolona=this.kolona;
		switch (s) {
		case GORE:
			novavrsta += 1;
			break;
		case DOLE:
			novavrsta -= 1;
			break;
		case DESNO:
			novakolona += 1;
			break;
		case LEVO:
			novakolona -= 1;
			break;
		}
		return new Pozicija(novavrsta, novakolona);
	}
	
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Pozicija)) return false;
		else {
			Pozicija nova=(Pozicija)obj;
			return nova.vrsta==this.vrsta && nova.kolona==this.kolona;
		}
	}
}
