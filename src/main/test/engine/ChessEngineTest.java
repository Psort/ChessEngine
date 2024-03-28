package engine;

import com.chesstpa.communication.ChessEngine;
import com.chesstpa.game.Game;
import com.chesstpa.pieces.PieceColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChessEngineTest {

    private ChessEngine engine;
    @BeforeEach
    public void setUp(){
        engine = new ChessEngine();
    }
    @Test
    void Test() {
        String board = "rnbqkbnr/ppp2p1p/8/3ppPp1/4P3/8/PPPP2PP/RNBQKBNR";
        String expected = engine.getPossibleMovesForPosition(board,"e7","c7","");
        Game game = new Game();
        game.setGameState(board,"c7","");
        game.getBoard().printBoard();
        game.getBoard().getSpot(3,3).getPiece().getPossibleMoves(game.getBoard(),game.getBoard().getSpot(3,3)).forEach(spot -> {
            System.out.println(spot.getPosition().getX()+" "+ spot.getPosition().getY());
        });
    }
    @Test
    void shouldReturnLegalRookMoves() {
        String expected = engine.getPossibleMovesForPosition("k6q/8/8/8/8/8/7R/7K","h7","","");
        String result = "h6/h5/h4/h3/h2/h1";
        assertEquals(result, expected);
    }

    @Test
    void shouldReturnLegalBishopMoves() {
        String expected = engine.getPossibleMovesForPosition("k6q/8/8/8/3B4/2K5/8/8","d5", "","");
        String result = "e4/f3/g2/h1";
        assertEquals(result, expected);
    }
    @Test
    void shouldReturnLegalKnightMoves() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/3N4/2K2q1/8/8","d5","","");
        String result = "f6";
        assertEquals(result, expected);
    }
    @Test
    void shouldReturnLegalQueenMoves() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/8/2KQ1q1/8/8","d6","","");
        String result = "e6/f6";
        assertEquals(result, expected);
    }
    @Test
    void shouldReturnLegalPawnMoves() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/8/6q1/7P/6K1","h7", "","");
        String result = "g6";
        assertEquals(result, expected);
    }
    @Test
    void shouldNotReturnAnyLegalPawnMove() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/4q3/8/6P1/7K","g7", "","");
        String result = "";
        assertEquals(result, expected);
    }
}
