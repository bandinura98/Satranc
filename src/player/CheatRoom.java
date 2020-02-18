package player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextField;

public class CheatRoom {
	
	public CheatRoom() {
		
	}
	public static void SendMessage(String name ,JTextField yazField) {
		try {
			Socket socket = new Socket("localhost",9090);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			
			out.println("onlyForWriting");
			
			String str = yazField.getText();
			
			out.println(name + str);
			
			socket.close();
			
			}catch (Exception e1) {}
	}
	public static void GetMessage(JTextField field0,JTextField field1,JTextField field2,JTextField field3,JTextField field4) {
		try {
		Socket socket = new Socket("localhost",9090);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		out.println("onlyForReading");
		
		String str = input.readLine();
		field0.setText(str);
		
		
		str = input.readLine();
		field1.setText(str);
		
		
		str = input.readLine();
		field2.setText(str);
		
		
		str = input.readLine();
		field3.setText(str);
		
		
		str = input.readLine();
		field4.setText(str);
		
		socket.close();
		
	}	 catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}
