package splitwise.chess;

import splitwise.chess.piece.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Board {
    Deque<Player> players;
    Cell [][]cells;
    public void initialize(){
        Player p1=new Player(1, "GK", Colour.WHITE);
        Player p2=new Player(2, "SP", Colour.BLACK);
        players=new ArrayDeque<>();
        players.addAll(Arrays.asList(p1,p2));

        cells=new Cell[8][8];
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                cells[i][j]=new Cell(i, j, null);
            }
        }

        populatePieces();
    }

    private void populatePieces() {
        cells[0][0].piece=cells[0][7].piece=new Rooks("BR", Colour.BLACK);
        cells[0][1].piece=cells[0][6].piece=new Knight("BH", Colour.BLACK);
        cells[0][2].piece=cells[0][5].piece=new Bishop("BB", Colour.BLACK);
        cells[0][3].piece=new Queen("BQ", Colour.BLACK);
        cells[0][4].piece=new King("BK", Colour.BLACK);

        for (int j=0;j<8;j++){
            cells[1][j].piece=new Pawn("BP", Colour.BLACK);
        }

        cells[7][0].piece=cells[7][7].piece=new Rooks("WR", Colour.WHITE);
        cells[7][1].piece=cells[7][6].piece=new Knight("WH", Colour.WHITE);
        cells[7][2].piece=cells[7][5].piece=new Bishop("WB", Colour.WHITE);
        cells[7][3].piece=new Queen("WQ", Colour.WHITE);
        cells[7][4].piece=new King("WK", Colour.WHITE);

        for (int j=0;j<8;j++){
            cells[6][j].piece=new Pawn("WP", Colour.WHITE);
        }
    }

    public void printBoard() {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (cells[i][j].piece==null){
                    System.out.print("** ");
                }else {
                    System.out.print(cells[i][j].piece.getPieceName()+" ");
                }
            }
            System.out.println();
        }
    }

    private Piece getPieceByPlayer(Player player, int x, int y){
        Piece piece=cells[x][y].piece;
        if (piece!=null && piece.getColour() == player.getColour()){
            return piece;
        }
        System.out.println("No piece of yours!!!");
        return null;
    }
    public void startGame() {
        Player whitePlayer=players.pollFirst();
        Piece piece=null;
        while (piece==null){
            piece=getPieceByPlayer(whitePlayer, 7, 6);
            if (piece!=null){
                piece.move(cells[7][6], cells[5][5]);
            }
        }
        players.addLast(whitePlayer);

        Player blackPlayer=players.pollFirst();
        piece=null;
        while (piece==null){
            piece=getPieceByPlayer(blackPlayer, 7, 6);
            if (piece!=null){
                piece.move(cells[7][6], cells[5][5]);
            }
            piece=getPieceByPlayer(blackPlayer, 1, 7);
            if (piece!=null){
                piece.move(cells[1][7], cells[3][7]);
            }
        }
        players.addLast(blackPlayer);
    }
}
