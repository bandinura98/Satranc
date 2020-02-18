package pieces;

import java.util.ArrayList;
import Game.Cell;

public abstract class Piece implements Cloneable {
	
	private int color;
	private String id= null;
	private String pic; 
	protected ArrayList<Cell> possibleMoves= new ArrayList<Cell>(); 
	public abstract ArrayList<Cell> moves(Cell pos[][], int x, int y );
	
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	public Piece getCopy() throws CloneNotSupportedException {
		
		return (Piece) this.clone();
	}
	

}
