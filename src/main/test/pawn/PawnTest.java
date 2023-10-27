package pawn;

import com.chesstpa.game.Game;
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
    void moveTest() {
       Game game = new Game();
       Board board = new Board();
       board.setBoardState("rnbq1bnr/pp1Q1ppp/3p1k2/4N3/3P2P1/8/PPP1PP1P/RNB1KB1R","K","kq");
//        System.out.println(game.getPossibleMovesForPosition("rnbq1bnr/pp1Q1ppp/3p1k2/4N3/3P2P1/8/PPP1PP1P/RNB1KB1R","f3"));   ///String [g4,g4] // is checkamet= true///// false {is check ,is pat , moves}
        board.printBoard();
        King king = (King) board.getSpot(7,4).getPiece();
        System.out.println(king.hasLongCastle());
        System.out.println(king.hasShortCastle());
    }
    @Test
    void firstMoveTest() {
        Board board = new Board();
        board.getSpot(0,4).setPiece(new King(PieceColor.Black));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.White));

        board.setKingSpot(board.getSpot(7,4));
        board.setKingSpot(board.getSpot(0,4));

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(5,0),board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(6,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void secondMoveTest() {
        Board board = new Board();
        board.getSpot(0,4).setPiece(new King(PieceColor.Black));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.White));

        board.setKingSpot(board.getSpot(7,4));
        board.setKingSpot(board.getSpot(0,4));

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(5,0),board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(6,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void notSecondMoveTest() {
        Board board = new Board();
        board.getSpot(0,4).setPiece(new King(PieceColor.Black));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(5,0).setPiece(new Pawn(PieceColor.White));

        board.setKingSpot(board.getSpot(7,4));
        board.setKingSpot(board.getSpot(0,4));

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(4,0)));
        Spot chekedSpot =board.getSpot(5,0);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void blockPawnTest() {
        Board board = new Board();
        board.getSpot(0,4).setPiece(new King(PieceColor.Black));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(6,0).setPiece(new Pawn(PieceColor.White));
        board.getSpot(5,0).setPiece(new Pawn(PieceColor.Black));

        board.setKingSpot(board.getSpot(7,4));
        board.setKingSpot(board.getSpot(0,4));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(6,0);

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
