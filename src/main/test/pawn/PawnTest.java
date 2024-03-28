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
        board.getSpot(0,4).setPiece(new King(PieceColor.BLACK));
        board.getSpot(7,4).setPiece(new King(PieceColor.WHITE));
        board.setKingSpot(board.getSpot(7,4),board.getSpot(7,4).getPiece().getColor());
        board.setKingSpot(board.getSpot(0,4),board.getSpot(0,4).getPiece().getColor());
    }
    @Test
    void firstMoveTest() {
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(5,0),board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(6,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void secondMoveTest() {
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(5,0),board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(6,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void notSecondMoveTest() {
        board.getSpot(5,0).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(5,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void blockPawnTest() {
        board.getSpot(6,7).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(5,7).setPiece(new Pawn(PieceColor.BLACK));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(6,7);

        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void lastPositionWhiteTest() {
        board.getSpot(0,7).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(0,7);

        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void lastPositionBlackTest() {
        board.getSpot(7,7).setPiece(new Pawn(PieceColor.BLACK));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(7,7);

        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void enPassantBlackTest() {
        board.getSpot(5,5).setPiece(new Pawn(PieceColor.BLACK));
        board.setEnPassantPosition(new Position(6,6));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(6,5),board.getSpot(6,6)));
        Spot chekedSpot =board.getSpot(5,5);
        board.printBoard();
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void enPassantWhiteTest() {
        board.getSpot(2,4).setPiece(new Pawn(PieceColor.WHITE));
        board.setEnPassantPosition(new Position(1,5));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(1,4),board.getSpot(1,5)));
        Spot chekedSpot =board.getSpot(2,4);
        board.printBoard();
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }

//    @Test
//    void enPassantTest() {
//        Board board = new Board();
//        board.getSpot(3,1).setPiece(new Pawn(PieceColor.White));
//        board.getSpot(2,1).setPiece(new Pawn(PieceColor.Black));
//        board.getSpot(1,2).setPiece(new Pawn(PieceColor.Black));
//
//        Pawn pawn = (Pawn) board.getSpot(1,2).getPiece();
//        pawn.move(board, board.getSpot(1,2), board.getSpot(3,2));
//
//        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(2,2)));
//        List<Spot> takenPositions = board.getSpots()[3][1].getPiece().getPossibleMoves(board,board.getSpots()[3][1]);
//        assertEquals(correctPositions, takenPositions);
//    }

}
