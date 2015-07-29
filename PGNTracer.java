public class PGNTracer {
    private ChessBoard chessBoard;
    
    public PGNTracer() {
        chessBoard = new chessBoard(); 
    }
    
    public void makeMove(String move) {
        
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
