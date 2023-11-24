package game;

import com.chesstpa.board.Spot;
import com.chesstpa.game.Game;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameTest {
    private Game game;
    @BeforeEach
    public void setUp(){
        game = new Game();
    }
    @Test
    void isCheckMateTest() {
        //initialize Piece
        game.setGameState("k5rr/8/8/8/8/8/8/7K","");
        assertTrue(game.isCheckMate(PieceColor.White));
    }
    @Test
    void isNotCheckMateTest() {
        //initialize Piece
        game.setGameState("K5r1/8/8/8/8/8/8/7k","");
        assertFalse(game.isCheckMate(PieceColor.White));

    }
    @Test
    void isPatTest() {
        game.setGameState("K7/6r1/8/8/8/8/1r7/7k","");
        assertTrue(game.isPat(PieceColor.White));
    }
    @Test
    void isPatWithTwoKingsTest() {
        game.setGameState("K7/8/8/8/8/8/8/7k","");
        assertTrue(game.isPat(PieceColor.White));
    }
    @Test
    void isNotPatTest() {
        game.setGameState("K5r1/8/8/8/8/8/8/r6k","");
        assertFalse(game.isPat(PieceColor.White));
    }
    @Test
    void isScholarsMateTest() {
        game.setGameState("3qkb2/3ppQ/4Q3/8/8/8/8/7K","");
        List<Spot> takenPositions = game.getBoard().getSpot(0,4).getPiece().getPossibleMoves(game.getBoard(),game.getBoard().getSpot(0,4));
        assertTrue(game.isCheckMate(PieceColor.Black));
    }

}
