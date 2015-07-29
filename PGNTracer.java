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
            if(findPiece(move)==Piece.PAWN){
                posNewi = getRowIndex(move);
                posNewj = getColumnIndex(move);
                for(int i = 1; i < 9; i++){
                    if (color == 'W'){
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
                    posNewi = getRowIndex(move.substring(move.length()-1,move.length()));
                    posNewj = getColumnIndex(move.substring(move.length()-1,move.length()));
                    
                    for(int i = 1; i < 3; i++){
                        if (color == 'W'){
                            posi =  chessBoard.pieceToIndex.get("n"+i)[0];
                            posj =  chessBoard.pieceToIndex.get("n"+i)[1];
                        }
                        else{
                            posi =  chessBoard.pieceToIndex.get("N"+i)[0];
                            posj =  chessBoard.pieceToIndex.get("N"+i)[1];
                        }
                        System.out.println(posi+" "+posj);    
                        if(chessBoard.isValidKnightMove(posi, posj, posNewi, posNewj)){    
                            chessBoard.updateChessBoard(posi, posj, posNewi , posNewj );
                            break;
                        }   
                }
            }
            else if(findPiece(move)==Piece.BISHOP){
                    posNewi = getRowIndex(move.substring(move.length()-1,move.length()));
                    posNewj = getColumnIndex(move.substring(move.length()-1,move.length()));
                    
                    for(int i = 1; i < 3; i++){
                        if (color == 'W'){
                            posi =  chessBoard.pieceToIndex.get("b"+i)[0];
                            posj =  chessBoard.pieceToIndex.get("b"+i)[1];
                        }
                        else{
                            posi =  chessBoard.pieceToIndex.get("B"+i)[0];
                            posj =  chessBoard.pieceToIndex.get("B"+i)[1];
                        }
                        if(chessBoard.isValidBishopMove(posi, posj, posNewi, posNewj)){    
                            chessBoard.updateChessBoard(posi, posj, posNewi , posNewj );
                            break;
                        }   
                }
            }
            else if(findPiece(move)==Piece.QUEEN){
                    posNewi = getRowIndex(move.substring(move.length()-1,move.length()));
                    posNewj = getColumnIndex(move.substring(move.length()-1,move.length()));
                    
                    if (color == 'W'){
                        posi =  chessBoard.pieceToIndex.get("q")[0];
                        posj =  chessBoard.pieceToIndex.get("q")[1];
                    }
                    else{
                        posi =  chessBoard.pieceToIndex.get("Q")[0];
                        posj =  chessBoard.pieceToIndex.get("Q")[1];
                    }
                    if(chessBoard.isValidQueenMove(posi, posj, posNewi, posNewj)){    
                        chessBoard.updateChessBoard(posi, posj, posNewi , posNewj );
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
