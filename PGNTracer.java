public class PGNTracer {
	
    private ChessBoard chessBoard;
    
    public PGNTracer() {
        chessBoard = new ChessBoard(); 
    }
    
    public enum Piece {
        PAWN, KING, QUEEN, ROOKS, BISHOP, KNIGHT;
    }
    
    public void makeWhiteMove(String move) {
        int posi;
        int posj;
        int posNewi;
        int posNewj;
        
        if(!isAmbiguous()){
            posNewi = getRowIndex(move);
            posNewj = getColumnIndex(move);
            if(findPiece(move)==Piece.PAWN){
                
                //Itereate through all black pawns
                for(int i = 1; i < 9; i++){
                    posi =  chessBoard.pieceToIndex.get("p"+i)[0];
                    posj =  chessBoard.pieceToIndex.get("p"+i)[1];
                    if(chessBoard.isValidPawnMove(posi, posj, posNewi, posNewj)){    
                        chessBoard.updateChessBoard(posi, posj, posNewi , posNewj );
                    }
                    
                }
            }
        }
    }
    
    private boolean isAmbiguous(){
        return false;
    }
    
    private Piece findPiece(String move){
        char firstChar = move.charAt(0);
        if (firstChar == 'O'){
            return null;
        }
        else if (firstChar == 'K'){
            return Piece.KING;
        }
        else if (firstChar == 'Q'){
            return Piece.QUEEN;
        }
        else if (firstChar == 'R'){
            return Piece.ROOKS;
        }
        else if (firstChar == 'N'){
            return Piece.KNIGHT;
        }
        else if (firstChar == 'B'){
            return Piece.BISHOP;
        }
        else
            return Piece.PAWN;
    }

    public void displayBoard() {
		chessBoard.printBoard();

	}
    public int  getColumnIndex(String move) {
		
		return move.charAt(0) - 'a';
		
    }
    
    public int getRowIndex(String pgnMove) {
        return 8 - Integer.parseInt(""+pgnMove.charAt(1));
    }
    
    
}
