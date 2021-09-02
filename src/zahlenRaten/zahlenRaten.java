package zahlenRaten;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.JOptionPane;

public class zahlenRaten {

	int zahl1;
	int zufall;
	int zaehler = 1;
	int guess;

	private JFrame fenster;

	public static void main(String[] args) {
	
		zahlenRaten windows = new zahlenRaten();
		windows.fenster.setVisible(true);			//startet ein neues Fenster
		
	}

	public zahlenRaten() { 
		darstellung();
	}

	private void darstellung() {

		fenster = new JFrame("Neues Fenster");		
		fenster.setBounds(500, 500, 500, 400);
		fenster.setTitle("Zahlen Raten");
		fenster.getContentPane().setBackground(SystemColor.control);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//was beim Kreuz geschehen soll: Das Fenster soll sich schließen
		fenster.getContentPane().setLayout(null);
		JTextField eingabe = new JTextField();
		eingabe.setToolTipText("Zahl eingeben");
		eingabe.setBounds(50,10,100,50);
		fenster.getContentPane().add(eingabe);
		JTextField ausgabe = new JTextField();
		ausgabe.setBounds(200, 10, 200, 50);
		ausgabe.setToolTipText("Ergebnis");
		ausgabe.setEnabled(false);
		ausgabe.setDisabledTextColor(Color.black);
		fenster.getContentPane().add(ausgabe);
		JTextField counter = new JTextField();
		counter.setBounds(50, 100, 200, 50);
		counter.setToolTipText("Zeigt an, wie viele Versuche zum erraten gebraucht wurden!");
		counter.setEnabled(false);
		counter.setDisabledTextColor(Color.black);
		fenster.getContentPane().add(counter);
		JButton rechnen = new JButton();
		fenster.getRootPane().setDefaultButton(rechnen); //Der Button wird per "Enter" Taste ausgelöst
		rechnen.setText("Raten");
		rechnen.setToolTipText("Wird dir Zeigen, ob du richtig lagst!");
		rechnen.setBounds(300, 100, 100, 50);
		fenster.getContentPane().add(rechnen);
		JComboBox level = new JComboBox();
		level.setBounds(150, 200, 200, 50);
		level.setModel(new DefaultComboBoxModel(new String[]{"(Level auswählen)", "1", "2", "3"}));
		fenster.getContentPane().add(level);
		
		
		 level.addActionListener(new ActionListener() {
			 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Object Level = level.getSelectedItem();
	                
	                if (Level.equals("1")) {
	                	Random rand = new Random();
	                	zufall = rand.nextInt(100)+1;
	                }
	                else if (Level.equals("2")) {
	                	Random rand = new Random();
	                	zufall = rand.nextInt(250)+1;
	                }
	                else if (Level.equals("3")) {
	                	Random rand = new Random();
	                	zufall = rand.nextInt(500)+1;
	                }
	                else  {
	                	Random rand = new Random();
	                	zufall = rand.nextInt(100)+1;
	            }}
	        });

		rechnen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
								
				int guess = Integer.parseInt(eingabe.getText());
								
				try {
					
				if (zufall < guess) { Thread.sleep(500); ausgabe.setText("Falsch! Die Zahl ist kleiner!"); zaehler = (zaehler +1); }
				
				else if (zufall > guess) { Thread.sleep(500); ausgabe.setText("Falsch! Die Zahl ist größer!"); zaehler = (zaehler +1);}

				else if (zufall == guess) {Thread.sleep(500); ausgabe.setText("Richtig geraten!"); counter.setText("Es wurden "+zaehler+" Versuche gebraucht"); zaehler = 1;  }
			
				
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} }  

		});

	}

}