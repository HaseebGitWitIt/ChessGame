
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * Game starts here. Features menu with quit etc. and checks if user input is valid. 
 * Takes user input and calls necessary functions to move piece if valid move.
 * @author Haseeb Khan 
 * @version November 5
 */
public class PlayGame
{
     static int a = 1;
    /**
     * Main method which initializes necessary variables, parameters and classes.
     * Takes user input and performs the according action
     * 
     * @param   reader  Get user input
     * @param   userInput   Store the user input
     * @param   sourceRow   Store the x-coordinate of source
     * @param   sourceCol   Store the y-coordinate of source
     * 
     * @param   sourceRow   Store the x-coordinate of destination
     * @param   sourceCol   Store the y-coordinate of destination
     * @param   game    Store ChessGame variable
     * @param   board   Store ChessBoard variable
     * @param   sourceLocation  Store location of piece you want to move
     * @param   destLocation    Store location of where you want to move source piece
     * @param   sourcePiece Store the piece you are moving
     */
    public static void main(String[] args) 
    {
        do {
            //Initialize needed variables
            Scanner reader;
            int sourceRow = 0;
            int sourceCol = 0;
            int destRow = 0;
            int destCol = 0;
            String userInput = null;
            ChessGame game = new ChessGame();
            ChessBoard board = new ChessBoard();
            ChessLocation sourceLocation = new ChessLocation(0, 0);
            ChessLocation destLocation = new ChessLocation(0,0);
            ChessPiece sourcePiece;
            
            //Output intro
            System.out.println("Welcome to Graphical Chess, where we move chess pieces like graph coordinates!");
            System.out.println("For example, if a piece is at (1,3) and you want to move 2 spaces up and 1 space right: ");
            System.out.println("The destination would be (3,4)!");
            
            //Make board
            board = game.returnBoard();
            board.makeBoard();
            
           
            //Continuous loop so you can keep playing
            do { 
                try{
                    System.out.println();
                    
                    //Determine which player is going
                    
                    if(a % 2 == 0) {
                        System.out.println("It's Player 2's turn!");
                    }
                    else {
                        System.out.println("It's Player 1's turn!");
                    }
                  
                    //Get source information

                    System.out.println("Enter 'move', 'quit' or 'restart': ");
                    reader = new Scanner(System.in);
                    userInput = reader.nextLine();
                    if(userInput.equalsIgnoreCase("quit")) {
                        JOptionPane.showMessageDialog(null, "Quitter! You can now close the window.");
                        System.exit(0);
                    } else if(userInput.equalsIgnoreCase("restart")) {
                        JOptionPane.showMessageDialog(null, "You just restart the game!");
                        break;
                    } else if(userInput.equalsIgnoreCase("move")) {
                        //Get the endangered king info things

                        if(a % 2 == 0) {//Player 2
                           if(((King)game.treturnKing()).check() != null) {
                               System.out.println("Your king is in danger!");
                               System.out.println("Piece: " + ((King)game.treturnKing()).check().getID() + " X-Coordinate: " + ((King)game.treturnKing()).check().getLocation().returnRow() + " Y-Coordinate: " + ((King)game.treturnKing()).check().getLocation().returnCol()  );
                            }
                            
                        }
                        else {//Player 1
                            if(((King)game.oreturnKing()).check() != null) {
                               System.out.println("Your king is in danger!");
                               System.out.println("Piece: " + ((King)game.oreturnKing()).check().getID() + " X-Coordinate: " + ((King)game.oreturnKing()).check().getLocation().returnRow() + " Y-Coordinate: " + ((King)game.oreturnKing()).check().getLocation().returnCol()  );
                            }
                        }
                        
 
                        
                        String[]lineVector;
                        System.out.println("Enter the coordinates of the piece you'd like to move like: x,y: ");
                        userInput = reader.nextLine(); 
                        lineVector = userInput.split(",");
                        sourceRow = Integer.parseInt(lineVector[0]);
                        sourceCol = Integer.parseInt(lineVector[1]);
                        
                        System.out.println("Enter the coordinates of the destination you'd like to move to like: x,y: ");
                        userInput = reader.nextLine(); 
                        lineVector = userInput.split(",");
                        destRow = Integer.parseInt(lineVector[0]);
                        destCol = Integer.parseInt(lineVector[1]);

                         

                         
                        //Use source and destination information to correctly move pieces
                        sourceLocation = new ChessLocation(sourceRow, sourceCol);
                        destLocation = new ChessLocation(destRow, destCol);
                        sourcePiece = board.getPieceAt(sourceLocation);
                        sourcePiece.moveTo(destLocation);
                        
                        if(((King)game.treturnKing()).getLocation().equals(destLocation)) {
                             JOptionPane.showMessageDialog(null, "It's over! Player One Wins!");
                        }
                        if(((King)game.oreturnKing()).getLocation().equals(destLocation)) {
                             JOptionPane.showMessageDialog(null, "It's over! Player Two Wins!");
                        }
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Try again!");
                    }
                    board.makeBoard();
                
                //User enters invalid input
               }catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "That is not valid input!");
               }
               
               
               
               
               
            }while(true);
        }while(true);

    }
    

}
