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
    void shouldReturnLegalRookMoves() {
        String expected = engine.getPossibleMovesForPosition("k6q/8/8/8/8/8/7R/7K","h2","","");
        String result = "h3/h4/h5/h6/h7/h8";
        assertEquals(result, expected);
    }

    @Test
    void shouldReturnLegalBishopMoves() {
        String expected = engine.getPossibleMovesForPosition("k6q/8/8/8/3B4/2K5/8/8","d4", "","");
        String result = "e5/f6/g7/h8";
        assertEquals(result, expected);
    }
    @Test
    void shouldReturnLegalKnightMoves() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/3N4/2K2q1/8/8","d4","","");
        String result = "f3";
        assertEquals(result, expected);
    }
    @Test
    void shouldReturnLegalQueenMoves() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/8/2KQ1q1/8/8","d3","","");
        String result = "e3/f3";
        System.out.println(expected);
        assertEquals(result, expected);
    }
    @Test
    void shouldReturnLegalPawnMoves() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/8/6q1/7P/6K1","h2", "","");
        String result = "g3";
        assertEquals(result, expected);
    }
    @Test
    void shouldNotReturnAnyLegalPawnMove() {
        String expected = engine.getPossibleMovesForPosition("k7/8/8/8/4q3/8/6P1/7K","g7", "","");
        String result = "";
        assertEquals(result, expected);
    }
}
