/**
 * ChessBoard creates the chessboard and prints it out with all the pieces on it.
 * Can also get, place and remove pieces.
 * @author Haseeb Khan
 * @version November 5
 */
public class ChessBoard
{
    //Instance variables
    private int row;
    private int col;
    private ChessPiece piece;
    private ChessLocation location;
    
    /**
     * 3-D array of ChessPieces
     */
    ChessPiece[][] board = new ChessPiece[8][8];
    
    /**
     * Constructor which initializes each position of the board to null
     */
    public ChessBoard() 
    {
        for(int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                board[a][b] = null;
            }
        }
    }

     /**
     * Method used to get piece at given location
     *
     * @param   location    Stores the location of where you want to get the piece
     * @param   row Stores the x-coordinate of the location of the piece
     * @param   col Stores the y-coordinate of the location of the piece
     * @return  Piece at location
     */
    public ChessPiece getPieceAt(ChessLocation location) 
    {
        row = location.returnRow();
        col = location.returnCol();
        if (board[row][col] != null) {
            return (board[row][col]);
        } else {
            return null;
        }
    }
    
     /**
     * Boolean to check if piece is there
     *
     * @param   location    Stores the location of where you want to get the piece
     * @param   row Stores the x-coordinate of the location of the piece
     * @param   col Stores the y-coordinate of the location of the piece
     * @return  true if piece there and false if no piece there
     */
    public boolean isPieceAt(ChessLocation location) 
    {
        row = location.returnRow();
        col = location.returnCol();
        if (board[row][col] != null) {
            return true;
        } else {
            return false;
        }
    }
    
     /**
     * Method used to place piece at given location
     * 
     * @param   piece   Stores the piece you would like to store in the given location
     * @param   location    Stores the location of where you want to place the piece
     * @param   row Stores the x-coordinate of where the user wants the piece
     * @param   col Stores the y-coordinate of where the user wants the piece
     */
    public void placePieceAt(ChessPiece piece, ChessLocation location) 
    {       
        row = location.returnRow();
        col = location.returnCol();
        
        //Remove old piece
        if (getPieceAt(location) != null){
            this.removePiece(location);
        }
        //Move piece there
        board[row][col] = piece; 
        
        if (piece.getLocation() != null){
            this.removePiece(piece.getLocation());
        }
        //Change location
        piece.setLocation(location); 
        
        
        
    }
    
    /**
     * Method used to remove piece at given location
     * 
     * @param   location    Stores the location of the piece you want to move
     * @param   row Stores the x-coordinate of the location where the user wants to remove the piece
     * @param   col Stores the y-coordinate of the location where the user wants to remove the piece
     */
    public void removePiece(ChessLocation location) //Remove piece from given location
    {
        row = location.returnRow();
        col = location.returnCol();
        
        board[row][col] = null;
    }
    
    /**
     * Method used to create chess board with all the pieces
     * 
     */
    public void makeBoard() 
    {
        System.out.println("      0   1   2   3   4   5   6   7 ");
        for(int b = 7; b >= 0; b--){
            System.out.println(" ");
            System.out.print(Integer.toString(b) + "    ");
            for(int a = 0; a < board.length; a++){
                if(board[a][b] == null) {
                    System.out.print(" __ ");
                }
                else {
                    System.out.print(" " + board[a][b].getID() + "  ");
                }
            }
            System.out.print("  " + Integer.toString(b));
            System.out.println(" ");
        }
        System.out.println();
        System.out.println("      0   1   2   3   4   5   6   7 ");
    }
}
