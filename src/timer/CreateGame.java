package timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.BoardProxy;
import Game.MainMenu;

public class CreateGame extends JFrame implements TimePicker, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JLabel label;
	private ArrayList<JButton> button= new ArrayList<JButton>();
	public String timerType;
	private TimeAdapter timeAdapter;
	private String timeKeeper;
	
	
	public CreateGame(JLabel label) {
		
		this.label= label;
		
		setSize(715,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel1 = new JPanel();
		getContentPane().add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.black);
		
		Font font= new Font("TimesRoman", Font.LAYOUT_RIGHT_TO_LEFT ,20);
		int xBound=50;
		int yBound=50;
		int width=200;
		int height=200;
		
		
		button1= new JButton("<html>Bullet<br/>1+0</html>");
		button2= new JButton("<html>Blitz<br/>3+0</html>");
		button3= new JButton("<html>Blitz<br/>3+2</html>");
		button4= new JButton("<html>Blitz<br/>5+2</html>");
		button5= new JButton("<html>Classic<br/>(No Time)</html>");
		button6= new JButton("Main Menu");
		
		button.add(button1);
		button.add(button2);
		button.add(button3);
		button.add(button4);
		button.add(button5);
		button.add(button6);
		
		for(int i=0; i<=2; i++) {
			button.get(i).setBounds(xBound, yBound, width, height);
			xBound+=200;
		}
		yBound+=200;
		xBound=50;
		for(int i=3; i<=5; i++) {
			button.get(i).setBounds(xBound, yBound, width, height);
			xBound+=200;
		}
		
		for(int i=0; i<=5; i++) {
			button.get(i).setBackground(Color.DARK_GRAY);
			button.get(i).setForeground(Color.white);
			button.get(i).setBorderPainted(true);
			button.get(i).setFont(font);
			button.get(i).addActionListener(this);
			panel1.add(button.get(i));
		}
		
		
		
		setVisible(true);
	}
	
	
	
	
	@Override
	public Time pick(String s) {
		this.timeKeeper =s;
		System.out.println("Test " +timeKeeper);
		timeAdapter=new TimeAdapter(timeKeeper, label);
		return timeAdapter.pick(s);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object e1=e.getSource();
		
		if(e1==button1) { //Oyun Tahtasý yazýlýnca oyun tahtasý frame'ini açan fonksiyon yaz..
			timerType="bullet";
			TimeAdapter.timeKeeper= "bullet";
			
			new BoardProxy();
			
			dispose();
		}
		else if(e1==button2) {
			timerType="blitz3_0";
			TimeAdapter.timeKeeper= "blitz3_0";
			new BoardProxy();
			dispose();
		}
		else if(e1==button3) {
			timerType="blitz3_2";
			TimeAdapter.timeKeeper= "blitz3_2";
			new BoardProxy();
			dispose();
		}
		else if(e1==button4) {
			timerType="blitz5_2";
			TimeAdapter.timeKeeper= "blitz5_2";
			new BoardProxy();
			dispose();
		}
		else if(e1==button5) {
			timerType="classic";
			TimeAdapter.timeKeeper= "classic";
			new BoardProxy();
			dispose();
		}
		else if(e1==button6) {
			new MainMenu();
			dispose();
			
		}
		
	}
}
