public class PGNTracer {
	
    private ChessBoard chessBoard;
    
    public PGNTracer() {
        chessBoard = new chessBoard(); 
    }
    
    public enum Piece {
        PAWN, KING, QUEEN, ROOKS, BISHOP, KNIGHT;
    }
    
    public void makeBlackMove(String move) {
        if(!isAmbiguous()){
            if(findPiece(move)==Piece.PAWN){
                //Itereate through all black pawns
                for(int i = 1; i < 9; i++){
                    if(chessBoard.isValidPawnMove("p"+i, move)){
                        chessBoard.updateChessBoard("p"+i, getRowIndex(move), getColumnIndex(move));
                    }
                }
            }
        }
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
