package spot;

import com.chesstpa.board.Board;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpotTest {
    private Board board;
    @BeforeEach
    public void setUp(){
        board = new Board();
    }
    @Test
    void isBeatenByKnight() {
        board.getSpot(4,3).setPiece(new Rook(PieceColor.WHITE));
        board.getSpot(2,2).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(2,2).setPiece(null);
        board.getSpot(2,4).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(2,4).setPiece(null);
        board.getSpot(3,1).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(3,1).setPiece(null);
        board.getSpot(3,5).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(3,5).setPiece(null);
        board.getSpot(5,1).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(5,1).setPiece(null);
        board.getSpot(5,5).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(5,5).setPiece(null);
        board.getSpot(6,2).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(6,2).setPiece(new Knight(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.WHITE));
    }
    @Test
    void isBeatenByKing() {
        board.getSpot(4,3).setPiece(new Rook(PieceColor.WHITE));

        // Check if the spot (4, 3) is attacked by a king at different positions

        // Upper adjacent spot
        board.getSpot(3,3).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

        // Lower adjacent spot
        board.getSpot(5,3).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

        // Left adjacent spot
        board.getSpot(4,2).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

        // Right adjacent spot
        board.getSpot(4,4).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

        // Extreme spots diagonally
        board.getSpot(3,2).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

        board.getSpot(5,4).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

        board.getSpot(3,4).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

        board.getSpot(5,2).setPiece(new King(PieceColor.BLACK));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.WHITE));

    }
    @Test
    void isBeatenByRook() {
        board.getSpot(0,0).setPiece(new Rook(PieceColor.WHITE));

        board.getSpot(7,0).setPiece(new Rook(PieceColor.BLACK));
        assertTrue(board.getSpots()[0][0].isBeaten(board,PieceColor.WHITE));

        board.getSpot(7,0).setPiece(null);
        board.getSpot(0,7).setPiece(new Rook(PieceColor.BLACK));
        assertTrue(board.getSpots()[0][0].isBeaten(board,PieceColor.WHITE));

        board.getSpot(0,0).setPiece(null);

        board.getSpot(7,7).setPiece(new Rook(PieceColor.WHITE));
        assertTrue(board.getSpots()[7][7].isBeaten(board,PieceColor.WHITE));

        board.getSpot(0,7).setPiece(null);
        board.getSpot(7,0).setPiece(new Rook(PieceColor.BLACK));
        assertTrue(board.getSpots()[7][7].isBeaten(board,PieceColor.WHITE));

    }
    @Test
    void isNotBeatenByRook() {
        board.getSpot(0,0).setPiece(new Rook(PieceColor.WHITE));

        board.getSpot(7,7).setPiece(new Rook(PieceColor.BLACK));
        assertFalse(board.getSpots()[0][0].isBeaten(board,PieceColor.WHITE));

    }
    @Test
    void isBeatenByBishop() {
        board.getSpot(0, 0).setPiece(new Bishop(PieceColor.WHITE));

        board.getSpot(2, 2).setPiece(new Bishop(PieceColor.BLACK));
        assertTrue(board.getSpot(0,0).isBeaten(board, PieceColor.WHITE));

        board.getSpot(2, 2).setPiece(null);
        board.getSpot(4, 0).setPiece(new Bishop(PieceColor.BLACK));
        assertFalse(board.getSpots()[0][0].isBeaten(board, PieceColor.WHITE));

        board.getSpot(0, 0).setPiece(null);

        board.getSpot(7, 3).setPiece(new Bishop(PieceColor.WHITE));
        assertTrue(board.getSpots()[7][3].isBeaten(board, PieceColor.WHITE));

        board.getSpot(4, 0).setPiece(null);
        board.getSpot(3, 7).setPiece(new Bishop(PieceColor.BLACK));
        assertTrue(board.getSpots()[7][3].isBeaten(board, PieceColor.WHITE));
    }
    @Test
    void isNotBeatenByBishop() {
        board.getSpot(0, 0).setPiece(new Bishop(PieceColor.WHITE));
        board.getSpot(2, 0).setPiece(new Bishop(PieceColor.BLACK));
        assertFalse(board.getSpot(0,0).isBeaten(board, PieceColor.WHITE));

        board.getSpot(2, 0).setPiece(null);
        board.getSpot(0, 2).setPiece(new Bishop(PieceColor.BLACK));
        board.printBoard();
        assertFalse(board.getSpot(0,0).isBeaten(board, PieceColor.WHITE));
    }
    @Test
    void isBeatenByQueen() {
        board.getSpot(0, 0).setPiece(new Queen(PieceColor.WHITE));

        board.getSpot(7, 7).setPiece(new Queen(PieceColor.BLACK));
        assertTrue(board.getSpots()[0][0].isBeaten(board, PieceColor.WHITE));

        board.getSpot(7, 7).setPiece(null);
        board.getSpot(7, 0).setPiece(new Queen(PieceColor.BLACK));
        assertTrue(board.getSpots()[0][0].isBeaten(board, PieceColor.WHITE));

        board.getSpot(0, 0).setPiece(null);

        board.getSpot(7, 7).setPiece(new Queen(PieceColor.WHITE));
        assertTrue(board.getSpots()[7][7].isBeaten(board, PieceColor.WHITE));

        board.getSpot(7, 0).setPiece(null);
        board.getSpot(0, 7).setPiece(new Queen(PieceColor.BLACK));
        assertTrue(board.getSpots()[7][7].isBeaten(board, PieceColor.WHITE));
    }
    @Test
    void isBeatenByPawn() {
        board.getSpot(1, 1).setPiece(new Pawn(PieceColor.BLACK));

        board.getSpot(2, 2).setPiece(new Pawn(PieceColor.WHITE));
        assertTrue(board.getSpots()[2][2].isBeaten(board, PieceColor.WHITE));
        assertTrue(board.getSpots()[1][1].isBeaten(board, PieceColor.BLACK));

        board.getSpot(1, 1).setPiece(null);
        board.getSpot(1, 3).setPiece(new Pawn(PieceColor.BLACK));
        assertTrue(board.getSpots()[2][2].isBeaten(board, PieceColor.WHITE));
        assertTrue(board.getSpots()[1][3].isBeaten(board, PieceColor.BLACK));
    }




}
