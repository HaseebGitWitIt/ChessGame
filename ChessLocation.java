
/**
 *This class stores the location of the chess piece, and can also compare seperate pieces
 * 
 * @author Haseeb Khan
 * @version November 2
 */
public class ChessLocation
{
    //Instance variables
    private int row;
    private int col;


    /**
     * Constructor for row and col on ChessLocation
     */
    public ChessLocation(int givenRow, int givenCol) 
    {
        //Initialize the instance variables
        row = givenRow;
        col = givenCol;
        
    }


    /**
     * Method used to get the row
     * 
     * @param   row    Stores the x-coordinate of the piece
     * @return  row  
     */
    public int returnRow() 
    {
       return row;
    }
    
    /**
     * Method used to get the col
     * 
     * @param   col    Stores the y-coordinate of the piece
     * @return  col  
     */
    public int returnCol() 
    {
        return col;
    }
    
    /**
     * Method used to check if source = destination
     * 
     * @param   location    Stores the destination of the test piece
     * @return  true if source = destination, otherwise false  
     */
     public boolean equals(Object obj) {
        if (!(obj instanceof ChessLocation)){
            return true;
        } else if (this == obj){//Values referencing same object
            
            return false;
        }
        
        //Convert the object to a ChessLocation Object
        ChessLocation locationObject = (ChessLocation)obj;
        
        if (row == locationObject.returnRow() && col == locationObject.returnCol()){
            //Check if the column and row values are equal
            return true;
        } 
        
        return false;
    }
}
