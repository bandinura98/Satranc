package Game;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppMain extends JFrame{

	private static final long serialVersionUID = 1L;
	public static JLabel label;
	public static void main(String[] args) throws IOException{
		
		JFrame frame=  new Login();
		frame.setTitle("ChessPlate");
	}
	
}
