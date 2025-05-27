package igra;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Aplikacija extends Frame {

	private Button dodaj = new Button("Dodaj");
	private CheckboxGroup dugmad = new CheckboxGroup();
	private Checkbox levoDesno, goreDole, doleGore, levoDole, levoGore, goreDesno, doleDesno;
	private Kanalizacija kanalizacija=new Kanalizacija(5, 5);
	
	

	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public Aplikacija() {
		this.setTitle("Cevi");
		
		this.setBounds(700, 200, 500, 300);
		this.setLayout(new BorderLayout());
		this.dodajOsluskivace();
		Panel opcije=new Panel(new GridLayout(8, 1));
	
		levoDesno = new Checkbox("Levo-Desno", dugmad, false);
		goreDole = new Checkbox("Gore-Dole", dugmad, false);
		doleGore = new Checkbox("Dole-Gore", dugmad, false);
		levoDole = new Checkbox("Levo-Dole", dugmad, false);
		levoGore = new Checkbox("Levo-Gore", dugmad, false);
		goreDesno = new Checkbox("Gore-Desno", dugmad, false);
		doleDesno = new Checkbox("Dole-Desno", dugmad, false);

		opcije.add(levoDesno);
		opcije.add(goreDole);
		opcije.add(doleGore);
		opcije.add(levoDole);
		opcije.add(levoGore);
		opcije.add(goreDesno);
		opcije.add(doleDesno);
		dodaj.addActionListener((ae)->{
			String s=dugmad.getSelectedCheckbox().getLabel();
			Cev nova=null;
			switch (s) {
			case "Levo-Desno":
				nova=new LevoDesnoCev();
				break;

			case "Gore-Dole":
				nova=new GoreDoleCev();
				break;
				
			case "Dole-Gore":
				nova=new DoleGoreCev();
				break;
				
			case "Levo-Dole":
				nova=new LevoDoleCev();
				break;
				
			case "Levo-Gore":
				nova=new LevoGoreCev();
				break;
			case "Gore-Desno":
				nova=new GoreDesnoCev();
				break;
			case "Dole-Desno":
				nova=new DoleDesnoCev();
				break;
			}
			if(nova!=null) {
				kanalizacija.dodajCev(nova);
			}
		});
		opcije.add(dodaj);
		this.add(opcije, BorderLayout.EAST);
		this.add(kanalizacija, BorderLayout.CENTER);
		

		this.pack();
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Aplikacija();
	}

}
