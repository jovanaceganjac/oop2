package igra;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {

	private Teren teren;
	private Button postavi=new Button("Postavi");
	private Button nasumicno=new Button("Nasumicno");
	private CheckboxGroup dugmad=new CheckboxGroup();
	private Checkbox zid, prolaz, akter;
	
	public Igra() {
		this.setTitle("Igra");
		this.setBounds(700, 200, 500, 300);
		this.setLayout(new BorderLayout());
		this.dodajOsluskivace();
		this.teren=new Teren(6, 12);
		Panel opcijepom=new Panel(new BorderLayout());
		Panel opcije=new Panel(new GridLayout(1, 1));
		zid=new Checkbox("Zid", dugmad, false);
		prolaz=new Checkbox("Prolaz", dugmad, false);
		akter=new Checkbox("Akter", dugmad, false);
		opcije.add(zid);
		opcije.add(prolaz);
		opcije.add(akter);
		opcijepom.add(opcije, BorderLayout.NORTH);
		Panel panel=new Panel(new GridLayout(3, 1));
		
		panel.add(opcijepom);
		panel.add(postavi);
		panel.add(nasumicno);
		postavi.addActionListener((ae)->{
			String s=dugmad.getSelectedCheckbox().getLabel();
			switch(s) {
			case "Zid":
				if(teren.dohvOznaceno()!=null) {
					teren.zameniPolje(new Zid(teren, teren.dohvOznaceno().dohvPoziciju()));
				}
				break;
			case "Prolaz":
				if(teren.dohvOznaceno()!=null) {
					teren.zameniPolje(new Prolaz(teren, teren.dohvOznaceno().dohvPoziciju()));
				}
				break;
			case "Akter":
				try {
					if(teren.dohvOznaceno()!=null) {
						teren.dodajAktera(new GlavniAkter(teren, teren.dohvOznaceno().dohvPoziciju()));
					}
				} catch (Greska e) {}
				break;
			}
		});
		nasumicno.addActionListener((ae)->{
			teren.generisiSlucajno();
		});
		
		this.add(teren, BorderLayout.CENTER);
		this.add(panel, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
		
		
		
		
		
	}
	
	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		System.out.println("5");
		new Igra();
	}
}
