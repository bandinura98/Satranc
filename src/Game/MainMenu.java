package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import player.Cheat;

 
 
public class MainMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton PlayButton;
	private JButton ChatButton;
	private JButton exitButton;
	private JLabel label;
	private JLabel label1;
	
	
	
	public MainMenu() {
	
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label = new JLabel("ChessPlate");
		label.setForeground(Color.white);
		label.setFont(new Font("TimesRoman", Font.BOLD ,30));
		label.setBounds(165,10,170,75);
		
		label1 = new JLabel("--------------------------------------------------");
		label1.setForeground(Color.white);
		label1.setFont(new Font("TimesRoman", Font.BOLD ,30));
		label1.setBounds(0,60,500,20);
		
		PlayButton = new JButton("Play Chess");
		PlayButton.setBounds(175, 120, 150, 75);
		PlayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GameBoard gb= GameBoard.getBoard();
				dispose();
				
			}
		});
		
		ChatButton = new JButton("Chat Room");
		ChatButton.setBorderPainted(true);
		ChatButton.setBounds(175, 220, 150, 75);
		ChatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Cheat();
				dispose();
				
				
			}
		});
		
		exitButton = new JButton("EXIT");
		exitButton.setBounds(175, 320, 150, 75);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});

		panel.add(label1);
		panel.add(label);
		panel.add(PlayButton);
		panel.add(ChatButton);
		panel.add(exitButton);
		
		add(panel);
		setUndecorated(true);
		setVisible(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("ChessPlate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]) {
		new MainMenu();
	}
}
