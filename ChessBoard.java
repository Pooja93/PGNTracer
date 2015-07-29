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
    
    ChessBoard(){
        
   }
    public void printBoard(){
        
    }
    
    public boolean isValidKnightMove(){
       
        return true;
    }
    public boolean isValidRookMove(){
       
        return true;
    }
    public boolean isValidKingMove(){
       
        return true;
    }
    public boolean isValidQueenMove(){
       
        return true;
    }
    public boolean isValidPawnMove(){
       
        return true;
    }   
}
