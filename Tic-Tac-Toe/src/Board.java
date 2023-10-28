import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class Board {

   int sizeOfBoard;
   PlayingPiece[][] board;

  public Board(int sizeOfBoard){
    this.sizeOfBoard = sizeOfBoard;
    board = new PlayingPiece[sizeOfBoard][sizeOfBoard];
  }

  public void printBoard() {
    System.out.println("Board:");
    for (int i = 0; i < sizeOfBoard; i++) {
      for (int j = 0; j < sizeOfBoard; j++) {
        if(board[i][j] != null)
          System.out.print(" " + board[i][j].getPieceType());
        else
          System.out.print(" " + "_" );
      }
      System.out.println();
    }
  }

  public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
    if (row >= sizeOfBoard || col >= sizeOfBoard ||
        row < 0 || col < 0 || board[row][col] != null) {
      System.out.println("wrong row " + row + " or column " + col
          + "specified .. Please enter valid and empty row & col.");
      return false;
    }
    board[row][col] = playingPiece;
    return true;
  }

  public List<Pair<Integer,Integer>> getFreeCells() {
    List<Pair<Integer,Integer>> freeCells = new ArrayList<>();
    for(int i = 0 ; i < sizeOfBoard ; i++){
      for(int j = 0 ; j < sizeOfBoard ; j++){
        if(board[i][j] == null)
          freeCells.add(new Pair<>(i,j));
      }
    }
    return freeCells;
  }
}
