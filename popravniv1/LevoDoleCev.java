package igra;

import java.awt.Graphics;

public class LevoDoleCev extends Cev {

	@Override
	public void crtajUnutrasnjost(Graphics g) {
		g.fillRect(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight());
		g.fillRect(this.getWidth()/4, this.getHeight()/4, this.getWidth(), this.getHeight()/2);
		
	}

	@Override
	public void crtajIvice(Graphics g) {
		g.drawLine(3*this.getWidth()/4, 3*this.getHeight()/4, this.getWidth(), 3*this.getHeight()/4);
		g.drawLine(3*this.getWidth()/4, 3*this.getHeight()/4, 3*this.getWidth()/4, this.getHeight());
		g.drawLine(this.getWidth()/4, this.getHeight()/4, this.getWidth(), this.getHeight()/4);
		g.drawLine(this.getWidth()/4, this.getHeight()/4, this.getWidth()/4, this.getHeight());
	}

	@Override
	public void crtajUsmerenje(Graphics g) {
		g.drawLine(this.getWidth()/2, this.getHeight()/2,3*this.getWidth()/4, this.getHeight()/2);
		g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, 3*this.getHeight()/4);
		int xKrajLinije=(int)(this.getHeight()/2);
		int yKrajLinije=(int)(3*this.getWidth()/4);
		
		int x[]= {xKrajLinije-4, xKrajLinije, xKrajLinije+4};
		int y[]= {yKrajLinije, yKrajLinije+10, yKrajLinije};
		g.fillPolygon(x, y, 3);
	}


}
