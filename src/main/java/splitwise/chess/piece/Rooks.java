package splitwise.chess.piece;

import splitwise.chess.*;
import splitwise.chess.moves.HorizontalMoveType;
import splitwise.chess.moves.MoveType;
import splitwise.chess.moves.VerticalMoveType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rooks extends Piece {
    Colour colour;
    String pieceName;
    List<MoveType> moveTypes;

    public Rooks(String pieceName, Colour colour){
        super(pieceName, colour, Arrays.asList(new VerticalMoveType(), new HorizontalMoveType()));
    }

}
