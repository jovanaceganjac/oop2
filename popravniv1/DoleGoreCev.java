package igra;

import java.awt.Graphics;

public class DoleGoreCev extends Cev {

    @Override
    public void crtajUnutrasnjost(Graphics g) {
        g.fillRect((int)(this.getWidth()/4), 0, (int)(this.getWidth()/2), this.getHeight());
    }

    @Override
    public void crtajIvice(Graphics g) {
        g.drawLine((int)(this.getWidth()/4), 0, (int)(this.getWidth()/4), this.getHeight());
        g.drawLine((int)(3*this.getWidth()/4), 0, (int)(3*this.getWidth()/4), this.getHeight());
    }

    @Override
    public void crtajUsmerenje(Graphics g) {
        g.drawLine(this.getWidth()/2, (int)(3*this.getHeight()/4), this.getWidth()/2, (int)(this.getHeight()/4));
        int xKrajLinije = this.getWidth()/2;
        int yKrajLinije = this.getHeight()/4;

        int x[] = {xKrajLinije-4, xKrajLinije, xKrajLinije+4};
        int y[] = {yKrajLinije, yKrajLinije-10, yKrajLinije};
        g.fillPolygon(x, y, 3);
    }
}


