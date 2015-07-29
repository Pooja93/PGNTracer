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
    
   	public void printBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == "")
					System.out.print("." + "\t");
				else

					System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}

	}
    
    public boolean isValidKnightMove(int fromX,int fromY, int toX, int toY){
		int xdiff = Math.abs(fromX-toX);
		int ydiff = Math.abs(toY-toY);
		if((xdiff == 1 && ydiff == 2) || (xdiff == 2 && ydiff == 1))
			return true;
		else 
			return false;
    }
    
    public boolean isValidRookMove(int fromX,int fromY, int toX, int toY){
		if(fromX == toX) {
			for (int i = Math.min(fromY,toY) + 1; i < Math.max(fromY,toY); i++ ) {
				if (board[fromX][i].equals("")) {
					return false;
				}
			}
			return true;
		}
		if(fromY == toY) {
			for (int i = Math.min(fromX,toX) + 1; i < Math.max(fromX,toX); i++ ) {
				if (board[i][fromY].equals("")) {
					return false;
				}
			}
			return true;
		}
        return false;
    }
    
    public boolean isValidKingMove(int x1, int y1, int x2, int y2){
       
        return true;
    }
    public boolean isValidQueenMove(int x1, int y1, int x2, int y2){
       
        return true;
    }
    
	public boolean isValidPawnMove(char color, int fromX, int fromY, int toX, int toY) {
		if (color == 'B') {
			if (fromX == 1) {
				if ((fromY == toY) && (toX == 2 || toX == 3))
					return true;
				else
					return false;
			} else {
				if ((fromY == toY) && toX == fromX + 1)
					return true;
				else
					return false;
			}

		} else {
			if (fromX == 6) {
				if ((fromY == toY) && (toX == 5 || toX == 4))
					return true;
				else
					return false;
			} else {
				if ((fromY == toY) && toX == fromX - 1)
					return true;
				else
					return false;

			}

		}

	}
    
	public void updateChessBoard(int fromX, int fromY, int toX, int toY) {
		String piece = board[fromX][fromY];
		board[toX][toY] = piece;
		board[fromX][fromY] = "";
		int[] indices = { toX, toY };
		pieceToIndex.put(piece, indices);

	}
}
