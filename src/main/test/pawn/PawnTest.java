package pawn;


import com.chesstpa.board.Board;
import com.chesstpa.board.Position;
import com.chesstpa.board.Spot;
import com.chesstpa.communication.ChessEngine;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {
    private Board board;
    @BeforeEach
    public void setUp(){
        board = new Board();
        board.getSpot(0,4).setPiece(new King(PieceColor.WHITE));
        board.getSpot(7,4).setPiece(new King(PieceColor.BLACK));
        board.setKingSpot(board.getSpot(7,4),board.getSpot(7,4).getPiece().getColor());
        board.setKingSpot(board.getSpot(0,4),board.getSpot(0,4).getPiece().getColor());
    }
    @Test
    void WhiteFirstMoveTest() {
        Spot chekedSpot =board.getSpot(1,0);
        chekedSpot.setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(2,0),board.getSpot(3,0)));
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void BlackFirstMoveTest() {
        Spot chekedSpot =board.getSpot(5,0);
        chekedSpot.setPiece(new Pawn(PieceColor.BLACK));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(4,0)));
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void WhiteSecondMoveTest() {
        Spot chekedSpot =board.getSpot(2,0);
        chekedSpot.setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(3,0)));
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void blockBlackPawnTest() {
        board.getSpot(6,7).setPiece(new Pawn(PieceColor.BLACK));
        board.getSpot(5,7).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(6,7);

        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void blockPawnWhiteTest() {
        board.getSpot(6,7).setPiece(new Pawn(PieceColor.BLACK));
        board.getSpot(5,7).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(5,7);

        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void lastPositionWhiteTest() {
        board.getSpot(7,7).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(7,7);

        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void lastPositionBlackTest() {
        board.getSpot(0,0).setPiece(new Pawn(PieceColor.BLACK));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(0,0);

        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void enPassantBlackTest() {
        Spot chekedSpot =board.getSpot(5,5);
        chekedSpot.setPiece(new Pawn(PieceColor.WHITE));
        board.setEnPassantPosition(new Position(6,6));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(6,5),board.getSpot(6,6)));
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void enPassantWhiteTest() {
        Spot chekedSpot =board.getSpot(2,4);
        chekedSpot.setPiece(new Pawn(PieceColor.BLACK));
        board.setEnPassantPosition(new Position(1,5));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(1,4),board.getSpot(1,5)));
        board.printBoard();
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }

}
