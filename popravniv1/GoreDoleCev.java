package igra;

import java.awt.Graphics;

class GoreDoleCev extends Cev {

	    @Override
	    public void crtajUnutrasnjost(Graphics g) {
	        g.fillRect(this.getWidth()/4, 0, this.getWidth()/2, this.getHeight());
	    }

	    @Override
	    public void crtajIvice(Graphics g) {
	        g.drawLine(this.getWidth()/4, 0, this.getWidth()/4, this.getHeight());
	        g.drawLine(3*this.getWidth()/4, 0, 3*this.getWidth()/4, this.getHeight());
	    }

	    @Override
	    public void crtajUsmerenje(Graphics g) {
	        g.drawLine(this.getWidth()/2, this.getHeight()/4, this.getWidth()/2, 3*this.getHeight()/4);
	        int xKrajLinije = this.getWidth()/2;
	        int yKrajLinije =3*this.getHeight()/4;

	        int x[] = {xKrajLinije-4, xKrajLinije, xKrajLinije+4};
	        int y[] = {yKrajLinije, yKrajLinije+10, yKrajLinije};
	        g.fillPolygon(x, y, 3);
	    }

}
