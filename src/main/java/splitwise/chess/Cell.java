package splitwise.chess;

import lombok.AllArgsConstructor;
import lombok.Data;
import splitwise.chess.piece.Piece;

@AllArgsConstructor
@Data
public class Cell {
    int x;
    int y;
    Piece piece;
}
