package splitwise.chess;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import splitwise.chess.piece.Piece;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {
    int id;
    String name;
    Colour colour;

    public boolean move(Piece piece, Cell start, Cell dest){
        return piece.move(start, dest);
    }
}
