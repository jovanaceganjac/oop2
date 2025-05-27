package igra;

import java.awt.Graphics;

public class LevoGoreCev extends Cev {

	@Override
	public void crtajUnutrasnjost(Graphics g) {
		g.fillRect(this.getWidth()/4, this.getHeight()/4, this.getWidth(), this.getHeight()/2);
		g.fillRect(this.getWidth()/4, 0, this.getWidth()/2, 3*this.getHeight()/4);
		
	}

	@Override
	public void crtajIvice(Graphics g) {
		g.drawLine(3*this.getWidth()/4, this.getHeight()/4, this.getWidth(), this.getHeight()/4);
		g.drawLine(this.getWidth()/4, 0, this.getWidth()/4, 3*this.getHeight()/4);
		g.drawLine(this.getWidth()/4, 3*this.getHeight()/4, this.getWidth(), 3*this.getHeight()/4);
		g.drawLine(3*this.getWidth()/4, 0, 3*this.getWidth()/4, this.getHeight()/4);
		
	}

	@Override
	public void crtajUsmerenje(Graphics g) {
		g.drawLine(this.getWidth()/2, this.getHeight()/2, 3*this.getWidth()/4, this.getHeight()/2);
		g.drawLine(this.getWidth()/2, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2);
		int xKrajLinije=this.getWidth()/2;
		int yKrajLinije=this.getHeight()/4;
		
		int x[]= {xKrajLinije-4, xKrajLinije, xKrajLinije+4};
		int y[]= {yKrajLinije, yKrajLinije-10, yKrajLinije};
		g.fillPolygon(x, y, 3);
	}

}
