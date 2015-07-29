public class PGNTracer {
	
    private ChessBoard chessBoard;
    
    public PGNTracer() {
        chessBoard = new ChessBoard(); 
    }
    
    public enum Piece {
        PAWN, KING, QUEEN, ROOKS, BISHOP, KNIGHT;
    }
    
    public void makeMove(char color, String move) {
        
        int posi;
        int posj;
        int posNewi;
        int posNewj;
        
        if(!isAmbiguous()){
            posNewi = getRowIndex(move);
            posNewj = getColumnIndex(move);
            if(findPiece(move)==Piece.PAWN){
                for(int i = 1; i < 9; i++){
                    if(color == 'W'){
                        posi =  chessBoard.pieceToIndex.get("p"+i)[0];
                        posj =  chessBoard.pieceToIndex.get("p"+i)[1];
                    }
                    else{
                        posi =  chessBoard.pieceToIndex.get("P"+i)[0];
                        posj =  chessBoard.pieceToIndex.get("P"+i)[1];
                    }
                        
                    if(chessBoard.isValidPawnMove(color,posi, posj, posNewi, posNewj)){    
                        chessBoard.updateChessBoard(posi, posj, posNewi , posNewj );
                    }
                    
                }
            }
            else if(findPiece(move)==Piece.KNIGHT){
                    posNewi = getRowIndex(move.substring(1,move.length()));
                    posNewj = getColumnIndex(move.substring(1,move.length()));
                    
                    for(int i = 1; i < 3; i++){
                        if (color == 'W'){
                            posi =  chessBoard.pieceToIndex.get("n"+i)[0];
                            posj =  chessBoard.pieceToIndex.get("n"+i)[1];
                        }
                        else{
                            posi =  chessBoard.pieceToIndex.get("N"+i)[0];
                            posj =  chessBoard.pieceToIndex.get("N"+i)[1];
                        }
              
                        if(chessBoard.isValidKnightMove(posi, posj, posNewi, posNewj)){    
                            chessBoard.updateChessBoard(posi, posj, posNewi , posNewj );
                            break;
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
