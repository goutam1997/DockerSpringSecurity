package splitwise.tic_tac_toe;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        game.initializeGame(5, 4);
        game.startGame();
    }
}
