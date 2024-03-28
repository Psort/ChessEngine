package KnightTest;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
        board.getSpot(0,4).setPiece(new King(PieceColor.BLACK));
        board.getSpot(7,4).setPiece(new King(PieceColor.WHITE));
        board.setKingSpot(board.getSpot(7,4),board.getSpot(7,4).getPiece().getColor());
        board.setKingSpot(board.getSpot(0,4),board.getSpot(0,4).getPiece().getColor());
    }

    @Test
    void noMoveTest() {
        board.getSpot(0,0).setPiece(new Knight(PieceColor.WHITE));
        board.getSpot(1,2).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(2,1).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>();
        Spot checkedSpot = board.getSpot(0,0);
        List<Spot> takenPositions = checkedSpot.getPiece().getPossibleMoves(board, checkedSpot);

        assertEquals(correctPositions, takenPositions);
    }

    @Test
    void moveTest() {
        board.getSpot(0,0).setPiece(new Knight(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(1,2), board.getSpot(2,1)));
        Spot checkedSpot = board.getSpot(0,0);
        List<Spot> takenPositions = checkedSpot.getPiece().getPossibleMoves(board, checkedSpot);

        assertEquals(correctPositions, takenPositions);
    }

    @Test
    void canBeatMoveTest() {
        board.getSpot(0,0).setPiece(new Knight(PieceColor.WHITE));
        board.getSpot(1,2).setPiece(new Pawn(PieceColor.BLACK));
        board.getSpot(2,1).setPiece(new Pawn(PieceColor.BLACK));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(1,2), board.getSpot(2,1)));
        Spot checkedSpot = board.getSpot(0,0);
        List<Spot> takenPositions = checkedSpot.getPiece().getPossibleMoves(board, checkedSpot);

        assertEquals(correctPositions, takenPositions);
    }
}
