package splitwise.chess.piece;

import splitwise.chess.Colour;
import splitwise.chess.moves.DiagonalMoveType;
import splitwise.chess.moves.MoveType;

import java.util.Collections;
import java.util.List;

public class Bishop extends Piece {
    Colour colour;
    String pieceName;
    List<MoveType> moveTypes;

    public Bishop(String pieceName, Colour colour){
        super(pieceName, colour, Collections.singletonList(new DiagonalMoveType()));
    }
}
