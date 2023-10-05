import com.chesstpa.Game;
import com.chesstpa.board.Board;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        game.initialize();

        System.out.println(game.getBoard());
    }
}
