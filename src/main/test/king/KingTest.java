package king;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {
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
    void cantMoveTest() {
        board.getSpot(0,3).setPiece(new Queen(PieceColor.BLACK));
        board.getSpot(0,5).setPiece(new Bishop(PieceColor.BLACK));
        board.getSpot(1,3).setPiece(new Pawn(PieceColor.BLACK));
        board.getSpot(1,4).setPiece(new Pawn(PieceColor.BLACK));
        board.getSpot(1,5).setPiece(new Pawn(PieceColor.BLACK));


        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(0,4);
        King king =  (King) chekedSpot.getPiece();
        king.setShortCastle(true);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }

    @Test
    void cantMoveByAttackTest() {
        board.getSpot(0,3).setPiece(new Queen(PieceColor.BLACK));
        board.getSpot(0,5).setPiece(new Bishop(PieceColor.BLACK));
        board.getSpot(1,3).setPiece(new Pawn(PieceColor.BLACK));
        board.getSpot(1,4).setPiece(new Pawn(PieceColor.BLACK));


        board.getSpot(2,4).setPiece(new Queen(PieceColor.WHITE));



        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(0,4);
        King king =  (King) chekedSpot.getPiece();
        king.setShortCastle(true);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void cantBeatBySpotIsUnderAttackTest() {
        board.getSpot(0,3).setPiece(new Queen(PieceColor.BLACK));
        board.getSpot(0,5).setPiece(new Bishop(PieceColor.BLACK));
        board.getSpot(1,3).setPiece(new Pawn(PieceColor.BLACK));
        board.getSpot(1,4).setPiece(new Pawn(PieceColor.BLACK));

        board.getSpot(1,5).setPiece(new Queen(PieceColor.WHITE));
        board.getSpot(2,4).setPiece(new Queen(PieceColor.WHITE));


        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(0,4);
        King king =  (King) chekedSpot.getPiece();
        king.setShortCastle(true);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void canCastleKingSideTest() {
        board.getSpot(7,3).setPiece(new Queen(PieceColor.WHITE));
        board.getSpot(7,7).setPiece(new Rook(PieceColor.WHITE));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.WHITE));


        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(7,5),board.getSpot(7,6)));
        Spot chekedSpot =board.getSpot(7,4);
        King king =  (King) chekedSpot.getPiece();
        king.setShortCastle(true);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void canCastleQueenSideTest() {
        board.getSpot(7,5).setPiece(new Bishop(PieceColor.WHITE));
        board.getSpot(7,0).setPiece(new Rook(PieceColor.WHITE));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(7,3),board.getSpot(7,2)));
        Spot chekedSpot =board.getSpot(7,4);
        King king =  (King) chekedSpot.getPiece();
        king.setLongCastle(true);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void cantCastleQueenSideTest() {
        board.getSpot(7,5).setPiece(new Bishop(PieceColor.WHITE));
        board.getSpot(7,0).setPiece(new Rook(PieceColor.WHITE));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(5,4).setPiece(new Knight(PieceColor.BLACK));
        List<Spot> correctPositions = new ArrayList<>();
        Spot chekedSpot =board.getSpot(7,4);
        King king =  (King) chekedSpot.getPiece();
        king.setLongCastle(true);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);
    }
    @Test
    void cantCastleKingSideTest() {
        board.getSpot(5,5).setPiece( new Knight(PieceColor.BLACK));
        board.getSpot(7,3).setPiece(new Queen(PieceColor.WHITE));
        board.getSpot(6,3).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,4).setPiece(new Pawn(PieceColor.WHITE));
        board.getSpot(6,5).setPiece(new Pawn(PieceColor.WHITE));
        List<Spot> correctPositions = new ArrayList<>(List.of(board.getSpot(7,5)));
        Spot chekedSpot =board.getSpot(7,4);
        King king =  (King) chekedSpot.getPiece();
        king.setLongCastle(true);
        List<Spot> takenPositions = chekedSpot.getPiece().getPossibleMoves(board,chekedSpot);
        assertEquals(correctPositions, takenPositions);

    }

}
