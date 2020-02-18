package pieces;

import java.util.ArrayList;
import Game.Cell;

public class Bishop extends Piece {

	
	public Bishop(int color, String id, String pic) {
		
		setColor(color);
		setId(id);
		setPic(pic);		
	}
	
	
	
	@Override
	public ArrayList<Cell> moves(Cell[][] pos, int x, int y) {
	
		//This function define bishop's moves.
		possibleMoves.clear();
		
	//In first loop we defined North East side's moves.
		int tempX= x+1, tempY= y-1;
		
		while(tempX<8 && tempY>=0) {
		  if(pos[tempX][tempY].getPiece()==null ) {
			possibleMoves.add(pos[tempX][tempY]);
		  }
		  else 
			if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
			break;
		  }
		  else { 
			possibleMoves.add(pos[tempX][tempY]);
			break;
		  }
		 tempX++;
		 tempY--;
	   }
	//In second loop we defined South West side's moves.
		tempX= x-1;
		tempY= y+1;
		
		while(tempX>=0 && tempY<8) {
		  if(pos[tempX][tempY].getPiece()==null) {
			possibleMoves.add(pos[tempX][tempY]);
		  }
	   	  else 
			if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
			break;
		  }
		  else { 
			possibleMoves.add(pos[tempX][tempY]);
			break;
		  }
		  tempX--;
		  tempY++;
	    }
	// In the third step we defined North West side's moves.
		tempX= x-1;
		tempY= y-1;
		
		while(tempX>=0 && tempY>=0) {
		  if(pos[tempX][tempY].getPiece()==null) {
			possibleMoves.add(pos[tempX][tempY]);
		  }
		  else 
			if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
			break;
		  }
		  else { 
			possibleMoves.add(pos[tempX][tempY]);
			break;
	   	  }
		 tempX--;
		tempY--;
  	   }
	//In the last loop we defined South East side's moves
		tempX= x+1;
		tempY= y+1;
		
		while(tempX<8 && tempY<8) {
		  if(pos[tempX][tempY].getPiece()==null) {
			possibleMoves.add(pos[tempX][tempY]);
		  }
		  else 
			if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
			break;
		  }
		  else { 
			possibleMoves.add(pos[tempX][tempY]);
			break;
		  }
		 tempX++;
		 tempY++;
	    }
	 	
	return possibleMoves;	

}
	
}
