package player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Server{
	
	
	
	public static void main(String[] args) throws IOException{
		//"onlyForReading";

		ServerSocket server= new ServerSocket(9090);
		
		JFrame frame = new JFrame("SERVER");
		JPanel panel = new JPanel();
		
		JButton button = new JButton("Close the Server");
		button.setBounds(0, 0, 300, 180);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					server.close();
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		panel.add(button);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		///
		
		
		ArrayList<String> StrList = new ArrayList<String>();
		
		StrList.add("");
		StrList.add("");
		StrList.add("");
		StrList.add("");
		StrList.add("");
		
		
		try {
		while(true) {
		
		Socket socket = server.accept();
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		
		
		String str = input.readLine();
		
		if(str.equalsIgnoreCase("onlyForReading")) {
			out.println(StrList.get(StrList.size()-5));
			out.println(StrList.get(StrList.size()-4));
			out.println(StrList.get(StrList.size()-3));
			out.println(StrList.get(StrList.size()-2));
			out.println(StrList.get(StrList.size()-1));
			
			
		}else if(str.equalsIgnoreCase("onlyForWriting")) {
			str = input.readLine();
			StrList.add(str);
		}
		
		
		}}finally {
			server.close();
		}
	
	}
}
