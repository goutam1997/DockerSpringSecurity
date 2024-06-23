package splitwise.chess.piece;

import lombok.Data;
import splitwise.chess.Cell;
import splitwise.chess.Colour;
import splitwise.chess.moves.MoveType;

import java.util.List;

@Data
public abstract class Piece {
    Colour colour;
    String pieceName;
    List<MoveType> moveTypes;
    Piece(String pieceName, Colour colour, List<MoveType> moveTypes){
        this.pieceName=pieceName;
        this.colour=colour;
        this.moveTypes=moveTypes;
    }
    public boolean move(Cell start, Cell end) {
        for (MoveType moveType : moveTypes) {
            if (moveType.canMove(start, end)) {
                start.setPiece(null);
                end.setPiece(this);
                return true;
            }
        }
        return false;
    }

    public boolean kill(Cell start, Cell end) {
        for (MoveType moveType : moveTypes) {
            if (moveType.canMove(start, end)) {
                start.setPiece(null);
                end.setPiece(this);
                return true;
            }
        }
        return false;
    }
}
