import javax.swing.JOptionPane;
import java.lang.*;
import java.util.ArrayList;
/**
* This class stores all the information regarding the chess piece. Also when the user tries to make a move, a moveTo is called which checks if the move is eligible, 
 * calls the board class and removes the piece from the original position to place it at the new postion.
 * @author Haseeb Khan
 * @version November 2
 */
public class King extends ChessPiece
{
    //Instance variables
    private String pieceOwner;
    private ChessLocation initialPlace;
    private ChessGame boardGame;
    private ChessBoard board;

    /**
     * Constructor for objects of the specific piece class
     */
    public King(String player, ChessLocation initialLocation, ChessGame game) 
    {
        //Initialize instance variables
        super(player, initialLocation, game);
        board = game.returnBoard();
        //super.changeID('K');
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
                JOptionPane.showMessageDialog(null, "A King can't move there!");
                return false;
            }else if (((Math.abs(destination.returnCol() - initialPlace.returnCol())) == 1) && (destination.returnRow() == initialPlace.returnRow()))  {
                    /*board.removePiece(initialPlace);
                    board.placePieceAt(this, destination);
                    super.setLocation(destination);*/
                    if (this.locationInDanger(destination) == null){
                        super.moveTo(destination);
                        return true;
                    } else {
                        System.out.println("You're putting your king in danger!");
                        System.out.println("Piece: " + locationInDanger(destination).getID() + " X-Coordinate: " + locationInDanger(destination).getLocation().returnRow() + " Y-Coordinate: " + locationInDanger(destination).getLocation().returnCol());
                    }
                    
            }else if (((Math.abs(destination.returnRow() - initialPlace.returnRow())) == 1) && (destination.returnCol() == initialPlace.returnCol()) ) {
                    /*board.removePiece(initialPlace);
                    board.placePieceAt(this, destination);
                    super.setLocation(destination);*/
                    if (this.locationInDanger(destination) == null){
                        super.moveTo(destination);
                        return true;
                    } else {
                        System.out.println("You're putting your king in danger!");
                        System.out.println("Piece: " + locationInDanger(destination).getID() + " X-Coordinate: " + locationInDanger(destination).getLocation().returnRow() + " Y-Coordinate: " + locationInDanger(destination).getLocation().returnCol());
                    }
            }else if (((Math.abs(destination.returnCol() - initialPlace.returnCol())) == 1) && ((Math.abs(destination.returnRow() - initialPlace.returnRow())) == 1)){
                    if(Math.abs(((destination.returnRow() - initialPlace.returnRow()) / (destination.returnCol() - initialPlace.returnCol()))) == 1) {
                        /*board.removePiece(initialPlace);
                        board.placePieceAt(this, destination);
                        super.setLocation(destination);*/
                        if (this.locationInDanger(destination) == null){
                            super.moveTo(destination);
                            return true;
                        } else {
                            System.out.println("You're putting your king in danger!");
                            System.out.println("Piece: " + locationInDanger(destination).getID() + " X-Coordinate: " + locationInDanger(destination).getLocation().returnRow() + " Y-Coordinate: " + locationInDanger(destination).getLocation().returnCol());
                        }
                    }
            }else {
                JOptionPane.showMessageDialog(null, "A King can't move there!");
                return false;
            }
        } else {
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
        //Check left
        int b = row;
        b--;
        if(b >= 0) {
            ChessLocation checkLocation = new ChessLocation(b,col);
            addThreateningLocations.add(checkLocation);
        }
        
        
        //Check right
         b = row;
        b++;
        if(b <= 7) {
            ChessLocation checkLocation = new ChessLocation(b,col);

            addThreateningLocations.add(checkLocation);
        }
        
        
        //Check up
         b = col;
        b++;
        if(b <= 7) {
            ChessLocation checkLocation = new ChessLocation(row,b);
            addThreateningLocations.add(checkLocation);
        }
        
        
        //Check down
         b = col;
        b--;
        if(b >= 0) {
            ChessLocation checkLocation = new ChessLocation(row,b);
            addThreateningLocations.add(checkLocation);
        }
        
        
        //Diagonal Right Up
        x = row;
        y = col;
        x++;
        y++;
        if(x <= 7 && y <= 7) {

            ChessLocation checkLocation = new ChessLocation(x, y);

            addThreateningLocations.add(checkLocation);
        }
        
        
        //Diagonal Right Down
        x = row;
        y = col;
        x++;
        y--;
        if(x <= 7 && y >= 0) {

            ChessLocation checkLocation = new ChessLocation(x, y);

            addThreateningLocations.add(checkLocation);
        }
        
        //Diagonal Left Up
        x = row;
        y = col;
        x--;
        y++;
        if(x >= 0 && y <= 7) {

            ChessLocation checkLocation = new ChessLocation(x, y);

            addThreateningLocations.add(checkLocation);
        }
        
        //Diagonal Left Down
        x = row;
        y = col;
        x--;
        y--;
        if(x >= 0 && y >= 0) {

            ChessLocation checkLocation = new ChessLocation(x, y);

            addThreateningLocations.add(checkLocation);
        }

        super.newThreateningLocation(addThreateningLocations);
    }
    
     /**
     * Method used to store all the  pieces threatening the king
     * 
     * @return  Array list of pieces
     */
    protected ChessPiece locationInDanger(ChessLocation destinationLocation) {
        for (int a = 0; a <= 7; a++) {
            for(int b = 0; b <= 7; b++) {
                ChessLocation checkLocation = new ChessLocation(a,b);
                if (board.isPieceAt(checkLocation)) {
                    ChessPiece checkPiece = board.getPieceAt(checkLocation);
                    checkPiece.updateThreateningLocation(checkPiece.getLocation());
                    if((checkPiece.returnThreateningLocation().contains(destinationLocation) && !(checkPiece.getPlayer().equals(super.getPlayer())))) {
                        return checkPiece;
                    }
                }
            }
        }
        

        
        return null;
    }
    
     /**
     * Method used to check if the king can move anywhere
     * 
     * @return  True if king can move somewhere, false otherwise 
     */
    protected boolean anyMovesLeft() {
        initialPlace = super.getLocation();
        
        int x = initialPlace.returnRow();
        int y = initialPlace.returnCol();
        x++;
        y++;
        ChessLocation checkLocation = new ChessLocation(x,y);
        if(this.locationInDanger(checkLocation) == null) {
            x = initialPlace.returnRow();
            y = initialPlace.returnCol();
            x--;
            y--;
            checkLocation = new ChessLocation(x,y);
            if(this.locationInDanger(checkLocation) == null) {
                x = initialPlace.returnRow();
                y = initialPlace.returnCol();
                x++;
                y--;
                checkLocation = new ChessLocation(x,y);
                if(this.locationInDanger(checkLocation) == null) {
                    x = initialPlace.returnRow();
                    y = initialPlace.returnCol();
                    x--;
                    y++;
                    checkLocation = new ChessLocation(x,y);
                    if(this.locationInDanger(checkLocation) == null) {
                        x = initialPlace.returnRow();
                        y = initialPlace.returnCol();
                        y++;
                        checkLocation = new ChessLocation(x,y);
                        if(this.locationInDanger(checkLocation) == null) {
                            x = initialPlace.returnRow();
                            y = initialPlace.returnCol();
                            y--;
                            checkLocation = new ChessLocation(x,y);
                            if(this.locationInDanger(checkLocation) == null) {
                                x = initialPlace.returnRow();
                                y = initialPlace.returnCol();
                                x++;
                                checkLocation = new ChessLocation(x,y);
                                if(this.locationInDanger(checkLocation) == null) {
                                    if(this.locationInDanger(checkLocation) == null) {
                                        x = initialPlace.returnRow();
                                        y = initialPlace.returnCol();
                                        x--;
                                        checkLocation = new ChessLocation(x,y);
                                        if(this.locationInDanger(checkLocation) == null) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
    
     /**
     * Method used to return list of pieces endangering king
     * 
     * @return  Array of endangering pieces
     */
    protected  ChessPiece check() {
        initialPlace = super.getLocation();
        return(locationInDanger(initialPlace));
    }
}

