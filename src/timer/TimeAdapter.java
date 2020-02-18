package timer;

import javax.swing.JLabel;


public class TimeAdapter implements TimePicker {
	
	private String timeType;
	private JLabel label;
	public static String timeKeeper;
	
	public TimeAdapter(String timeType, JLabel label) {
		
		this.label = label;
		this.timeType= timeType;
		
		
		
	}
	
	
	
	@Override
	public Time pick(String s) {
		
		if(timeType.equalsIgnoreCase("bullet")) {
			return new Bullet(label);
		}
		else if(timeType.equalsIgnoreCase("blitz3_0")) {
			return new Blitz3_0(label);
		}
		else if(timeType.equalsIgnoreCase("blitz3_2")) {
			return new Blitz3_2(label);
		}
		else if(timeType.equalsIgnoreCase("blitz5_2")) {
			return new Blitz5_2(label);
		}
		else if(timeType.equalsIgnoreCase("classic")) {
			return new Classic(label);
		}
		
		return null;
	}

}
