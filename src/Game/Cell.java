package Game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Piece;

public class Cell extends JPanel implements Cloneable,CellColor{
	private static final long serialVersionUID = 6099306796949835185L;
	
	private boolean isPossibleDestination;
	private JLabel content;
	private Piece piece;
	int x,y;
	private boolean isSelected = false;
	private boolean isCheck = false;
	

	public Cell(int x,int y,Piece p) {
		this.x=x;
		this.y=y;
		
		setLayout(new BorderLayout());
		
		if((x+y)%2==0)
			setBackground(Color.white);
		
		else
			setBackground(Color.orange);
		
		if(p!=null)
			setPiece(p);
	}
	
	public Cell(Cell cell) throws CloneNotSupportedException{
		this.x=cell.x;
		this.y=cell.y;
		
		setLayout(new BorderLayout());
		
		if((x+y)%2==0)
			setBackground(Color.white);
		
		else
			setBackground(Color.orange);
  		if(cell.getPiece()!=null) {
			setPiece(cell.getPiece().getCopy());
		}
		else
			piece=null;
		
	}
	
	public void setPiece(Piece p) {
		piece = p;
		ImageIcon img = new ImageIcon(this.getClass().getResource(p.getPic()));
		content=new JLabel(img);
		this.add(content);
	}
	
	public void removePiece() {
			piece = null;
			this.remove(content);
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void select() {
		this.setBorder(BorderFactory.createLineBorder(Color.green,6));
	}
	
	public boolean isSelected() {
		return this.isSelected;
	}
	public void deSelect() {
		this.setBorder(null);
		this.isSelected=false;
	}
	
	public void setPossibleDestination() {
		this.setBorder(BorderFactory.createLineBorder(Color.green,4));
		this.isPossibleDestination=true;
	}
	
	public void removePossibleDestination(){
		this.setBorder(null);
		this.isPossibleDestination=false;
	}
	
	public boolean isPosibleDestination() {
		return this.isPossibleDestination;
	}
	
	public void setCheck() {
		this.setBackground(Color.RED);
		this.isCheck=true;
	}
	
	public void removeCheck() {
		this.setBorder(null);
		if((x+y)%2==0)
			setBackground(Color.white);
		else
			setBackground(Color.orange);
		this.isCheck=false;
	}
	
	public boolean isCheck() {
		return isCheck;
	}

	@Override
	public Color getColor(Color c) {
		
		return null;
	}
}