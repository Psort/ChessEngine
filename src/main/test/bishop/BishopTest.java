package BishopTest;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {
    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
        board.getSpot(0,4).setPiece(new King(PieceColor.Black));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.setKingSpot(board.getSpot(7,4));
        board.setKingSpot(board.getSpot(0,4));
    }

    @Test
    void noMoveTest() {
        board.getSpot(3,3).setPiece(new Bishop(PieceColor.White));
        board.getSpot(2,2).setPiece(new Pawn(PieceColor.White));
        board.getSpot(2,4).setPiece(new Pawn(PieceColor.White));
        board.getSpot(4,2).setPiece(new Pawn(PieceColor.White));
        board.getSpot(4,4).setPiece(new Pawn(PieceColor.White));
        List<Spot> correctPositions = new ArrayList<>();
        Spot checkedSpot = board.getSpot(3,3);
        List<Spot> takenPositions = checkedSpot.getPiece().getPossibleMoves(board, checkedSpot);

        assertEquals(correctPositions, takenPositions);
    }

    @Test
    void moveTest() {
        board.getSpot(3,3).setPiece(new Bishop(PieceColor.White));
        board.getSpot(1,1).setPiece(new Pawn(PieceColor.White));
        board.getSpot(1,5).setPiece(new Pawn(PieceColor.White));
        board.getSpot(5,1).setPiece(new Pawn(PieceColor.White));
        board.getSpot(5,5).setPiece(new Pawn(PieceColor.White));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(4,4), board.getSpot(2,2), board.getSpot(4,2), board.getSpot(2,4)));
        Spot checkedSpot = board.getSpot(3,3);
        List<Spot> takenPositions = checkedSpot.getPiece().getPossibleMoves(board, checkedSpot);
        assertEquals(correctPositions, takenPositions);
    }

    @Test
    void canBeatMoveTest() {
        board.getSpot(3,3).setPiece(new Bishop(PieceColor.White));
        board.getSpot(2,2).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(2,4).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(4,2).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(4,4).setPiece(new Pawn(PieceColor.Black));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(4,4), board.getSpot(2,2), board.getSpot(4,2), board.getSpot(2,4)));
        Spot checkedSpot = board.getSpot(3,3);
        List<Spot> takenPositions = checkedSpot.getPiece().getPossibleMoves(board, checkedSpot);
        assertEquals(correctPositions, takenPositions);
    }
}
