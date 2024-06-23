package splitwise.chess.moves;

import splitwise.chess.Cell;

public interface MoveType {
    boolean canMove(Cell start, Cell end);
}
