package game;

import com.chesstpa.game.Game;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameTest {
    @Test
    void isCheckMateTest() {
        //initialize Piece
        Game game =new Game();
        game.setGameState("k5rr/8/8/8/8/8/8/7K","","");
        assertTrue(game.isCheckMate(PieceColor.White));
    }
    @Test
    void isNotCheckMateTest() {
        //initialize Piece
        Game game =new Game();
        game.setGameState("K5r1/8/8/8/8/8/8/7k","","");
        assertFalse(game.isCheckMate(PieceColor.White));

    }
    @Test
    void isPatTest() {
        Game game =new Game();
        game.setGameState("K7/6r1/8/8/8/8/1r7/7k","","");
        assertTrue(game.isPat(PieceColor.White));
    }
    @Test
    void isPatWithTwoKingsTest() {
        Game game =new Game();
        game.setGameState("K7/8/8/8/8/8/8/7k","","");
        assertTrue(game.isPat(PieceColor.White));
    }
    @Test
    void isNotPatTest() {
        Game game =new Game();
        game.setGameState("K5r1/8/8/8/8/8/8/r6k","","");
        assertFalse(game.isPat(PieceColor.White));
    }
    @Test
    void isScholarsMateTest() {
        Game game =new Game();
        game.setGameState("3qkb2/3ppQ/4Q3/8/8/8/8/7K","","");
        game.getBoard().printBoard();
        assertTrue(game.isCheckMate(PieceColor.Black));
    }

}
