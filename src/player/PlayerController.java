package player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerController {

	private PlayerModel model;
	private PlayerView view;
	
	 public PlayerController(PlayerModel model, PlayerView view) {
		this.model=model;
		this.view=view;
	}
	
	 	public String getPlayerName() {
			return model.getPlayerName();
		}
		public void setPlayerName(String playerName) {
			model.setPlayerName(playerName);
		}
		public int getGamePlayed() {
			return model.getGamePlayed();
		}
		public void setGamePlayed(int gamePlayed) {
			model.setGamePlayed(gamePlayed);;
		}
		public int getGameWon() {
			return model.getGameWon();
		}
		public void setGameWon(int gameWon) {
			model.setGameWon(gameWon);;
		}
		
		public String updateView() {
			return view.PlayerInfo(model.getPlayerName(), model.getGamePlayed(), model.getGameWon());
		}
	 
		public void FileWriting()throws IOException {
			File f1= new File("player.txt");
			if(!f1.exists()){
				f1.createNewFile();
			}
			FileWriter fr1= new FileWriter(f1, true);
			BufferedWriter br1= new BufferedWriter(fr1);
			
			br1.write(updateView());
			br1.newLine();
			br1.close();
		}
		
}
