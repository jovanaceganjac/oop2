package igra;

import java.awt.Graphics;

public class LevoDesnoCev extends Cev{
	
	@Override
	public void crtajUnutrasnjost(Graphics g) {
		g.fillRect(0,  (int)(this.getHeight()/4), this.getWidth(), (int)(this.getHeight()/2));
		
	}

	@Override
	public void crtajIvice(Graphics g) {
		g.drawLine(0, (int)(this.getHeight()/4), this.getWidth(), (int)(this.getHeight()/4));
		g.drawLine(0, (int)(3*this.getHeight()/4), this.getWidth(), (int)(3*this.getHeight()/4));
		
	}

	@Override
	public void crtajUsmerenje(Graphics g) {
		g.drawLine((int)(this.getWidth()/4), this.getHeight()/2, (int)(3*this.getWidth()/4), this.getHeight()/2);
		int xKrajLinije=(int)(3*this.getWidth()/4);
		int yKrajLinije=(int)(this.getHeight()/2);
		
		int x[]= {xKrajLinije, xKrajLinije+10, xKrajLinije};
		int y[]= {yKrajLinije+4, yKrajLinije, yKrajLinije-4};
		g.fillPolygon(x, y, 3);
	}

}
