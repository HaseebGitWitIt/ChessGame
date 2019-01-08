import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 * Parent class for all the different pieces on the board.
 * 
 * @Haseeb Khan 
 * @November 5
 */
public abstract class ChessPiece implements ChessPieceInterface
{
    //Instance variables
    private ChessGame boardGame;
    private String player;
    private ChessLocation location;
    private ArrayList<ChessLocation>threateningLocations;
    
    /**
     * Char id is used to store the letter associated with the chess piece
     */
    protected char id;

    /**
     * Constructor for objects of class ChessPiece
     */
    public ChessPiece(String owner, ChessLocation initialLocation, ChessGame game)
    {
        // Initialise instance variables
        player = owner;
        location = null;
        boardGame = game;
        threateningLocations = new ArrayList<ChessLocation>();
        
        game.returnBoard().placePieceAt(this, initialLocation);
    }

  
    /**
     * Method used to move pieces
     * 
     * @param   newLocation Stores the new location user wants to move the piece
     */
    public boolean moveTo(ChessLocation newLocation)
    {
            if ((boardGame.returnBoard().isPieceAt(newLocation) && this.getPlayer().equalsIgnoreCase(boardGame.returnBoard().getPieceAt(newLocation).getPlayer())) || newLocation.returnCol() > 7 || newLocation.returnRow() > 7 || newLocation.returnCol() < 0 || newLocation.returnRow() < 0) {
                JOptionPane.showMessageDialog(null, "Invalid move");
                return false;
                
                
            }else if((PlayGame.a)%2 != 0 && this.getPlayer().equalsIgnoreCase("Player 2")) {
                JOptionPane.showMessageDialog(null, "It's not your turn!");
                return false;
            }else if((PlayGame.a)%2 == 0 && this.getPlayer().equalsIgnoreCase("Player 1")) {
                JOptionPane.showMessageDialog(null, "It's not your turn!");
                return false;
            }else if(checkLineOfSight(location,newLocation)) {
                if((boardGame.returnBoard().getPieceAt(newLocation) == null) || (boardGame.returnBoard().getPieceAt(newLocation).getID() != (this.getID()))) {
                    boardGame.returnBoard().removePiece(location);
                    boardGame.returnBoard().placePieceAt(this, newLocation);
                    this.setLocation(newLocation);
                    PlayGame.a++;
                    return true;
                }
            }
            return false;
    }
    
    /**
     * Method used to see if any piece in the way of desired destination
     * 
     * @param   start   Stores the source location
     * @param   end Stores the destination location
     * @return  true if no piece in the way, false if piece in the way
     */
    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end) { 
        int srow = start.returnRow();
        int scol = start.returnCol();
        int erow = end.returnRow();
        int ecol = end.returnCol();
        if (srow == erow){//Horizontal
            if (scol > ecol) {
                for (int a = (scol - ecol) - 1; a > 0; a--){
                    if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow, scol - a)) != null){
                        return false;
                    }
                }
            } else {
                for (int a = (ecol - scol) - 1; a > 0; a--){
                    if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow, scol + a)) != null){
                        return false;
                    }
                }
            }
        } else if (scol == ecol){
            //Vertical
            if (srow > erow) {
                for (int a = (srow - erow) - 1; a > 0; a--){
                    if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow - a, scol)) != null){
                        return false;
                    }
                }
            } 
            else {
               
                for (int i = (erow - srow) - 1; i > 0; i--){
                    if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow + i, scol)) != null){
                        return(false);
                    }
                }
            }
        } else if (Math.abs(((erow - srow) / (ecol - scol))) == 1) {
            //Diagonal
            if (((erow - srow) / (ecol - scol)) == 1){
                if (srow > erow) {
                    for (int a = (srow - erow) - 1; a > 0; a--){
                        if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow - a, scol - a)) != null){
                            return false;
                        }
                    }
                }
                else {
                    for (int a = (erow - srow) - 1; a > 0; a--){
                        if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow + a, scol + a)) != null){
                            return false;
                        }
                    }
                }
            } else {
                if (srow > erow) {
                    for (int a = (srow - erow) - 1; a > 0; a--){
                        if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow - a, scol + a)) != null){
                            return false;
                        }
                    }
                } 
                else {
                    for (int a = (erow - srow) - 1; a > 0; a--){
                        if (boardGame.returnBoard().getPieceAt(new ChessLocation(srow + a, scol - a)) != null){
                            return false;
                        }
                    }
                }
            }
        } else {
            //Knight
            if ((boardGame.returnBoard().getPieceAt(end) != null) && (boardGame.returnBoard().getPieceAt(end).getPlayer().equals(player))){
                return false;
            }
        }
        return true;
    }      
    
    
    /**
     * Method used to change ID to match piece
     * 
     * @param   label   Character that describes piece
     */
    protected void changeID(char label) { 
        id = label;
    }
    
    /**
     * Method used to get start location of the piece
     * 
     * @param   location    Stores the initial location of the piece
     * @return  location of the piece 
     */
    protected ChessLocation getLocation(){ 
        return location;
    }
    
    protected void setLocation(ChessLocation newLocation) { 
        location = newLocation;
    }
    
    /**
     * Method used to get the ID
     * 
     * @param   id    Stores the character of the specific piece
     * @return  id of the piece 
     */
    public char getID() { //Get piece ID
        return id;
    }
    
    /**
     * Method used to get the owner
     * 
     * @param   player    Stores Player 1 or Player 2
     * @return  Owner of the piece 
     */
    public String getPlayer() {
        return player;
    }
    
    
    /**
     * Method used to update threatning locations
     * 
     * @param   newLocation    Stores the new location
     */
    protected abstract void updateThreateningLocation(ChessLocation currentLocation);
    
    /**
     * Method used to update threatning locations
     * 
     * @param   newLocation    Stores the new location
     */
    public void newThreateningLocation(ArrayList<ChessLocation> newLocations) {
        threateningLocations = newLocations;
    }
    
        
    /**
     * Method used to get the array list
     * 
     * @param   threatningLocation holds all the threatning locations
     * @return  threatningLocations 
     */
    public ArrayList<ChessLocation> returnThreateningLocation() {
        return threateningLocations;
    }
    
    
       
    
}
