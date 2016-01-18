package de.htwg.se.texasholdem.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;

import javafx.collections.transformation.SortedList;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;

import com.sun.javafx.scene.control.behavior.ScrollBarBehavior;

import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.util.observer.IObserver;

public class SetupUI extends JFrame implements ActionListener {
	
PokerController controller;

	JPanel pnl = new JPanel();

	JButton btnStartGame = new JButton();
	JButton btnNewPlayer = new JButton();
	JTextField txtPlayerName = new JTextField();
	JTextField txtPlayerMoney = new JTextField();
	JTextField txtBlinds = new JTextField();
	JLabel lblMoney = new JLabel();
	JLabel lblName = new JLabel();
	JLabel lblBlinds = new JLabel();
			
	private int playerCount = 0;
	
	public SetupUI(PokerController inController){
		controller = inController;
		this.setTitle("Setup");
		this.setLayout(null);
		setSize(800, 600);

		this.add(btnNewPlayer);
		this.add(btnStartGame);
		this.add(lblName);
		this.add(lblMoney);
		this.add(lblBlinds);
		this.add(txtPlayerName);
		this.add(txtPlayerMoney);
		this.add(txtBlinds);
		
		btnNewPlayer.setText("Neuer Spieler");
		btnNewPlayer.setLocation(10, 10);
		btnNewPlayer.setSize(150, 30);
		btnStartGame.setText("Spiel Starten");
		btnStartGame.setLocation(330, 10);
		btnStartGame.setSize(150, 30);
		
		lblName.setText("Spielername:");
		lblName.setLocation(10, 50);
		lblName.setSize(150, 30);
		
		lblMoney.setText("Startgeld:");
		lblMoney.setLocation(10, 90);
		lblMoney.setSize(150, 30);
		
		lblMoney.setText("Blinds:");
		lblMoney.setLocation(10, 130);
		lblMoney.setSize(150, 30);
		
		txtPlayerName.setLocation(170, 50);
		txtPlayerName.setSize(300, 30);
		txtPlayerName.setText("DE");
		
		txtPlayerMoney.setLocation(170, 90);
		txtPlayerMoney.setSize(300,30);
		txtPlayerMoney.setText("500");
		
		txtBlinds.setLocation(170, 130);
		txtBlinds.setSize(300,30);
		txtBlinds.setText("5");
		
		btnNewPlayer.addActionListener(this);
		btnStartGame.addActionListener(this);
				
		this.setVisible(true);
		
		
	}

	public void update() {
		// TODO Auto-generated method stub
		//Sollte nicht passieren
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewPlayer)
			newPLayer();
		else if(e.getSource() == btnStartGame)
			startGame();
		
	}

	private void startGame() {
		// TODO Auto-generated method stub
		int money = 0;
		int blinds = 0;
		try{
			money = Integer.parseInt(txtPlayerMoney.getText());
			blinds = Integer.parseInt(txtBlinds.getText());
		}catch(Exception e){
			
		}
		if(money != 0 && blinds != 0){
			
			controller.setStartCredits(money);
			controller.setBlinds(blinds);
			this.setVisible(false);
			controller.startGame();
		}
		else{
			if(money == 0)
				JOptionPane.showMessageDialog(this, "Ungültige Eingabe Geld", "ungültige Einstellungen", JOptionPane.INFORMATION_MESSAGE);
			else if(blinds == 0)
				JOptionPane.showMessageDialog(this, "Ungültige Eingabe Blinds", "ungültige Einstellungen", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	private void createPlayerFromData(String inName, String inMoney){
		
		controller.addPlayer(inName);
	}

	private void newPLayer() {
		// TODO Auto-generated method stub
		createPlayerFromData(txtPlayerName.getText(), txtPlayerMoney.getText());
	}
}
