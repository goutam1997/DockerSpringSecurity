package splitwise.chess.piece;

import splitwise.chess.Colour;
import splitwise.chess.moves.DiagonalMoveType;
import splitwise.chess.moves.KnightMoveType;
import splitwise.chess.moves.MoveType;

import java.util.Collections;
import java.util.List;

public class Knight extends Piece {
    Colour colour;
    String pieceName;
    List<MoveType> moveTypes;

    public Knight(String pieceName, Colour colour){
        super(pieceName, colour, Collections.singletonList(new KnightMoveType()));
    }
}
