package Game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardProxy extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2316312031855246757L;
	private JPanel panel;
	private JLabel label;
	private static final int x = 875;
	private static final int y = 855;
	Object test;
	Timer timer;
	private GameBoard gameBoard = null;
	
	public BoardProxy(){
		
		setUndecorated(true);
		panel = new JPanel();
		
		try {
			BufferedImage mypic = ImageIO.read(new File("ispinner.png"));
			label = new JLabel(new ImageIcon(mypic));
		} catch (IOException e) {
			System.err.println("Exeception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panel.setLayout(new GridLayout(1,1));
		
		
		
		panel.add(label);
		
		
		this.add(panel);
		this.setSize(x, y);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		timer = new Timer(2500,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(gameBoard==null) {
					test= 3;
				gameBoard = GameBoard.TableBuilder();
				
				getFrame().dispose();
				timer.stop();
				
				}
				else {
					timer.stop();

				}
			}
		});
		timer.start();

	    
	    
		
		
	}
	
	
	
	public static void main(String args[]) {
		new BoardProxy();
	}
	private JFrame getFrame() {
		return this;
	}
	
}
