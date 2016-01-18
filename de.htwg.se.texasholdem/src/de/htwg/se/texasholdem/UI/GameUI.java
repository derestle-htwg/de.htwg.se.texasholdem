package de.htwg.se.texasholdem.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import com.sun.javafx.scene.control.skin.resources.ControlResources;

import de.htwg.se.texasholdem.model.*;
import de.htwg.se.texasholdem.controller.GameStatus;
import de.htwg.se.texasholdem.controller.PokerController;
import de.htwg.se.texasholdem.util.observer.IObserver;

public class GameUI extends JFrame implements ActionListener, IObserver {
	
	private PokerController controller;
	
	private JButton btnFold = new JButton();
	private JButton btnRaise = new JButton();
	private JButton btnCall = new JButton();
	
	private JPanel[] PlayerCards = new JPanel[2];
	private JPanel[] CommunityCards = new JPanel[5];
	private JLabel Name = new JLabel();
	private JLabel Money = new JLabel();
	private JLabel Pot = new JLabel();
	
	private Player currentPlayer;
	//Aufbau:
	/**********************	0
	 *   XX XX XX XX XX   * 1
	 *   XX XX XX XX XX   * 2
	 *         Pot        * 3
	 *               Raise* 4
	 *  Name  XX XX  Call * 5
	 *  Geld  XX XX  Fold * 6
	 * ******************** 7
	 0123456789012345678901
	 */
	
	public GameUI(PokerController inController){
		
		this.setSize(800, 600);//4:3
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller = inController;
		
		this.setLayout(null);
		
		
		PlayerCards[0] = new JPanel();
		PlayerCards[1] = new JPanel();
		CommunityCards[0] = new JPanel();
		CommunityCards[1] = new JPanel();
		CommunityCards[2] = new JPanel();
		CommunityCards[3] = new JPanel();
		CommunityCards[4] = new JPanel();
		
		this.add(PlayerCards[0]);
		this.add(PlayerCards[1]);
		this.add(CommunityCards[0]);
		this.add(CommunityCards[1]);
		this.add(CommunityCards[2]);
		this.add(CommunityCards[3]);
		this.add(CommunityCards[4]);
		this.add(Name);
		this.add(Money);
		this.add(Pot);
		this.add(btnRaise);
		this.add(btnFold);
		this.add(btnCall);
		
		InitializeComponents();
		
		controller.addObserver(this);
		//Set Card Positions
	}
	
	private void InitializeComponents(){
		int xGrid = this.getWidth()/22;
		int yGrid = this.getHeight()/8;
				
		PlayerCards[0].setLocation(xGrid*9, yGrid*5);
		PlayerCards[1].setLocation(xGrid*12, yGrid*5);
		
		CommunityCards[0].setLocation(xGrid*4, yGrid*1);
		CommunityCards[1].setLocation(xGrid*7, yGrid*1);
		CommunityCards[2].setLocation(xGrid*10, yGrid*1);
		CommunityCards[3].setLocation(xGrid*13, yGrid*1);
		CommunityCards[4].setLocation(xGrid*16, yGrid*1);
		
		PlayerCards[0].setBackground(Color.lightGray);
		PlayerCards[1].setBackground(Color.lightGray);
		CommunityCards[0].setBackground(Color.lightGray);
		CommunityCards[1].setBackground(Color.lightGray);
		CommunityCards[2].setBackground(Color.lightGray);
		CommunityCards[3].setBackground(Color.lightGray);
		CommunityCards[4].setBackground(Color.lightGray);
		
		PlayerCards[0].setSize(xGrid*2, (int)(yGrid*1.5));
		PlayerCards[1].setSize(xGrid*2, (int)(yGrid*1.5));
		
		CommunityCards[0].setSize(xGrid*2, (int)(yGrid*1.5));
		CommunityCards[1].setSize(xGrid*2, (int)(yGrid*1.5));
		CommunityCards[2].setSize(xGrid*2, (int)(yGrid*1.5));
		CommunityCards[3].setSize(xGrid*2, (int)(yGrid*1.5));
		CommunityCards[4].setSize(xGrid*2, (int)(yGrid*1.5));
		
		Name.setLocation(xGrid*3, yGrid*5);
		Name.setSize(100, 20);
		Money.setLocation(xGrid*3, yGrid*6);
		Money.setSize(100, 20);
		Pot.setLocation(xGrid*10, yGrid*3);
		Pot.setSize(100, 20);
		
		btnCall.setLocation(xGrid*16, yGrid*4);
		btnCall.setSize(130, 30);
		btnCall.addActionListener(this);
		btnCall.setText("Call");
		btnRaise.setLocation(xGrid*16, yGrid*5);
		btnRaise.setSize(130, 30);
		btnRaise.addActionListener(this);
		btnRaise.setText("Raise");
		btnFold.setLocation(xGrid*16, yGrid*6);
		btnFold.setSize(130, 30);
		btnFold.addActionListener(this);
		btnFold.setText("Fold");
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void updateScreen(Player inPlayer) {
		// TODO Auto-generated method stub
		
		DrawCard(PlayerCards[0],inPlayer==null?null:inPlayer.getHoleCards().get(0));
		DrawCard(PlayerCards[1],inPlayer==null?null:inPlayer.getHoleCards().get(1));
		if(controller.getGameData().getCommunityCards().size()>0)
			DrawCard(CommunityCards[0],controller.getGameData().getCommunityCards().get(0));
		if(controller.getGameData().getCommunityCards().size()>1)
			DrawCard(CommunityCards[1],controller.getGameData().getCommunityCards().get(1));
		if(controller.getGameData().getCommunityCards().size()>2)
			DrawCard(CommunityCards[2],controller.getGameData().getCommunityCards().get(2));
		if(controller.getGameData().getCommunityCards().size()>3)
			DrawCard(CommunityCards[3],controller.getGameData().getCommunityCards().get(3));
		if(controller.getGameData().getCommunityCards().size()>4)
			DrawCard(CommunityCards[4],controller.getGameData().getCommunityCards().get(4));
		
		Name.setText("Name: ");
		Money.setText("Money: ");
		Pot.setText("Pot: ");
		
	}
	
	private static Font myFont = new Font("Serif", Font.BOLD, 36);
	
	private void DrawCard(JPanel pnl, Card card){
		//Karte besteht aus
		//Rechteck
		// TODO Auto-generated method stub
		Graphics g = pnl.getGraphics();
		g.setColor(Color.lightGray);
		g.fillRect(1, 1, pnl.getWidth()-2, pnl.getHeight()-2);
		
		g.setColor(Color.black);
		g.drawRect(0, 0, pnl.getWidth()-1, pnl.getHeight()-1);
		
		g.setFont(myFont);
		if(card == null){
			g.drawString("?", pnl.getWidth()/2, pnl.getHeight()/2);
		}
		else{
			if(card.getSuit() == Suit.HEART || card.getSuit() == Suit.DIAMOND){
				g.setColor(Color.red);
			}
			g.drawString(card.toString() ,8, pnl.getHeight()/2);
			
		}
		
		
		g.dispose();
	}

	public void update() {
		if(controller.getStatus() == GameStatus.INITIALIZATION)
			return;
		this.setVisible(true);
		// TODO Auto-generated method stub
		if(controller.getCurrentPlayer() != currentPlayer)
		{
			currentPlayer = controller.getCurrentPlayer(); 
			JOptionPane.showMessageDialog(this, currentPlayer.getPlayerName()+ " ist jetzt an der Reihe", "Spielerwechsel", JOptionPane.INFORMATION_MESSAGE);
		}
		updateScreen(currentPlayer);
	}

}
