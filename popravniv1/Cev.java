package igra;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Cev extends Kvadrat{

	public Cev() {
		super(new Color(170, 170, 170));
		oznacen=false;
	}

	@Override
	protected boolean mozeDaSeOznaci() {
		return true;
	}
	
	public abstract void crtajUnutrasnjost(Graphics g);
	public abstract void crtajIvice(Graphics g);
	public abstract void crtajUsmerenje(Graphics g);
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); 
		g.setColor(new Color(204, 204, 204));
		crtajUnutrasnjost(g);
		g.setColor(Color.BLACK);
		crtajIvice(g);
		crtajUsmerenje(g);
		
		
	}
	

}
