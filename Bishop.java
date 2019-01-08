import javax.swing.JOptionPane;
import java.lang.*;
import java.util.ArrayList;
/**
* This class stores all the information regarding the chess piece. Also when the user tries to make a move, a moveTo is called which checks if the move is eligible, 
 * calls the board class and removes the piece from the original position to place it at the new postion.
 * @author Haseeb Khan
 * @version November 2
 */
public class Bishop extends ChessPiece
{
    //Instance variables
    private String pieceOwner;
    private ChessLocation initialPlace;
    private ChessGame boardGame;
    private ChessBoard board;

    /**
     * Constructor for objects of the specific piece class
     */
    public Bishop(String player, ChessLocation initialLocation, ChessGame game) 
    {
        //Initialize instance variables
        super(player, initialLocation, game);
        board = game.returnBoard();
        //super.changeID('B');
    }

    /**
     * Method used to check if move is legal, and then move by calling super class moveTo
     * 
     * @param  destination   Stores desired location of the piece 
     */
    public boolean moveTo(ChessLocation destination) //Check if user input is valid and remove old piece and place new piece in given location
    {
        initialPlace = super.getLocation();
        if (super.checkLineOfSight(initialPlace, destination)) {
            if (destination.returnCol() > 7 || destination.returnRow() > 7 || destination.returnCol() < 0 || destination.returnRow() < 0 ){
                JOptionPane.showMessageDialog(null, "A Bishop can't move there!");
                return false;
            }else if (destination.returnRow() == initialPlace.returnRow() && destination.returnCol() == initialPlace.returnCol()) {
                JOptionPane.showMessageDialog(null, "A Bishop can't move there!");
            }else if (Math.abs(((destination.returnRow() - initialPlace.returnRow()) / (destination.returnCol() - initialPlace.returnCol()))) == 1) {
                /*board.removePiece(initialPlace);
                board.placePieceAt(this, destination);
                super.setLocation(destination);*/
                super.moveTo(destination);
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "A Bishop can't move there!");
                return false;
            }
        }else {
            JOptionPane.showMessageDialog(null, "Invalid move");
            return false;
        }
        return false;
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
        
        //Diagonal Right Up
        x = row + 1;
        y = col + 1;
        while(x <= 7 && y <= 7) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);

            if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
            x++;
            y++;
        }
        
        
        //Diagonal Right Down
        x = row + 1;
        y = col - 1;
        while(x <= 7 && y >= 0) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);

            if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
            
            x++;
            y--;
        }
        
        //Diagonal Left Up
        x = row - 1;
        y = col + 1;
        while(x >= 0 && y <= 7) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);

            if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
            x--;
            y++;
        }
        
        //Diagonal Left Down
        x = row - 1;
        y = col - 1;
        while(x >= 0 && y >= 0) {
            
            ChessLocation checkLocation = new ChessLocation(x, y);

            if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
            x--;
            y--;
        }
        
        super.newThreateningLocation(addThreateningLocations);
    }
    

}
