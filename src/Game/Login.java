package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import player.PlayerFlyWeight;


public class Login extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JTextField textField;
	private JCheckBox rememberMe;
	private JButton button;
	private JLabel label1;
	private String rememberReader;
	private static String userLogined; //The user who have login.
	
	public Login() throws IOException {
		setSize(380,230);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel1= new JPanel();
		getContentPane().add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.DARK_GRAY);

		Font font= new Font("TimesRoman", Font.LAYOUT_RIGHT_TO_LEFT ,20);
		
		label1=new JLabel("Username:");
		label1.setBounds(20, 50, 300,20);
		label1.setForeground(Color.white);
		label1.setFont(font);
		
		rememberReader= fileReading();
		
		textField= new JTextField(rememberReader);
		textField.setBounds(20,80,320,30);
		textField.setFont(font);
		
		rememberMe = new JCheckBox("Remember Me");
		rememberMe.setBounds(20,115,150,30);
		rememberMe.setBackground(Color.darkGray);
		rememberMe.setForeground(Color.white);
		rememberMe.setSelected(true);
		
		button = new JButton("Login");
		button.setBounds(240,120,100,40);
		button.addActionListener(this);
		
		panel1.add(button);
		panel1.add(rememberMe);
		panel1.add(label1);
		panel1.add(textField);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object e1= e.getSource();
		
		if(e1==button) {
			
			if(rememberMe.isSelected()) {
				try {
					FileWriting(true);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
			else {
				try {
					FileWriting(false);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			
			}
			
			PlayerFlyWeight playerControl = new PlayerFlyWeight();
			userLogined= textField.getText();
			try {
				playerControl.comparePlayerNames(userLogined);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			JFrame frame = new MainMenu();
			frame.setTitle("ChessPlate");
			dispose();
		}
		
		
		
		
	}
	
	public void FileWriting(boolean s)throws IOException {
		File f1= new File("rememberMe.txt");
		if(!f1.exists()){
			f1.createNewFile();
		}
		FileWriter fr1= new FileWriter(f1);
		BufferedWriter br1= new BufferedWriter(fr1);
		
		if(s==true) {
		br1.write(textField.getText());
		br1.close();}
		else {
		br1.write("");
		br1.close();}
	}

   public String fileReading()throws IOException {
		
		File f1= new File("rememberMe.txt");
		if(!f1.exists()){
			f1.createNewFile();
		}
		FileReader fr1= new FileReader(f1);
		BufferedReader br1= new BufferedReader(fr1);
		
		
		String line= br1.readLine();
		br1.close();
	
		return line;
	}
}

