package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {
    
    private Scena scena;
    private Igrac igrac;

    public Igra() {
        super("Loptica");
        setBounds(700, 200, 400, 400);
        scena = new Scena();
        setResizable(false);
        postaviCigle();
        dodajOsluskivace();
        scena.requestFocusInWindow();
        scena.pokreni();
        add(scena);
        pack();
        setVisible(true);
    }
    
    private void postaviCigle() {
        int redova = 3;
        int kolona = 5;
        int sirinaCigle = 60;
        int visinaCigle = 20;
        int razmak = 2;

        int startX = razmak;
        int startY = razmak;

        for (int i = 0; i < redova; i++) {
            for (int j = 0; j < kolona; j++) {
                int x = startX + j * (sirinaCigle + razmak) + sirinaCigle / 2;
                int y = startY + i * (visinaCigle + razmak) + visinaCigle / 2; 
                Cigla cigla = new Cigla(sirinaCigle, visinaCigle, scena, x, y, Color.RED, 5);
            }
        }


        igrac = new Igrac(scena, scena.getWidth() / 2, scena.getHeight() - 20, Color.BLUE, 60, 15);
    }

    private void dodajOsluskivace() {
        scena.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int pomak = 10;
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                	System.out.println("3");
                    igrac.pomeriFiguru(-pomak, 0);
                    scena.repaint();
                } if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                	System.out.println("4");
                    igrac.pomeriFiguru(pomak, 0);
                    scena.repaint();
                }
            }
        });

        scena.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if(e.getButton()==MouseEvent.BUTTON1) {
            		System.out.println("1");
            		igrac.ispaliLopticu();
            		scena.repaint();
            	}
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	scena.zaustavi();
                dispose();
             
            }
        });
    }

    public static void main(String[] args) {
        new Igra();
    }
}
