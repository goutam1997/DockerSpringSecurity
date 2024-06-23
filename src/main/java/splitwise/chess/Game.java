package splitwise.chess;

public class Game {
    public static void main(String[] args) {
        Board board=new Board();
        board.initialize();
        board.printBoard();

        board.startGame();
        board.printBoard();
    }
}
