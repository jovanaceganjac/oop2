package igra;

import java.awt.Color;

public class Zid extends Kvadrat {

	public Zid() {
		super(new Color(170, 170, 170));
		oznacen=false;
	}

	@Override
	protected boolean mozeDaSeOznaci() {
		return true;
	}

}
