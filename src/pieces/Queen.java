package pieces;

import java.util.ArrayList;

import Game.Cell;

public class Queen extends Piece {
	
	public Queen (int color, String id, String pic) {
		setColor(color);
		setId(id);
		setPic(pic);	
	}
	
	@Override
	public ArrayList<Cell> moves(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		//Queen is able to move like rook and bishop at the same time
		//In first part we are going to define diagonal cells and we are going to define lineer cells
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
				
				//After here we are defining lineer cells
			tempX=x-1 ;
			tempY=y;
		
			while(tempX>=0) {
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
				 tempX--;
			}
			tempX=x+1;
			while(tempX<8) {
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
			}
		
			tempX=x;
			tempY=y-1;
			while(tempY>=0) {
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
				 tempY--;
			}
			tempY=y+1;
			while(tempY<8) {
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
				 tempY++;
			 }
				
		
		
		return possibleMoves;
	}
	
}
