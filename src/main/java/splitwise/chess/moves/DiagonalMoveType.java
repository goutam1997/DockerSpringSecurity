package splitwise.chess.moves;

import splitwise.chess.Cell;

public class DiagonalMoveType implements MoveType {
    @Override
    public boolean canMove(Cell start, Cell end) {
        return true;
    }
}
