package igra;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Kanalizacija extends Panel {

	private Kvadrat[][] mreza;
	private int brRedova;
	private int brKolona;
	private Kvadrat oznacen = null;

	public Kanalizacija(int brRedova, int brKolona) {
		setLayout(new GridLayout(brRedova, brKolona, 1, 1));
		this.brRedova = brRedova;
		this.brKolona = brKolona;
		mreza = new Kvadrat[brRedova][brKolona];
		for (int i = 0; i < brRedova; i++) {
			for (int j = 0; j < brKolona; j++) {
				Zid z = new Zid();
				this.add(z);
				this.mreza[i][j] = z;
				z.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							z.postaviOznaku(true);
							Kanalizacija.this.oznaci(z);
							// jer je unutar klase pa nema pristup
						} catch (GOznaka e1) {
						}
					}
				});
			}
		}
	}

	public void oznaci(Kvadrat k) throws GOznaka {
		if (!k.mozeDaSeOznaci())
			throw new GOznaka("Nije moguce oznaciti!");
		if (oznacen != null)
			oznacen.postaviOznaku(false);
		if (oznacen != k) {
			oznacen = k;
			oznacen.postaviOznaku(true);
		} else
			oznacen = null;
	}

	public void dodajCev(Cev c) {
		if (oznacen == null)
			return;
		for (int i = 0; i < brRedova; i++) {
			for (int j = 0; j < brKolona; j++) {
				if (mreza[i][j] == oznacen) {
					remove(mreza[i][j]);
					mreza[i][j] = c;
					this.add(c, i * brKolona + j);
					c.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (e.getComponent() instanceof Kvadrat) {
								try {
									c.postaviOznaku(true);
									Kanalizacija.this.oznaci(c);
									// jer je unutar klase pa nema pristup
								} catch (GOznaka e1) {
								}
							}
						}
					});
					oznacen = null;
					revalidate();
					repaint();
				}
			}
		}
	}
}
