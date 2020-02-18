package pieces;

import java.util.ArrayList;

import Game.Cell;

public class Rook extends Piece {

	
	private boolean firstMove= false;
	public Rook (int color, String id, String pic) {
		setColor(color);
		setId(id);
		setPic(pic);	
	}
	

	
	public boolean isFirstMove() {
		return firstMove;
	}

	public void setFirstMove() {
		this.firstMove = true;
	}





	@Override
	public ArrayList<Cell> moves(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		//Rook can move lineer line. In this function we are going to define this logic.
		int tempX=x-1 , tempY=y;
		
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
