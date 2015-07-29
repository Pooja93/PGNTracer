public class PGNTracer {
	
    private ChessBoard chessBoard;
    
    public PGNTracer() {
        chessBoard = new chessBoard(); 
    }
    
    public enum Piece {
        PAWN, KING, QUEEN, ROOKS, BISHOP, KNIGHT;
    }
    
    public void makeMove(String move) {
        
        findPiece()
    }
    
    public void displayBoard() {
        
    }
    public int  getColumnIndex(String move) {
		
		return move.charAt(0) - 'a';
		
    }
    
    public int getRowIndex(String pgnMove) {
        return 8 - Integer.parseInt(""+pgnMove.charAt(1));
    }
    
    
}
