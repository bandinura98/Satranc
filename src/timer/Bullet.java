package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Bullet implements Time{
	
	private static int changer=0;
	private JLabel label;
	 Timer timer;
	 int totalTime=60;
	 static int whiteTime=60;
	 static int blackTime=60;
	
	public Bullet(JLabel labelFromMain) {
		this.label= labelFromMain;
		timer = new Timer(1000, new timeCounting());
	}
	
	@Override
	public void stop() {
		timer.stop();
		
	}
	
	@Override
	public void start() {
		if(changer%2==0) {
			blackTime= totalTime;
			totalTime=whiteTime;
			timer.start();
		}
		else {
			whiteTime=totalTime;
			totalTime=blackTime;
			timer.start();
		}
		changer++;
	}
	
	
	 
	
	class timeCounting implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int min,sec;
	     	 if (totalTime > 0)
	     	 {
	         	min=totalTime/60;
	         	sec=totalTime%60;
	          label.setText(String.valueOf(min)+":"+(sec>=10?String.valueOf(sec):"0"+String.valueOf(sec)));
	          totalTime--;
	       }
	     	if(totalTime==0) {
	     		label.setText("Time's up!");
	     	}
			
		}

	}
	
	
}

 