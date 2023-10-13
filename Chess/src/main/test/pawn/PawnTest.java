package pawn;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {
    @Test
    void firstMoveTest() {
        Board board = new Board();
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.White));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(5,0),board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(6,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void secondMoveTest() {
        Board board = new Board();
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.White));

        Spot pawnSpot = board.getSpot(6,0);
        Spot nextSpot = board.getSpot(5,0);
        pawnSpot.getPiece().move(board, pawnSpot, nextSpot);

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(5,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void blockPawnTest() {
        Board board = new Board();
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.White));
        board.getSpot(5,0).setPiece(new Pawn(PieceColor.Black));

        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(6,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void enPassantTest() {
        Board board = new Board();
        board.getSpot(3,1).setPiece(new Pawn(PieceColor.White));
        board.getSpot(2,1).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,2).setPiece(new Pawn(PieceColor.Black));

        Pawn pawn = (Pawn) board.getSpot(1,2).getPiece();
        pawn.move(board, board.getSpot(1,2), board.getSpot(3,2));

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(2,2)));
        List<Spot> takenPositions = board.getSpots()[3][1].getPiece().getPossibleMoves(board,board.getSpots()[3][1]);
        assertEquals(correctPositions, takenPositions);
    }

}
