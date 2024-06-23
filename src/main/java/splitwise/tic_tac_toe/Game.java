package splitwise.tic_tac_toe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class Game {
    Cell[][]cells;
    Deque<Player> players;

    void initializeGame(int ladders, int snakes){
        players=new ArrayDeque<>();
        Player p1=new Player(1, "GK", 0);
        Player p2=new Player(2, "SP", 0);
        players.addAll(Arrays.asList(p1, p2));

        cells=new Cell[10][10];
        for (int i=0;i<10;i++){
            for (int j = 0; j < 10; j++) {
                cells[i][j]=new Cell();
            }
        }
        while (ladders>0){
            int start=new Random().nextInt(100);
            int end=new Random().nextInt(100);
            if (end <= start){
                continue;
            }
            System.out.println("Ladder ("+start+", "+end+")");
            int sx=start/10, sy=start%10;
            int ex=end/10, ey=end%10;
            Jump jump=new Jump();
            jump.setSx(sx);
            jump.setSy(sy);
            jump.setEx(ex);
            jump.setEy(ey);
            jump.setSnake(false);
            cells[sx][sy].setJump(jump);
            ladders--;
        }
        while (snakes>0){
            int start=new Random().nextInt(100);
            int end=new Random().nextInt(100);
            if (end >= start){
                continue;
            }
            System.out.println("Snake ("+start+", "+end+")");
            int sx=start/10, sy=start%10;
            int ex=end/10, ey=end%10;
            Jump jump=new Jump();
            jump.setSx(sx);
            jump.setSy(sy);
            jump.setEx(ex);
            jump.setEy(ey);
            jump.setSnake(true);
            cells[sx][sy].setJump(jump);
            snakes--;
        }
    }

    public void startGame() {
        Player winner;
        while (true){
            Player cur=players.pollFirst();
            int diceNo=new Random().nextInt(6)+1;
            int curpos=cur.getPos()+diceNo;
            System.out.println("Player "+cur.name+" moved to: "+curpos);
            if (curpos>=100){
                winner=cur;
                break;
            }
            int cx=curpos/10, cy=curpos%10;
            if (cells[cx][cy].getJump()!=null){
                Jump jump=cells[cx][cy].getJump();
                System.out.println(jump);
                curpos= jump.getEx()*10+ jump.getEy();
                System.out.println("Player "+cur.name+" stepped onto Snake: "+jump.isSnake()+" moved to: "+curpos);
            }
            cur.setPos(curpos);
            players.addLast(cur);
        }
        System.out.println("Winner: "+winner.name);
    }
}
