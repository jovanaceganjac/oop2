package igra;

import java.awt.Color;

public class Prolaz extends Polje{

	
	public Prolaz(Teren teren, Pozicija pozicija) {
		super(teren, Color.LIGHT_GRAY, pozicija);
	}

	@Override
	public boolean mozeDaStane() {
		return true;
	}
	
}
