package igra;

import java.awt.Color;
import java.awt.Graphics;

public class GlavniAkter extends Akter{

	public GlavniAkter(Teren teren, Pozicija pozicija) {
		super(teren, pozicija);
	}

	@Override
	public void crtajAktera(Graphics g, Polje polje) {
		g.setColor(Color.YELLOW);
		int poluprecnik=polje.getWidth()/2;
		g.fillOval(0, 0, 2*poluprecnik, 2*poluprecnik);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, 2*poluprecnik, 2*poluprecnik);
	}

	
}
