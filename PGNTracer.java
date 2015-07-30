package pgn;

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
        String pieceName;
        if (!isAmbiguous()) {
            if (findPiece(move) == Piece.PAWN) {
                posNewi = getRowIndex(move.substring(move.length() - 2));
                posNewj = getColumnIndex(move.substring(move.length() - 2));
                if (color == 'W') {
                        pieceName = "p";
                } else {
                    pieceName = "P";
                }
                for (int i = 1; i < 9; i++) {                                
                    if(chessBoard.pieceToIndex.containsKey(pieceName + i)) {
                        posi = chessBoard.pieceToIndex.get(pieceName + i)[0];
                        posj = chessBoard.pieceToIndex.get(pieceName + i)[1];
                        if (chessBoard.isValidPawnMove(color, posi, posj, posNewi, posNewj, isCapture(move))) {
                            chessBoard.updateChessBoard(posi, posj, posNewi, posNewj, isCapture(move));
                        }
                    }
                }
            } else if (findPiece(move) == Piece.KNIGHT) {
                posNewi = getRowIndex(move.substring(move.length() - 2));
                posNewj = getColumnIndex(move.substring(move.length() - 2));
                
                if (color == 'W') {
                    pieceName = "n";
                } else {
                    pieceName = "N";
                }
                for (int i = 1; i < 3; i++) {
                    if(chessBoard.pieceToIndex.containsKey(pieceName + i)) {
                        posi = chessBoard.pieceToIndex.get(pieceName + i)[0];
                        posj = chessBoard.pieceToIndex.get(pieceName + i)[1];
                    
                        if (chessBoard.isValidKnightMove(posi, posj, posNewi, posNewj)) {
                            chessBoard.updateChessBoard(posi, posj, posNewi, posNewj, isCapture(move));
                            break;
                        }
                    }
                }
            } else if (findPiece(move) == Piece.BISHOP) {
                posNewi = getRowIndex(move.substring(move.length() - 2));
                posNewj = getColumnIndex(move.substring(move.length() - 2));
                
                if (color == 'W') {
                    pieceName = "b";
                } else {
                    pieceName = "B";
                }
                
                for (int i = 1; i < 3; i++) {
                    if(chessBoard.pieceToIndex.containsKey(pieceName + i)) {
                        posi = chessBoard.pieceToIndex.get(pieceName + i)[0];
                        posj = chessBoard.pieceToIndex.get(pieceName + i)[1];
                  
                        if (chessBoard.isValidBishopMove(posi, posj, posNewi, posNewj)) {
                            chessBoard.updateChessBoard(posi, posj, posNewi, posNewj, isCapture(move));
                            break;
                        }
                    }
                }
            } else if (findPiece(move) == Piece.QUEEN) {
                posNewi = getRowIndex(move.substring(move.length() - 2));
                posNewj = getColumnIndex(move.substring(move.length() - 2));
                
                if (color == 'W') {
                    pieceName = "q";
                } else {
                    pieceName = "Q";
                }
                
                if(chessBoard.pieceToIndex.containsKey(pieceName)) {
                    posi = chessBoard.pieceToIndex.get(pieceName)[0];
                    posj = chessBoard.pieceToIndex.get(pieceName)[1];
                
                    if (chessBoard.isValidQueenMove(posi, posj, posNewi, posNewj)) {
                        chessBoard.updateChessBoard(posi, posj, posNewi, posNewj, isCapture(move));
                    }
                }
            }
            else if (findPiece(move) == Piece.KING) {
                posNewi = getRowIndex(move.substring(move.length() - 2));
                posNewj = getColumnIndex(move.substring(move.length() - 2));
                
                if (color == 'W') {
                    pieceName = "k";
                } else {
                    pieceName = "K";
                }
                
                if(chessBoard.pieceToIndex.containsKey(pieceName)) {
                    posi = chessBoard.pieceToIndex.get(pieceName)[0];
                    posj = chessBoard.pieceToIndex.get(pieceName)[1];
                
                    if (chessBoard.isValidKingMove(posi, posj, posNewi, posNewj)) {
                        chessBoard.updateChessBoard(posi, posj, posNewi, posNewj, isCapture(move));
                    }
                }
            }
            
        }
    }

    private boolean isAmbiguous(String move) {
        if (findPiece(move) == Piece.PAWN) {
            return move.length() == 4 ;
        }
        if(move.length() == 4 ) {
            return move.indexOf('x') == -1;
        }
        if (move.length() == 5)
            return move.indexOf('x') != -1;
        return false; 
    }

    private Piece findPiece(String move) {
        char firstChar = move.charAt(0);
        if (firstChar == 'O') {
            return null;
        } else if (firstChar == 'K') {
            return Piece.KING;
        } else if (firstChar == 'Q') {
            return Piece.QUEEN;
        } else if (firstChar == 'R') {
            return Piece.ROOKS;
        } else if (firstChar == 'N') {
            return Piece.KNIGHT;
        } else if (firstChar == 'B') {
            return Piece.BISHOP;
        } else {
            return Piece.PAWN;
        }
    }

    public void displayBoard() {
        chessBoard.printBoard();
    }

    public int getColumnIndex(String move) {

        return move.charAt(0) - 'a';
    }

    public int getRowIndex(String pgnMove) {
        return 8 - Integer.parseInt("" + pgnMove.charAt(1));
    }

    public boolean isCapture(String move) {
        return (move.indexOf('x') != -1);

    }
    
    private String preProcessMove(String move) {
        if(move.charAt(move.length()-1) == '+') {
            return move.substring(0,move.length()-1);
        }
        return move;
    }
    public int[] getCurrentPosition(char color, String move) {
		int row, column;
		String pieceName = "";

		if (findPiece(move) == Piece.PAWN) {
			pieceName = "P";
		} else if (findPiece(move) == Piece.KNIGHT) {
			pieceName = "K";
		} else if (findPiece(move) == Piece.ROOKS) {
			pieceName = "R";
		} else if (findPiece(move) == Piece.BISHOP) {
			pieceName = "B";
		}
		if (color == 'W') {
			pieceName.toLowerCase();
		}
		if (Character.isLetter(move.charAt(1))) {
			column = move.charAt(1) - 'a';
			for (int i = 0; i < 8; i++) {
				if (chessBoard.board[i][column] == pieceName + "1" || chessBoard.board[i][column] == pieceName + "2") {
					int[] indices = { i, column };
					return indices;
				}
			}

		} else {
			row = 8 - Integer.parseInt("" + move.charAt(1));

			for (int i = 0; i < 8; i++) {
				if (chessBoard.board[row][i] == pieceName + "1" || chessBoard.board[row][i] == pieceName + "2") {
					int[] indices = { row, i };
					return indices;
				}
			}
		}

	}
}
