import java.util.*;

public class ChessBoard {
    String[][] board = {
        {"R1","N1","B1","Q","K","B2","N2","R2"},
        {"P1","P2","P3","P4","P5","P6","P7","P8"},
        {"","","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","","",""},                
        {"","","","","","","",""},
        {"p1","p2","p3","p4","p5","p6","p7","p8"},
        {"r1","n1","b1","q","k","b2","n2","r2"}
        };
        
    HashMap<String,int[]> pieceToIndex;
    
    ChessBoard(){
		pieceToIndex  = new HashMap<String,int[]>();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if (!board[i][j].equals("")) {
					int[] position = {i,j};
					pieceToIndex.put(board[i][j],position);
				}
			}
		}
		
    }
    
    public void printBoard(){
        
    }
    
    public boolean isValidKnightMove(String knight, String move){
       
        return true;
    }
    public boolean isValidRookMove(String rook, String move){
       
        return true;
    }
    public boolean isValidKingMove(String king, String move){
       
        return true;
    }
    public boolean isValidQueenMove(String queen, String move){
       
        return true;
    }
    public boolean isValidPawnMove(String pawn, String move){
       
        return true;
    }
    
}
