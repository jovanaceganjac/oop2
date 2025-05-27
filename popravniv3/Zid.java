package igra;

import java.awt.Color;

public class Zid extends Polje{

	public Zid(Teren teren, Pozicija pozicija) {
		super(teren, Color.DARK_GRAY, pozicija);
	}

	@Override
	public boolean mozeDaStane() {
		return false;
	}
	
	

}
