import javax.swing.JOptionPane;
import java.lang.*;
import java.util.ArrayList;
/**
* This class stores all the information regarding the chess piece. Also when the user tries to make a move, a moveTo is called which checks if the move is eligible, 
 * calls the board class and removes the piece from the original position to place it at the new postion.
 * @author Haseeb Khan
 * @version November 2
 */
public class Knight extends ChessPiece
{
    //Instance variables
    private String pieceOwner;
    private ChessLocation initialPlace;
    private ChessGame boardGame;
    private ChessBoard board;

    /**
     * Constructor for objects of the specific piece class
     */
    public Knight(String player, ChessLocation initialLocation, ChessGame game) 
    {
        //Initialize instance variables
        super(player, initialLocation, game);
        board = game.returnBoard();
        //initialPlace = initialLocation;
        //super.changeID('N');
    }

    /**
     * Method used to check if move is legal, and then move 
     * 
     * @param  destination   Stores desired location of the piece 
     */
    public boolean moveTo(ChessLocation destination) 
    {
        initialPlace = super.getLocation();
        
        if (destination.returnCol() > 7 || destination.returnRow() > 7 || destination.returnCol() < 0 || destination.returnRow() < 0 ){
            JOptionPane.showMessageDialog(null, "A Knight can't move there!");
            return false;
        } else if ((destination.returnCol() == (initialPlace.returnCol() + 2) || destination.returnCol() == (initialPlace.returnCol() - 2)) && (destination.returnRow() == (initialPlace.returnRow() + 1) || destination.returnRow() == (initialPlace.returnRow() - 1)) && board.getPieceAt(destination) == null ) {
            /*board.removePiece(initialPlace);
            board.placePieceAt(this, destination);
            super.setLocation(destination);*/
            super.moveTo(destination);
            return true;
            
        } else if ((destination.returnCol() == (initialPlace.returnCol() + 1) || destination.returnCol() == (initialPlace.returnCol() - 1)) && (destination.returnRow() == (initialPlace.returnRow() + 2) || destination.returnRow() == (initialPlace.returnRow() - 2)) && board.getPieceAt(destination) == null ) {
            /*board.removePiece(initialPlace);
            board.placePieceAt(this, destination);
            super.setLocation(destination);*/
            super.moveTo(destination);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A Knight can't move there!");
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
        int x;
        int y;
        
        //2 up, 1 right
        x = row + 1;
        y = col + 2;
        if(x <= 7 && y <= 7) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);

            addThreateningLocations.add(checkLocation);
        }
        
        
        //1 up, 2 right
        x = row + 2;
        y = col + 1;
        if(x <= 7 && y <= 7) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);


            addThreateningLocations.add(checkLocation);
            

        }
        
        //2 right, 1 down
        x = row + 2;
        y = col - 1;
        if(x <= 7 && y >= 0) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);

            addThreateningLocations.add(checkLocation);
        }
        
        //2 down, 1 right
        x = row + 1;
        y = col - 2;
        if(x <= 7 && y >= 0) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);
            addThreateningLocations.add(checkLocation);
        }
        
        //2 up, 1 left
        x = row - 1;
        y = col + 2;
        if(x >= 0 && y <= 7) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);
            addThreateningLocations.add(checkLocation);
        }
        
        
        //1 up, 2 left
        x = row - 2;
        y = col + 1;
        if(x >= 0 && y <= 7) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);


           addThreateningLocations.add(checkLocation);
            

        }
        
        //2 left, 1 down
        x = row - 2;
        y = col - 1;
        if(x >= 0 && y >= 0) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);
 
            addThreateningLocations.add(checkLocation);
        }
        
        //2 down, 1 left
        x = row - 1;
        y = col - 2;
        if(x >= 0 && y >= 0) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);


            addThreateningLocations.add(checkLocation);
        }
        
        super.newThreateningLocation(addThreateningLocations);
    }
    

}
