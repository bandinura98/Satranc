package Game;

import pieces.*;

public class PieceFactory {

	public Piece getPieceFactory(String PieceType, String id, String pic, int color, int x, int y) {
		
		if(PieceType == null) {
			return null;
		}
		if(PieceType.equalsIgnoreCase("PAWN")) {
			return new Pawn(color, id, pic);
		}
		if(PieceType.equalsIgnoreCase("KNIGHT")) {
			return new Knight(color, id, pic);
		}
		if(PieceType.equalsIgnoreCase("BISHOP")) {
			return new Bishop(color, id, pic);
		}
		if(PieceType.equalsIgnoreCase("ROOK")) {
			return new Rook(color, id, pic);
		}
		if(PieceType.equalsIgnoreCase("QUEEN")) {
			return new Queen(color, id, pic);
		}
		if(PieceType.equalsIgnoreCase("KING")) {
			return new King(color, id, pic, x ,y);
		}
		
		
		return null;
	}
	
}
