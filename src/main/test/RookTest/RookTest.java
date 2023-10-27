package RookTest;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {

    @Test
    void noMoveTest() {
        Board board = new Board();
        board.getSpot(0,0).setPiece(new Rook(PieceColor.White));
        board.getSpot(0,1).setPiece(new Pawn(PieceColor.White));
        board.getSpot(1,0).setPiece(new Pawn(PieceColor.White));



        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(0,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getBeatenSpot(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void moveTest() {
        Board board = new Board();
        board.getSpot(0,0).setPiece(new Rook(PieceColor.White));
        board.getSpot(0,1).setPiece(new Pawn(PieceColor.White));
        board.getSpot(3,0).setPiece(new Pawn(PieceColor.White));

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(1,0),board.getSpot(2,0)));
        Spot chekedSpot =board.getSpot(0,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getBeatenSpot(board,chekedSpot);

        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void canBeatMoveTest() {
        Board board = new Board();
        board.getSpot(0,0).setPiece(new Rook(PieceColor.White));
        board.getSpot(0,1).setPiece(new Pawn(PieceColor.White));
        board.getSpot(2,0).setPiece(new Pawn(PieceColor.Black));

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(1,0),board.getSpot(2,0)));
        Spot chekedSpot =board.getSpot(0,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getBeatenSpot(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }

}
