package splitwise.tic_tac_toe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Jump {
    int sx, sy, ex, ey;
    boolean isSnake;
}
