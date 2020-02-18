package player;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Cheat extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel MainPanel;
	private JPanel holder5;
	private JTextField field0;
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField field4;
	private JTextField yazField;
	
	private String name;

	
	public Cheat() {
		
		setSize(500, 500);

		MainPanel = new JPanel();
		getContentPane().add(MainPanel);
		MainPanel.setLayout(new GridLayout(2,1));
		
		holder5 = new JPanel();
		field0 = new JTextField();
		field0.setEditable(false);
		field0.setBorder(null);
		
		field1 = new JTextField();
		field1.setEditable(false);
		field1.setBorder(null);
		
		field2 = new JTextField();
		field2.setEditable(false);
		field2.setBorder(null);
		
		field3 = new JTextField();
		field3.setEditable(false);
		field3.setBorder(null);
		
		field4 = new JTextField();
		field4.setEditable(false);
		field4.setBorder(null);
		
		holder5.setLayout(new GridLayout(5,1));
		holder5.add(field0);
		holder5.add(field1);
		holder5.add(field2);
		holder5.add(field3);
		holder5.add(field4);
		
		yazField = new JTextField("TYPE ANYTHING");
		yazField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int x = e.getKeyCode();
				if(x == KeyEvent.VK_ENTER) {
					String str = getName();
					
					CheatRoom.SendMessage(str,yazField);
					yazField.setText("");
					
				}
				
			}
		});
		
		
		MainPanel.add(holder5);
		MainPanel.add(yazField);
		

		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		Timer timer = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					CheatRoom.GetMessage(field0, field1, field2, field3, field4);
					
					
				}catch (Exception e1) {}
				
			}
		});
		try {
		File file = new File("rememberMe.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String str = br.readLine();
		
		setName(str + ": ");
		
		br.close();
		
		}catch (Exception e) {}
		
			
			timer.start();
		
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
