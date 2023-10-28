import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javafx.util.Pair;

public class Game {

  private Deque<Player> players;
  private Board board;

  public void initializeGame(int boardSize, int numberOfPlayers) {
    board = new Board(boardSize);
    players = new LinkedList<>();

    players.add(new Player("Player 1", new PlayingPiece(PieceType.X)));
    players.add(new Player("Player 2", new PlayingPiece(PieceType.O)));
  }

  public void startGame() {
    boolean gameOver = false;

    while (!gameOver) {
      board.printBoard();
      List<Pair<Integer, Integer>> freeCells = board.getFreeCells();
      if (freeCells.isEmpty()) {
        gameOver = true;
        System.out.println("Game is draw");
      }

      Player player = players.pollFirst();

      System.out.println(("Turn of player : " + player + " , Enter row column : "));
      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      String[] values = line.split(",");

      int inputRow = Integer.parseInt(values[0]);
      int inputCol = Integer.parseInt(values[1]);

      boolean added = board.addPiece(inputRow, inputCol, player.getPlayingPiece());
      if (!added) {
        System.out.println("Invalid entry .. Please enter again");
        players.offerFirst(player);
        continue;
      }

      gameOver = isThereAWinner(inputRow, inputCol, player.getPlayingPiece());
      if (gameOver) {
        board.printBoard();
        System.out.println("Player " + player + " has won");
      }
      players.offerLast(player);
    }
  }

  private boolean isThereAWinner(int row, int col, PlayingPiece piece) {
    PlayingPiece[][] boards = board.board;
    int dimensions = board.sizeOfBoard;

    boolean allRows = true, allCols = true, leadingDiag = true, trailingDiag = true;

    for (int i = 0; i < dimensions; i++) {
      if (boards[i][col] != piece) {
        allCols = false;
      }

      if (boards[row][i] != piece) {
        allRows = false;
      }

      if (boards[i][i] != piece) {
        leadingDiag = false;
      }

      if (boards[i][dimensions - i - 1] != piece) {
        trailingDiag = false;
      }

    }

    return allRows || allCols || leadingDiag || trailingDiag;
  }

}
