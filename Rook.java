import javax.swing.JOptionPane;
import java.lang.*;
import java.util.ArrayList;
/**
* This class stores all the information regarding the chess piece. Also when the user tries to make a move, a moveTo is called which checks if the move is eligible, 
 * calls the board class and removes the piece from the original position to place it at the new postion.
 * @author Haseeb Khan
 * @version November 2
 */
public class Rook extends ChessPiece
{
    //Instance variables
    private String pieceOwner;
    private ChessLocation initialPlace;
    private ChessGame boardGame;
    private ChessBoard board;

    /**
     * Constructor for objects of the specific piece class
     */
    public Rook(String player, ChessLocation initialLocation, ChessGame game) 
    {
        //Initialize instance varaibles
        super(player, initialLocation, game);
        board = game.returnBoard();
        //super.changeID('R');
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
                JOptionPane.showMessageDialog(null, "A Rook can't move there!");
                return false;
            } else if ((destination.returnCol() == initialPlace.returnCol()) && (destination.returnRow() != initialPlace.returnRow()) ) {
                    /*board.removePiece(initialPlace);
                    board.placePieceAt(this, destination);
                    super.setLocation(destination);*/
                    super.moveTo(destination);
                    return true;
            } else if ((destination.returnCol() != initialPlace.returnCol()) && (destination.returnRow() == initialPlace.returnRow())) {
                    /*board.removePiece(initialPlace);
                    board.placePieceAt(this, destination);
                    super.setLocation(destination);*/
                    super.moveTo(destination);
                    return true;
            }else {
                JOptionPane.showMessageDialog(null, "A Rook can't move there!");
                return false;
            }
        }else {
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
        //Check left
        for(int a = row - 1; a >= 0; a--) {
            ChessLocation checkLocation = new ChessLocation(a,col);
            if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
        }
        
        //Check right
        for(int a = row + 1; a <= 7; a++) {
            ChessLocation checkLocation = new ChessLocation(a,col);
            if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
        }
        
        //Check up
        for(int a = col + 1; a <= 7; a++) {
            ChessLocation checkLocation = new ChessLocation(row,a);
            if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
        }
        
        //Check down
        for(int a = col - 1; a >= 0; a--) {
            ChessLocation checkLocation = new ChessLocation(row,a);
           if(checkLineOfSight(currentLocation,checkLocation)) {
                    addThreateningLocations.add(checkLocation);
                }
        }
        

        super.newThreateningLocation(addThreateningLocations);
    }
    

}
