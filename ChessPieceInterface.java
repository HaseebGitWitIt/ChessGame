
/**
 * Interface for chess piece.
 * 
 * @author Haseeb Khan
 * @version November 20th
 */
public interface ChessPieceInterface
{
    /**
     * Interface where returns boolean moveTo
     * 
     * @param  location    Variable containing location of chess piece
     * @return        true if can move there false if cannot 
     */
    public boolean moveTo(ChessLocation location);
}
