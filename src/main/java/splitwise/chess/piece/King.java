package splitwise.chess.piece;

import splitwise.chess.Colour;
import splitwise.chess.moves.DiagonalMoveType;
import splitwise.chess.moves.HorizontalMoveType;
import splitwise.chess.moves.MoveType;
import splitwise.chess.moves.VerticalMoveType;

import java.util.Arrays;
import java.util.List;

public class King extends Piece {
    Colour colour;
    String pieceName;
    List<MoveType> moveTypes;

    public King(String pieceName, Colour colour) {
        super(pieceName, colour, Arrays.asList(new HorizontalMoveType(), new VerticalMoveType(), new DiagonalMoveType()));
    }
}
