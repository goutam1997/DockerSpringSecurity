package splitwise.chess.moves;

import splitwise.chess.Cell;

public class VerticalMoveType implements MoveType {
    @Override
    public boolean canMove(Cell start, Cell end) {
        return true;
    }
}
