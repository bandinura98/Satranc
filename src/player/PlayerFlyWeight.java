package player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerFlyWeight {

	private ArrayList<String> PlayerList= new ArrayList<String>();
	
	public void fileReading()throws IOException {
		
		File f1= new File("player.txt");
		if(!f1.exists()){
			f1.createNewFile();
		}
		FileReader fr1= new FileReader(f1);
		BufferedReader br1= new BufferedReader(fr1);
		
		PlayerList.clear();
		
		String line;
		while( (line= br1.readLine()) !=null) 
		{
			PlayerList.add(line);
		}
		br1.close();
		
	}
	
	public String comparePlayerNames(String name) throws IOException {
		fileReading();
		ArrayList<String>temp = new ArrayList<String>();
		for(int i=0; i<=PlayerList.size()-1; i++) {
			String PlayerList1[]= PlayerList.get(i).split(";");
			temp.add(PlayerList1[0]);
		}
		
		Collections.sort(temp);
		int result= Collections.binarySearch(temp, name);
		
		if(result>=0) {  //If there is one of this name uses this name. If there is not one of this name creates new one.
			return PlayerList.get(result);
		}
		else {
			PlayerModel model = new PlayerModel();
			PlayerView view = new PlayerView();
			model.setPlayerName(name);
			model.setGamePlayed(0);
			model.setGameWon(0);
			PlayerController controller= new PlayerController(model, view);
			controller.updateView();
			controller.FileWriting();
			return comparePlayerNames(name);
		}
	}
	
}
