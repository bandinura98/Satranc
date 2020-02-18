package pieces;

import java.util.ArrayList;

import Game.Cell;

public class Pawn extends Piece {

	
	
	public Pawn(int color, String id, String pic) {
		setColor(color);
		setId(id);
		setPic(pic);	
	}
	
	
	@Override
	public ArrayList<Cell> moves(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		if(getColor()==0) {//for white moves
			
			
			if(pos[x-1][y].getPiece()==null) {
				possibleMoves.add(pos[x-1][y]);
			}
			if(y<7 &&  pos[x-1][y+1].getPiece()!=null && pos[x-1][y+1].getPiece().getColor()!=this.getColor()) {
				possibleMoves.add(pos[x-1][y+1]);
			}
			if(y>0 && pos[x-1][y-1].getPiece()!=null && pos[x-1][y-1].getPiece().getColor()!=this.getColor()) {
				possibleMoves.add(pos[x-1][y-1]);
			}
			if(x==6 && pos[x-2][y].getPiece()==null) {
				possibleMoves.add(pos[x-2][y]);
			}
			
		 }
		if(getColor()==1) {//for black moves
			
			if(pos[x+1][y].getPiece()==null) {
				possibleMoves.add(pos[x+1][y]);
			}
			if(y<7 && pos[x+1][y+1].getPiece()!=null && pos[x+1][y+1].getPiece().getColor()!=this.getColor()) {
				possibleMoves.add(pos[x+1][y+1]);
			}
			if(y>0 && pos[x+1][y-1].getPiece()!=null && pos[x+1][y-1].getPiece().getColor()!=this.getColor()) {
				possibleMoves.add(pos[x+1][y-1]);
			}
			if(x==1 && pos[x+2][y].getPiece()==null) {
				possibleMoves.add(pos[x+2][y]);
			}
			
		}
		
		return possibleMoves;
	}
}
