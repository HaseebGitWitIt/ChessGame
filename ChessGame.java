
/**
 * Use to initialize the game and also return all the pieces, and the board.
 * 
 * @author Haseeb Khan
 * @version November 2
 */
public class ChessGame
{
    //Instance variables
    private ChessBoard board;
    
    //Player 1
    private ChessPiece oknight;
    private ChessPiece oknight2;
    private ChessPiece obishop;
    private ChessPiece obishop2;
    private ChessPiece oqueen;
    private ChessPiece oking;
    private ChessPiece opawn;
    private ChessPiece opawn2;
    private ChessPiece opawn3;
    private ChessPiece opawn4;
    private ChessPiece opawn5;
    private ChessPiece opawn6;
    private ChessPiece opawn7;
    private ChessPiece opawn8;
    private ChessPiece orook;
    private ChessPiece orook2;
    
    //Player 2
    private ChessPiece tknight;
    private ChessPiece tknight2;
    private ChessPiece tbishop;
    private ChessPiece tbishop2;
    private ChessPiece tqueen;
    private ChessPiece tking;
    private ChessPiece tpawn;
    private ChessPiece tpawn2;
    private ChessPiece tpawn3;
    private ChessPiece tpawn4;
    private ChessPiece tpawn5;
    private ChessPiece tpawn6;
    private ChessPiece tpawn7;
    private ChessPiece tpawn8;
    private ChessPiece trook;
    private ChessPiece trook2;

    /**
     * Constructor which creates pieces of chess, and places them on board
     */
    public ChessGame() 
    {
        //Initialize instance variables
        board = new ChessBoard();
        
        //Player 1
        oknight = new Knight("Player 1", new ChessLocation(1,0), this);
        oknight.changeID('N');
        oknight2 = new Knight("Player 1", new ChessLocation(6,0), this);
        oknight2.changeID('N');
        obishop = new Bishop("Player 1", new ChessLocation(2,0), this);
        obishop.changeID('B');
        obishop2 = new Bishop("Player 1", new ChessLocation(5,0), this);
        obishop2.changeID('B');
        oqueen = new Queen("Player 1", new ChessLocation(3,0), this);
        oqueen.changeID('Q');
        oking = new King("Player 1", new ChessLocation(4,0), this);
        oking.changeID('K');
        opawn = new Pawn("Player 1", new ChessLocation(0,1), this);
        opawn.changeID('P');
        opawn2 = new Pawn("Player 1", new ChessLocation(1,1), this);
        opawn2.changeID('P');
        opawn3 = new Pawn("Player 1", new ChessLocation(2,1), this);
        opawn3.changeID('P');
        opawn4 = new Pawn("Player 1", new ChessLocation(3,1), this);
        opawn4.changeID('P');
        opawn5 = new Pawn("Player 1", new ChessLocation(4,1), this);
        opawn5.changeID('P');
        opawn6 = new Pawn("Player 1", new ChessLocation(5,1), this);
        opawn6.changeID('P');
        opawn7 = new Pawn("Player 1", new ChessLocation(6,1), this);
        opawn7.changeID('P');
        opawn8 = new Pawn("Player 1", new ChessLocation(7,1), this);
        opawn8.changeID('P');
        orook = new Rook("Player 1", new ChessLocation(0,0), this);
        orook.changeID('R');
        orook2 = new Rook("Player 1", new ChessLocation(7,0), this);
        orook2.changeID('R');
        
        //Player 2
        tknight = new Knight("Player 2", new ChessLocation(1,7), this);
        tknight.changeID('n');
        tknight2 = new Knight("Player 2", new ChessLocation(6,7), this);
        tknight2.changeID('n');
        tbishop = new Bishop("Player 2", new ChessLocation(2,7), this);
        tbishop.changeID('b');
        tbishop2 = new Bishop("Player 2", new ChessLocation(5,7), this);
        tbishop2.changeID('b');
        tqueen = new Queen("Player 2", new ChessLocation(3,7), this);
        tqueen.changeID('q');
        tking = new King("Player 2", new ChessLocation(4,7), this);
        tking.changeID('k');
        tpawn = new Pawn("Player 2", new ChessLocation(0,6), this);
        tpawn.changeID('p');
        tpawn2 = new Pawn("Player 2", new ChessLocation(1,6), this);
        tpawn2.changeID('p');
        tpawn3 = new Pawn("Player 2", new ChessLocation(2,6), this);
        tpawn3.changeID('p');
        tpawn4 = new Pawn("Player 2", new ChessLocation(3,6), this);
        tpawn4.changeID('p');
        tpawn5 = new Pawn("Player 2", new ChessLocation(4,6), this);
        tpawn5.changeID('p');
        tpawn6 = new Pawn("Player 2", new ChessLocation(5,6), this);
        tpawn6.changeID('p');
        tpawn7 = new Pawn("Player 2", new ChessLocation(6,6), this);
        tpawn7.changeID('p');
        tpawn8 = new Pawn("Player 2", new ChessLocation(7,6), this);
        tpawn8.changeID('p');
        trook = new Rook("Player 2", new ChessLocation(0,7), this);
        trook.changeID('r');
        trook2 = new Rook("Player 2", new ChessLocation(7,7), this);
        trook2.changeID('r');
    }


    /**
     * Method used to return board
     * 
     * @param   board   Stores the board
     * @return  board
     */
    public ChessBoard returnBoard()
    {
        return board;
    }
    /**
     * Method used to return king
     * 
     * @param   king   Stores the king
     * @return  oking
     */
    public ChessPiece oreturnKing()
    {
        return oking;
    }
    /**
     * Method used to return king
     * 
     * @param   king   Stores the king
     * @return  tking
     */
    public ChessPiece treturnKing()
    {
        return tking;
    }
    
   
//     /**
//      * Method used to return knight
//      * 
//      * @param   knight   Stores the knight
//      * @return  knight
//      */
//     public ChessPiece oreturnKnight()//Return the piece
//     {
//         return oknight;
//     }
//     
//     /**
//      * Method used to return knight2
//      * 
//      * @param   knight2   Stores the knight
//      * @return  knight2
//      */
//     public ChessPiece oreturnKnight2()//Return the piece
//     {
//         return oknight2;
//     }
//     
//     /**
//      * Method used to return bishop
//      * 
//      * @param   bishop   Stores the bishop
//      * @return  bishop
//      */
//     public ChessPiece oreturnBishop()//Return the piece
//     {
//         return obishop;
//     }
//     
//     /**
//      * Method used to return bishop2
//      * 
//      * @param   bishop2   Stores the bishop
//      * @return  bishop2
//      */
//     public ChessPiece oreturBishop2()//Return the piece
//     {
//         return obishop2;
//     }
//     
//     /**
//      * Method used to return queen
//      * 
//      * @param   queen   Stores the queen
//      * @return  queen
//      */
//     public ChessPiece oreturnQueen()//Return the piece
//     {
//         return oqueen;
//     }
//     
//     /**
//      * Method used to return king
//      * 
//      * @param   king   Stores the king
//      * @return  king
//      */
//     public ChessPiece oreturnKing()//Return the piece
//     {
//         return oking;
//     }
//     
//     /**
//      * Method used to return pawn
//      * 
//      * @param   pawn   Stores the pawn
//      * @return  pawn
//      */
//     public ChessPiece oreturnPawn()//Return the piece
//     {
//         return opawn;
//     }
//     
//     /**
//      * Method used to return pawn2
//      * 
//      * @param   pawn2  Stores the pawn
//      * @return  pawn2
//      */
//     public ChessPiece oreturnPawn2()//Return the piece
//     {
//         return opawn2;
//     }
//     
//     /**
//      * Method used to return pawn3
//      * 
//      * @param   pawn3   Stores the pawn
//      * @return  pawn3
//      */
//     public ChessPiece oreturnPawn3()//Return the piece
//     {
//         return opawn3;
//     }
//     
//     /**
//      * Method used to return pawn4
//      * 
//      * @param   pawn4   Stores the pawn
//      * @return  pawn4
//      */
//     public ChessPiece oreturnPawn4()//Return the piece
//     {
//         return opawn4;
//     }
//     
//     /**
//      * Method used to return pawn5
//      * 
//      * @param   pawn5   Stores the pawn
//      * @return  pawn5
//      */
//     public ChessPiece oreturnPawn5()//Return the piece
//     {
//         return opawn5;
//     }
//     
//     /**
//      * Method used to return pawn6
//      * 
//      * @param   pawn6   Stores the pawn
//      * @return  pawn6
//      */
//     public ChessPiece oreturnPawn6()//Return the piece
//     {
//         return opawn6;
//     }
//     
//     /**
//      * Method used to return pawn7
//      * 
//      * @param   pawn7   Stores the pawn
//      * @return  pawn7
//      */
//     public ChessPiece oreturnPawn7()//Return the piece
//     {
//         return opawn7;
//     }
//     
//     /**
//      * Method used to return pawn8
//      * 
//      * @param   pawn8   Stores the pawn
//      * @return  pawn8
//      */
//     public ChessPiece oreturnPawn8()//Return the piece
//     {
//         return opawn8;
//     }
//     
//     /**
//      * Method used to return rook
//      * 
//      * @param   rook   Stores the rook
//      * @return  rook
//      */
//     public ChessPiece oreturnRook()//Return the piece
//     {
//         return orook;
//     }
//     
//     /**
//      * Method used to return rook2
//      * 
//      * @param   rook2   Stores the rook
//      * @return  rook2
//      */
//     public ChessPiece oreturnRook2()//Return the piece
//     {
//         return orook2;
//     }
//     
//     /**
//      * Method used to return knight
//      * 
//      * @param   knight   Stores the knight
//      * @return  knight
//      */
//     public ChessPiece treturnKnight()//Return the piece
//     {
//         return tknight;
//     }
//     
//     /**
//      * Method used to return knight2
//      * 
//      * @param   knight2   Stores the knight
//      * @return  knight2
//      */
//     public ChessPiece treturnKnight2()//Return the piece
//     {
//         return tknight2;
//     }
//     
//     /**
//      * Method used to return bishop
//      * 
//      * @param   bishop   Stores the bishop
//      * @return  bishop
//      */
//     public ChessPiece treturnBishop()//Return the piece
//     {
//         return tbishop;
//     }
//     
//     /**
//      * Method used to return bishop2
//      * 
//      * @param   bishop2   Stores the bishop
//      * @return  bishop2
//      */
//     public ChessPiece treturBishop2()//Return the piece
//     {
//         return tbishop2;
//     }
//     
//     /**
//      * Method used to return queen
//      * 
//      * @param   queen   Stores the queen
//      * @return  queen
//      */
//     public ChessPiece treturnQueen()//Return the piece
//     {
//         return tqueen;
//     }
//     
//     /**
//      * Method used to return king
//      * 
//      * @param   king   Stores the king
//      * @return  king
//      */
//     public ChessPiece treturnKing()//Return the piece
//     {
//         return tking;
//     }
//     
//     /**
//      * Method used to return pawn
//      * 
//      * @param   pawn   Stores the pawn
//      * @return  pawn
//      */
//     public ChessPiece treturnPawn()//Return the piece
//     {
//         return tpawn;
//     }
//     
//     /**
//      * Method used to return pawn2
//      * 
//      * @param   pawn2  Stores the pawn
//      * @return  pawn2
//      */
//     public ChessPiece treturnPawn2()//Return the piece
//     {
//         return tpawn2;
//     }
//     
//     /**
//      * Method used to return pawn3
//      * 
//      * @param   pawn3   Stores the pawn
//      * @return  pawn3
//      */
//     public ChessPiece treturnPawn3()//Return the piece
//     {
//         return tpawn3;
//     }
//     
//     /**
//      * Method used to return pawn4
//      * 
//      * @param   pawn4   Stores the pawn
//      * @return  pawn4
//      */
//     public ChessPiece treturnPawn4()//Return the piece
//     {
//         return tpawn4;
//     }
//     
//     /**
//      * Method used to return pawn5
//      * 
//      * @param   pawn5   Stores the pawn
//      * @return  pawn5
//      */
//     public ChessPiece treturnPawn5()//Return the piece
//     {
//         return tpawn5;
//     }
//     
//     /**
//      * Method used to return pawn6
//      * 
//      * @param   pawn6   Stores the pawn
//      * @return  pawn6
//      */
//     public ChessPiece treturnPawn6()//Return the piece
//     {
//         return tpawn6;
//     }
//     
//     /**
//      * Method used to return pawn7
//      * 
//      * @param   pawn7   Stores the pawn
//      * @return  pawn7
//      */
//     public ChessPiece treturnPawn7()//Return the piece
//     {
//         return tpawn7;
//     }
//     
//     /**
//      * Method used to return pawn8
//      * 
//      * @param   pawn8   Stores the pawn
//      * @return  pawn8
//      */
//     public ChessPiece treturnPawn8()//Return the piece
//     {
//         return tpawn8;
//     }
//     
//     /**
//      * Method used to return rook
//      * 
//      * @param   rook   Stores the rook
//      * @return  rook
//      */
//     public ChessPiece treturnRook()//Return the piece
//     {
//         return trook;
//     }
//     
//     /**
//      * Method used to return rook2
//      * 
//      * @param   rook2   Stores the rook
//      * @return  rook2
//      */
//     public ChessPiece treturnRook2()//Return the piece
//     {
//         return trook2;
//     }
    
}
