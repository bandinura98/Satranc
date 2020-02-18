package pieces;

import java.util.ArrayList;
import Game.Cell;

public class Knight extends Piece {
	
	
	public Knight(int color, String id, String pic) {
		setColor(color);
		setId(id);
		setPic(pic);	
	}
	
	@Override
	public ArrayList<Cell> moves(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		//There are max 8 different possible moves for Knigt on the board.
		
		int tempX[]= {x+2, x+2, x-2, x-2, x+1, x+1, x-1, x-1};
		int tempY[]= {y-1, y+1, y-1, y+1, y+2, y-2, y+2, y-2};

		for(int i=0; i<8; i++) {
		  if(tempX[i]>=0 && tempX[i]<8 && tempY[i]>= 0 && tempY[i]<8) {
		   if((pos[tempX[i]][tempY[i]].getPiece()==null||pos[tempX[i]][tempY[i]].getPiece().getColor()!=this.getColor())) {
			 possibleMoves.add(pos[tempX[i]][tempY[i]]);
		   }
		  }
		}
		
		return possibleMoves;
	}

}		
