package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import timer.CreateGame;
import timer.Time;
import timer.TimeAdapter;

public class GameBoard extends JFrame implements MouseListener{

private static final long serialVersionUID = 1L;
	
	//Variable Declaration
	private static final int Height=875;
	private static final int Width=855;
	private static ArrayList<Piece> piece;
	private Cell c, previous;
	private int chance=0;
	private Cell boardState[][];
	private ArrayList<Cell> destinationlist = new ArrayList<Cell>();
	private JPanel board=new JPanel(new GridLayout(8,8));
	private Container content;
	public static JLabel label;
	private static GameBoard Mainboard;
	private String winner=null;
	static String move;
	private JButton back;
	private static CreateGame timeSet;
	private static Time time;
	
	public static GameBoard TableBuilder(){ //The function which is creating pieces objects.
	
	PieceFactory pf1= new PieceFactory();
	piece= new ArrayList<Piece>();
	
	piece.add(pf1.getPieceFactory("rook", "BR01" , "Black_Rook.png", 1, 0, 0));
	piece.add(pf1.getPieceFactory("rook", "BR02" , "Black_Rook.png", 1, 0, 0));
	piece.add(pf1.getPieceFactory("rook", "WR01" , "White_Rook.png", 0, 0, 0));
	piece.add(pf1.getPieceFactory("rook", "WR02" , "White_Rook.png", 0, 0, 0));
	piece.add(pf1.getPieceFactory("knight", "BR01" , "Black_Knight.png", 1, 0, 0));
	piece.add(pf1.getPieceFactory("knight", "BR02" , "Black_Knight.png", 1, 0, 0));
	piece.add(pf1.getPieceFactory("knight", "WR01" , "White_Knight.png", 0, 0, 0));
	piece.add(pf1.getPieceFactory("knight", "WR02" , "White_Knight.png", 0, 0, 0));
	piece.add(pf1.getPieceFactory("bishop", "BB01" , "Black_Bishop.png", 1, 0, 0));
	piece.add(pf1.getPieceFactory("bishop", "BB02" , "Black_Bishop.png", 1, 0, 0));
	piece.add(pf1.getPieceFactory("bishop", "WB01" , "White_Bishop.png", 0, 0, 0));
	piece.add(pf1.getPieceFactory("bishop", "WB02" , "White_Bishop.png", 0, 0, 0));
	piece.add(pf1.getPieceFactory("king", "BK" , "Black_King.png", 1, 0, 4));
	piece.add(pf1.getPieceFactory("queen", "BQ" , "Black_Queen.png", 1, 0, 0));
	piece.add(pf1.getPieceFactory("king", "WK" , "White_King.png", 0, 7, 4));
	piece.add(pf1.getPieceFactory("queen", "WQ" , "White_Queen.png", 0, 0, 0));
	for(int i=16;i<24;i++)
	{
		piece.add(pf1.getPieceFactory("pawn", "B0"+(i-15) , "Black_Pawn.png", 1, 0, 0));
	}	
	for(int i=24;i<32;i++)
	{
		piece.add(pf1.getPieceFactory("pawn", "WP0"+(i-24) , "White_Pawn.png", 0, 0, 0));
	}
	
	 label = new JLabel("Time is Starting"); //Timer Label
	 timeSet = new CreateGame(label);
	 timeSet.dispose();
	 
	Mainboard = new GameBoard();
	Mainboard.setVisible(true);	
	Mainboard.setResizable(false);
		
	  
	  return null;
	}
	
	public static GameBoard getBoard() {
		label = new JLabel("Time is Starting"); //Timer Label
		 
		  
		 timeSet = new CreateGame(label);
		 return null;
	}
	//Constructor
	private GameBoard ()
    {
		
		move="White";
		winner=null;
		board=new JPanel(new GridLayout(8,8));
		board.setBounds(25,50,800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(this.getClass().getResource("icon.png"));
		this.setIconImage(img.getImage());
		
		 
		  label.setFont(new Font("SERIF", Font.BOLD, 30));
		  label.setForeground(Color.white);
		  label.setBounds(600, 710, 250, 150);
		  
			
		  		time=  timeSet.pick(TimeAdapter.timeKeeper);
			
		  		
		  		
			 time.start();
		 
		
		Cell cell;
		
		pieces.Piece P;
		content=getContentPane();
		content.setLayout(null);
		setSize(Width,Height);
		setTitle("ChessPlate");
		content.setBackground(Color.darkGray);
		

		//Defining all the Cells
		boardState=new Cell[8][8];
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{	
				P=null; //Puts pieces to the Cells
				if(i==0&&j==0)
					P= (Rook)piece.get(0);
				else if(i==0&&j==7)
					P= (Rook)piece.get(1);
				else if(i==7&&j==0)
					P= (Rook)piece.get(2);
				else if(i==7&&j==7)
					P= (Rook)piece.get(3);
				else if(i==0&&j==1)
					P= (Knight)piece.get(4);
				else if (i==0&&j==6)
					P= (Knight)piece.get(5);
				else if(i==7&&j==1)
					P=(Knight)piece.get(6);
				else if (i==7&&j==6)
					P=(Knight)piece.get(7);
				else if(i==0&&j==2)
					P=(Bishop)piece.get(8);
				else if (i==0&&j==5)
					P=(Bishop)piece.get(9);
				else if(i==7&&j==2)
					P=(Bishop)piece.get(10);
				else if(i==7&&j==5)
					P=(Bishop)piece.get(11);
				else if(i==0&&j==4)
					P=(King)piece.get(12);
				else if(i==0&&j==3)
					P=(Queen)piece.get(13);
				else if(i==7&&j==4)
					P=(King)piece.get(14);
				else if(i==7&&j==3)
					P=(Queen)piece.get(15);
				else if(i==1)
				P=(Pawn)piece.get((j+16));
				else if(i==6)
					P=(Pawn)piece.get((j+24));
				cell=new Cell(i,j,P);
				cell.addMouseListener(this);
				board.add(cell);
				boardState[i][j]=cell;
			}
		  
		  back = new JButton("<");
		  back.setFont(new Font("SERIF", Font.BOLD, 70));
		  back.setBackground(Color.darkGray);
		  back.setForeground(Color.white);
		  back.setBorder(null);
		  back.setBounds(30, 755, 70, 70);
		  back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				dispose();
			}
		});
		  
		  
		  board.setMinimumSize(new Dimension(800,700));
		  content.add(back);
		  content.add(board);
		  content.add(label);
		  
		  
			
			  setLocationRelativeTo(null);
			  setVisible(true);  
			}         
	private King getKing(int color)
	{
		if (color==0)
			return (King)piece.get(14);
		else
			return (King)piece.get(12);
	}
	
	public void changechance()
	{
		if (boardState[getKing(chance).getX()][getKing(chance).getY()].isCheck())
		{
			chance^=1;
			gameend();
		}
		if(destinationlist.isEmpty()==false)
			cleandestinations(destinationlist);
		if(previous!=null)
			previous.deSelect();
		previous=null;
		chance^=1;
		if(time!=null)
		{
			time.start();
			if(GameBoard.move=="White")
				GameBoard.move="Black";
			else
				GameBoard.move="White";
			
		}
	}

	//A function to clean the highlights of possible destination cells
    private void cleandestinations(ArrayList<Cell> destlist)      //Function to clear the last move's destinations
    {
    	ListIterator<Cell> it = destlist.listIterator();
    	while(it.hasNext())
    		it.next().removePossibleDestination();
    }
    
    //A function that indicates the possible moves by highlighting the Cells
    private void highlightdestinations(ArrayList<Cell> destlist)
    {
    	ListIterator<Cell> it = destlist.listIterator();
    	while(it.hasNext())
    		it.next().setPossibleDestination();
    }
    
    
   //Function to check if the king will be in danger if the given move is made
    private boolean willkingbeindanger(Cell fromcell,Cell tocell)
    {
    	Cell newboardstate[][] = new Cell[8][8];
    	for(int i=0;i<8;i++)
    		for(int j=0;j<8;j++)
    		{	try { newboardstate[i][j] = new Cell(boardState[i][j]);} catch (CloneNotSupportedException e){e.printStackTrace(); System.out.println("There is a problem with cloning !!"); }}
    	
    	if(newboardstate[tocell.x][tocell.y].getPiece()!=null)
			newboardstate[tocell.x][tocell.y].removePiece();
    	
		newboardstate[tocell.x][tocell.y].setPiece(newboardstate[fromcell.x][fromcell.y].getPiece());
		if(newboardstate[tocell.x][tocell.y].getPiece() instanceof King)
		{
			((King)(newboardstate[tocell.x][tocell.y].getPiece())).setX(tocell.x);
			((King)(newboardstate[tocell.x][tocell.y].getPiece())).setY(tocell.y);
		}
		newboardstate[fromcell.x][fromcell.y].removePiece();
		if (((King)(newboardstate[getKing(chance).getX()][getKing(chance).getY()].getPiece())).isInDanger(newboardstate)==true)
			return true;
		else
			return false;
    }
    
    //A function to eliminate the possible moves that will put the King in danger
    private ArrayList<Cell> filterdestination (ArrayList<Cell> destlist, Cell fromcell)
    {
    	ArrayList<Cell> newlist = new ArrayList<Cell>();
    	Cell newboardstate[][] = new Cell[8][8];
    	ListIterator<Cell> it = destlist.listIterator();
    	int x,y;
    	while (it.hasNext())
    	{
    		for(int i=0;i<8;i++)
        		for(int j=0;j<8;j++)
        		{	try { newboardstate[i][j] = new Cell(boardState[i][j]);} catch (CloneNotSupportedException e){e.printStackTrace();}}
    		
    		Cell tempc = it.next();
    		if(newboardstate[tempc.x][tempc.y].getPiece()!=null)
    			newboardstate[tempc.x][tempc.y].removePiece();
    		newboardstate[tempc.x][tempc.y].setPiece(newboardstate[fromcell.x][fromcell.y].getPiece());
    		x=getKing(chance).getX();
    		y=getKing(chance).getY();
    		if(newboardstate[fromcell.x][fromcell.y].getPiece() instanceof King)
    		{
    			((King)(newboardstate[tempc.x][tempc.y].getPiece())).setX(tempc.x);
    			((King)(newboardstate[tempc.x][tempc.y].getPiece())).setY(tempc.y);
    			x=tempc.x;
    			y=tempc.y;
    		}
    		newboardstate[fromcell.x][fromcell.y].removePiece();
    		if ((((King)(newboardstate[x][y].getPiece())).isInDanger(newboardstate)==false))
    			newlist.add(tempc);
    	}
    	return newlist;
    }

	    
  //A Function to filter the possible moves when the king of the current player is under Check 
    private ArrayList<Cell> incheckfilter (ArrayList<Cell> destlist, Cell fromcell, int color)
    {
    	ArrayList<Cell> newlist = new ArrayList<Cell>();
    	Cell newboardstate[][] = new Cell[8][8];
    	ListIterator<Cell> it = destlist.listIterator();
    	int x,y;
    	while (it.hasNext())
    	{
    		for(int i=0;i<8;i++)
        		for(int j=0;j<8;j++)
        		{	try { newboardstate[i][j] = new Cell(boardState[i][j]);} catch (CloneNotSupportedException e){e.printStackTrace();}}
    		Cell tempc = it.next();
    		if(newboardstate[tempc.x][tempc.y].getPiece()!=null)
    			newboardstate[tempc.x][tempc.y].removePiece();
    		newboardstate[tempc.x][tempc.y].setPiece(newboardstate[fromcell.x][fromcell.y].getPiece());
    		x=getKing(color).getX();
    		y=getKing(color).getY();
    		if(newboardstate[tempc.x][tempc.y].getPiece() instanceof King)
    		{
    			((King)(newboardstate[tempc.x][tempc.y].getPiece())).setX(tempc.x);
    			((King)(newboardstate[tempc.x][tempc.y].getPiece())).setY(tempc.y);
    			x=tempc.x;
    			y=tempc.y;
    		}
    		newboardstate[fromcell.x][fromcell.y].removePiece();
    		if ((((King)(newboardstate[x][y].getPiece())).isInDanger(newboardstate)==false))
    			newlist.add(tempc);
    	}
    	return newlist;
    }
 
    //A function to check if the King is check-mate. The Game Ends if this function returns true.
    public boolean checkmate(int color)
    {
    	ArrayList<Cell> dlist = new ArrayList<Cell>();
    	for(int i=0;i<8;i++)
    	{
    		for(int j=0;j<8;j++)
    		{
    			if (boardState[i][j].getPiece()!=null && boardState[i][j].getPiece().getColor()==color)
    			{
    				dlist.clear();
    				dlist=boardState[i][j].getPiece().moves(boardState, i, j);
    				dlist=incheckfilter(dlist,boardState[i][j],color);
    				if(dlist.size()!=0)
    					return false;
    			}
    		}
    	}
    	return true;
    }
    
    @SuppressWarnings("deprecation")
	private void gameend()
    {
    	cleandestinations(destinationlist);
    	 time.stop();
    	if(previous!=null)
    		previous.removePiece();
    	if(chance==0)
		{	
			winner= "White Player";
		}
		else
		{
			winner= "Black Player";
		}
		JOptionPane.showMessageDialog(board,"Checkmate!!!\n"+winner+" wins");
		
		
	
		Mainboard.disable();
		Mainboard.dispose();
		Mainboard = new GameBoard();
		Mainboard.setVisible(true);
		Mainboard.setResizable(false);
    }
    
	    
 
	@Override
		public void mouseClicked(MouseEvent e) {
		c=(Cell)e.getSource();
		if (previous==null)
		{
			if(c.getPiece()!=null)
			{
				if(c.getPiece().getColor()!=chance)
					return;
				c.select();
				previous=c;
				destinationlist.clear();
				destinationlist=c.getPiece().moves(boardState, c.x, c.y);
				if(c.getPiece() instanceof King)
					destinationlist=filterdestination(destinationlist,c);
				else
				{
					if(boardState[getKing(chance).getX()][getKing(chance).getY()].isCheck())
						destinationlist = new ArrayList<Cell>(filterdestination(destinationlist,c));
					else if(destinationlist.isEmpty()==false && willkingbeindanger(c,destinationlist.get(0)))
						destinationlist.clear();
				}
				highlightdestinations(destinationlist);
			}
		}
		else
		{
			if(c.x==previous.x && c.y==previous.y)
			{
				c.deSelect();
				cleandestinations(destinationlist);
				destinationlist.clear();
				previous=null;
			}
			else if(c.getPiece()==null||previous.getPiece().getColor()!=c.getPiece().getColor())
			{
				if(c.isPosibleDestination())
				{
					if(c.getPiece()!=null)
						c.removePiece();
					c.setPiece(previous.getPiece());
					if (previous.isCheck())
						previous.removeCheck();
					previous.removePiece();
					if(getKing(chance^1).isInDanger(boardState))
					{
						boardState[getKing(chance^1).getX()][getKing(chance^1).getY()].setCheck();
						if (checkmate(getKing(chance^1).getColor()))
						{
							previous.deSelect();
							if(previous.getPiece()!=null)
								previous.removePiece();
							gameend();
						}
					}
					if(getKing(chance).isInDanger(boardState)==false)
						boardState[getKing(chance).getX()][getKing(chance).getY()].removeCheck();
					if(c.getPiece() instanceof King)
					{
						((King)c.getPiece()).setX(c.x);
						((King)c.getPiece()).setY(c.y);
					}
					changechance();
				}
				if(previous!=null)
				{
					previous.deSelect();
					previous=null;
				}
				cleandestinations(destinationlist);
				destinationlist.clear();
			}
			else if(previous.getPiece().getColor()==c.getPiece().getColor())
			{
				previous.deSelect();
				cleandestinations(destinationlist);
				destinationlist.clear();
				c.select();
				previous=c;
				destinationlist=c.getPiece().moves(boardState, c.x, c.y);
				if(c.getPiece() instanceof King)
					destinationlist=filterdestination(destinationlist,c);
				else
				{
					if(boardState[getKing(chance).getX()][getKing(chance).getY()].isCheck())
						destinationlist = new ArrayList<Cell>(filterdestination(destinationlist,c));
					else if(destinationlist.isEmpty()==false && willkingbeindanger(c,destinationlist.get(0)))
						destinationlist.clear();
				}
				highlightdestinations(destinationlist);
			}
		}
		if(c.getPiece()!=null && c.getPiece() instanceof King)
		{
			((King)c.getPiece()).setX(c.x);
			((King)c.getPiece()).setY(c.y);
		}
			
		}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub		
	}
	
	
}

