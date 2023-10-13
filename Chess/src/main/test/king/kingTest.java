package king;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class kingTest {
    @Test
    void canCastleKingSideTest() {
        Board board = new Board();
        board.getSpot(7,3).setPiece(new Queen(PieceColor.White));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(7,7).setPiece(new Rook(PieceColor.White));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.White));


        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(7,5),board.getSpot(7,6)));
        Spot chekedSpot =board.getSpot(7,4);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void canCastleQueenSideTest() {
        Board board = new Board();
        board.getSpot(7,5).setPiece(new Bishop(PieceColor.White));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(7,0).setPiece(new Rook(PieceColor.White));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.White));


        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(7,3),board.getSpot(7,2)));
        Spot chekedSpot =board.getSpot(7,4);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void cantCastleQueenSideByAttackTest() {
        Board board = new Board();
        board.getSpot(7,5).setPiece(new Bishop(PieceColor.White));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(7,0).setPiece(new Rook(PieceColor.White));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.White));
        board.getSpot(5,4).setPiece(new Knight(PieceColor.Black));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(7,4);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void cantCastleQueenSideByMoveKingTest() {
        Board board = new Board();
        board.getSpot(7,5).setPiece( new Bishop(PieceColor.White));
        board.getSpot(7,4).setPiece(new King(PieceColor.White));
        board.getSpot(7,0).setPiece(new Rook(PieceColor.White));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.White));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.White));


        King king = (King) board.getSpot(7,4).getPiece();
        king.move(board, board.getSpot(7,4), board.getSpot(7,3));

        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(6,2),board.getSpot(7,2),board.getSpot(7,4)));
        Spot chekedSpot =board.getSpot(7,3);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);

    }

}
