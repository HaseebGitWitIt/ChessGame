import javax.swing.JOptionPane;
import java.lang.*;
import java.util.ArrayList;
/**
* This class stores all the information regarding the chess piece. Also when the user tries to make a move, a moveTo is called which checks if the move is eligible, 
 * calls the board class and removes the piece from the original position to place it at the new postion.
 * @author Haseeb Khan
 * @version November 2
 */
public class Pawn extends ChessPiece
{
    //Instance variables
    private String pieceOwner;
    private ChessLocation initialPlace;
    private ChessGame boardGame;
    private ChessBoard board;
    private boolean firstMove = false;
    /**
     * Constructor for objects of the specific piece class
     */
    public Pawn(String player, ChessLocation initialLocation, ChessGame game) 
    {
        //Initialize instance variables
        super(player, initialLocation, game);
        board = game.returnBoard();
        //super.changeID('P');
    }

    /**
     * Method used to check if move is legal, and then move by calling super class moveTo
     * 
     * @param  destination   Stores desired location of the piece 
     */
    public boolean moveTo(ChessLocation destination) //Check if user input is valid and remove old piece and place new piece in given location
    {
        initialPlace = super.getLocation();
        boolean flag = false;
        boolean move = true;
        if(board.isPieceAt(destination)) {
            ChessPiece checkPiece = board.getPieceAt(destination);
            if (!(checkPiece.getPlayer().equalsIgnoreCase(super.getPlayer()))) {
                move = false;
            }
        }
        if(board.isPieceAt(destination)) {
            
            ChessPiece checkPiece = board.getPieceAt(destination);
            if(super.getPlayer().equalsIgnoreCase("Player 1")) {
                if (checkPiece.getPlayer().equalsIgnoreCase("Player 2")) {
                    flag = true;
                }
            }
            if(super.getPlayer().equalsIgnoreCase("Player 2")) {
                if (checkPiece.getPlayer().equalsIgnoreCase("Player 1")) {
                    flag = true;
                }
            }
        }
        if (super.checkLineOfSight(initialPlace, destination)) {
            if (destination.returnCol() > 7 || destination.returnRow() > 7 || destination.returnCol() < 0 || destination.returnRow() < 0 ){
                JOptionPane.showMessageDialog(null, "A Pawn can't move there!");
                return false;
            }else if (destination.returnCol() == (initialPlace.returnCol() + 2) && (destination.returnRow() == initialPlace.returnRow()) && firstMove == false && move && super.getPlayer().equalsIgnoreCase("Player 1")) {
                firstMove = true;
                /*board.removePiece(initialPlace);
                board.placePieceAt(this, destination);
                super.setLocation(destination);*/
                super.moveTo(destination);
                return true;
            } else if (destination.returnCol() == (initialPlace.returnCol() + 1) && (destination.returnRow() == initialPlace.returnRow()) && move && super.getPlayer().equalsIgnoreCase("Player 1")) {
                firstMove = true;
                /*board.removePiece(initialPlace);
                board.placePieceAt(this, destination);
                super.setLocation(destination);*/
                super.moveTo(destination);
                return true;
            }else if ((destination.returnCol() - initialPlace.returnCol() == 1) && (Math.abs(destination.returnRow() - initialPlace.returnRow()) == 1) && (flag) && super.getPlayer().equalsIgnoreCase("Player 1")) {
                firstMove = true;
                /*board.removePiece(initialPlace);
                board.placePieceAt(this, destination);
                super.setLocation(destination);*/
                super.moveTo(destination);
                return true;
             }else if (destination.returnCol() == (initialPlace.returnCol() - 2) && (destination.returnRow() == initialPlace.returnRow()) && firstMove == false && move && super.getPlayer().equalsIgnoreCase("Player 2")) {
                firstMove = true;
                /*board.removePiece(initialPlace);
                board.placePieceAt(this, destination);
                super.setLocation(destination);*/
                super.moveTo(destination);
                return true;
            } else if (destination.returnCol() == (initialPlace.returnCol() - 1) && (destination.returnRow() == initialPlace.returnRow()) && move && super.getPlayer().equalsIgnoreCase("Player 2")) {
                firstMove = true;
                /*board.removePiece(initialPlace);
                board.placePieceAt(this, destination);
                super.setLocation(destination);*/
                super.moveTo(destination);
                return true;
            }else if ((destination.returnCol() - initialPlace.returnCol() == -1) && (Math.abs(destination.returnRow() - initialPlace.returnRow()) == 1) && (flag) && super.getPlayer().equalsIgnoreCase("Player 2")) {
                firstMove = true;
                /*board.removePiece(initialPlace);
                board.placePieceAt(this, destination);
                super.setLocation(destination);*/
                super.moveTo(destination);
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "A Pawn can't move there!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid move");
            return false;
        }
    }
    
        /**
     * Method used to update threatning locations
     * 
     * @param   newLocation    Stores the new location
     */
    protected  void updateThreateningLocation(ChessLocation currentLocation){
        ArrayList<ChessLocation> addThreateningLocations = new ArrayList<ChessLocation>();
        int row = currentLocation.returnRow();
        int col = currentLocation.returnCol();
        
        if(super.getPlayer().equalsIgnoreCase("Player 1")) {
            //Check up
            int a = row;
            int b = col;
            a++;
            b++;
            if(b <= 7 && a<= 7) {
                ChessLocation checkLocation = new ChessLocation(a,b);
  
                addThreateningLocations.add(checkLocation);
            }
            a = row;
            b = col;
            a--;
            b++;
            if(b <= 7 && a >= 0) {
                ChessLocation checkLocation = new ChessLocation(a,b);
  
                addThreateningLocations.add(checkLocation);
            }
        }
        
        if (super.getPlayer().equalsIgnoreCase("Player 2")) {
            //Check down
            int a = row;
            int b = col;
            a--;
            b--;
            if(b >= 0 && a >= 0) {
                ChessLocation checkLocation = new ChessLocation(a,b);
  
                addThreateningLocations.add(checkLocation);
            }
            a = row;
            b = col;
            a++;
            b--;
            if(a <= 7 && b >= 0) {
                ChessLocation checkLocation = new ChessLocation(a,b);
  
                addThreateningLocations.add(checkLocation);
            }
        }
        
        super.newThreateningLocation(addThreateningLocations);
    }
    

   
}
        

