package pieces;

import java.util.ArrayList;

import Game.Cell;

public class King extends Piece{

	private int x,y;
	private boolean firstMove=false;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public King(int color, String id, String pic,int x, int y) {
		setColor(color);
		setId(id);
		setPic(pic);
		setX(x);
		setY(y);
	}
	
    public boolean getFirstMove() {
		return firstMove;
	}
	public void setFirstMove() {
		
		this.firstMove = true;
	 }
@Override
	public ArrayList<Cell> moves(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		int tempX[]= {x, x, x+1, x+1, x+1, x-1, x-1, x-1};
		int tempY[]= {y+1, y-1, y, y+1, y-1, y, y+1, y-1};		
	
		    for(int i=0; i<8; i++) {
			  if(tempX[i]>=0 && tempX[i]<8 && tempY[i]>=0 && tempY[i]<8) {
				if(pos[tempX[i]][tempY[i]].getPiece()==null || pos[tempX[i]][tempY[i]].getPiece().getColor()!=this.getColor()) {
					possibleMoves.add(pos[tempX[i]][tempY[i]]);
				}
			   }
		      }
		   
				/*if(getColor()== this.color && pos[x][y].getPiece() instanceof King && King.getFirstMove()==true ) {
					possibleMoves.add(pos[x][y+2]);
				}*/
			  
		    
		return possibleMoves;
	  }
	
	public boolean isInDanger(Cell[][] pos) {
		
		//This part is checking the danger of Knight.
		int tempX1[]= {x+2, x+2, x-2, x-2, x+1, x+1, x-1, x-1};
		int tempY1[]= {y-1, y+1, y-1, y+1, y+2, y-2, y+2, y-2};
	for(int i=0; i<8; i++) {
			if(tempX1[i]>=0 && tempX1[i]<8 && tempY1[i]>=0 && tempY1[i]<8) {
			if( pos[tempX1[i]][tempY1[i]].getPiece()!=null && pos[tempX1[i]][tempY1[i]].getPiece().getColor()!=this.getColor() && (pos[tempX1[i]][tempY1[i]].getPiece() instanceof Knight)) {
				return true;
			}
			}
		}
		
		//This part is checking the danger of pawn
	int pox[]={x+1,x+1,x+1,x,x,x-1,x-1,x-1};
	int poy[]={y-1,y+1,y,y+1,y-1,y+1,y-1,y};
	{
		for(int i=0;i<8;i++)
			if((pox[i]>=0&&pox[i]<8&&poy[i]>=0&&poy[i]<8))
				if(pos[pox[i]][poy[i]].getPiece()!=null && pos[pox[i]][poy[i]].getPiece().getColor()!=this.getColor() && (pos[pox[i]][poy[i]].getPiece() instanceof King))
				{
					return true;
				}
	}
	    if(getColor()==0)
	{
		 if(x>0 && y>0 && pos[x-1][y-1].getPiece()!=null&& pos[x-1][y-1].getPiece().getColor()==1&&( pos[x-1][y-1].getPiece() instanceof Pawn))
			return true;
		 if(x>0 && y<7 && pos[x-1][y+1].getPiece()!=null&& pos[x-1][y+1].getPiece().getColor()==1&&( pos[x-1][y+1].getPiece() instanceof Pawn))
			return true;
	}
	else
	{
		if(x<7&&y>0&& pos[x+1][y-1].getPiece()!=null&& pos[x+1][y-1].getPiece().getColor()==0&&( pos[x+1][y-1].getPiece() instanceof Pawn))
			return true;
		if(x<7 && y<7 && pos[x+1][y+1].getPiece()!=null&& pos[x+1][y+1].getPiece().getColor()==0 &&( pos[x+1][y+1].getPiece() instanceof Pawn))
			return true;
	}
		
		//This part is checking the danger of sides
	for(int i= x+1 ; i<8; i++) {
			if(pos[i][y].getPiece()==null) {
				continue;
			}
			else
				if(pos[i][y].getPiece().getColor()==this.getColor()) {
					break;
				}
				else {
					if(pos[i][y].getPiece() instanceof Rook || pos[i][y].getPiece() instanceof Queen) {
						return true;
					}
					else
						break;
				}
			
		}
	for(int i= x-1 ; i>=0; i--) {
			if(pos[i][y].getPiece()==null) {
				continue;
			}
			else
				if(pos[i][y].getPiece().getColor()==this.getColor()) {
					break;
				}
				else {
					if(pos[i][y].getPiece() instanceof Rook || pos[i][y].getPiece() instanceof Queen) {
						return true;
					}
					else
						break;
				}
			
		}
	for(int i= y+1 ; i<8; i++) {
			if(pos[x][i].getPiece()==null) {
				continue;
			}
			else
				if(pos[x][i].getPiece().getColor()==this.getColor()) {
					break;
				}
				else {
					if(pos[x][i].getPiece() instanceof Rook || pos[x][i].getPiece() instanceof Queen) {
						return true;
					}
					else
						break;
				}
		}
		
	for(int i= y-1 ; i>=0; i--) {
			if(pos[x][i].getPiece()==null) {
				continue;
			}
			else
				if(pos[x][i].getPiece().getColor()==this.getColor()) {
					break;
				}
				else {
					if(pos[x][i].getPiece() instanceof Rook || pos[x][i].getPiece() instanceof Queen) {
						return true;
					}
					else
						break;
				}
			
		}
		
		//This part is checking the danger of diagonal sides.
		int tempX= x+1;
		int tempY= y-1;
		
	while(tempX<8 && tempY>0) {
			  if(pos[tempX][tempY].getPiece()==null ) {
				  tempX++;
				  tempY--;
			  }
			  else 
				if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
				break;
			  }
			  else { 
				  if(pos[tempX][tempY].getPiece() instanceof Bishop || pos[tempX][tempY].getPiece() instanceof Queen) {
					  return true;
				  }
				  else break;
			  }
			
		   }
		
		tempX= x-1;
		tempY= y+1;
		
	while(tempY<8 && tempX>=0) {
		  if(pos[tempX][tempY].getPiece()==null) {
			  tempX--;
			  tempY++;
		  }
	   	  else 
			if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
			break;
		  }
		  else { 
			  if(pos[tempX][tempY].getPiece() instanceof Bishop || pos[tempX][tempY].getPiece() instanceof Queen) {
				  return true;
			  }
			  else break;
		  }
		  
	    }
		
		tempX= x-1;
		tempY= y-1;
		
	while(tempX>=0 && tempY>=0) {
		  if(pos[tempX][tempY].getPiece()==null) {
			  tempX--;
			  tempY--;
		  }
		  else 
			if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
			break;
		  }
		  else { 
			  if(pos[tempX][tempY].getPiece() instanceof Bishop || pos[tempX][tempY].getPiece() instanceof Queen) {
				  return true;
			  }
			  else break;
	   	  }
		 
  	   }
		tempX= x+1;
		tempY= y+1;
		
	while(tempX<8 && tempY<8) {
		  if(pos[tempX][tempY].getPiece()==null) {
			  tempX++;
			  tempY++;
		  }
		  else 
			if(pos[tempX][tempY].getPiece().getColor()==this.getColor()) {
			break;
		  }
		  else { 
			  if(pos[tempX][tempY].getPiece() instanceof Bishop || pos[tempX][tempY].getPiece() instanceof Queen) {
				  return true;
			  }
			  else break;
		  }
	    }
		return false;
	}

}
