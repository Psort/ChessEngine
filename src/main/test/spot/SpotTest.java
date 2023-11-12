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
        board.getSpot(4,3).setPiece(new Rook(PieceColor.White));
        board.getSpot(2,2).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpot(2,2).setPiece(null);
        board.getSpot(2,4).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpot(2,4).setPiece(null);
        board.getSpot(3,1).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpot(3,1).setPiece(null);
        board.getSpot(3,5).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpot(3,5).setPiece(null);
        board.getSpot(5,1).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpot(5,1).setPiece(null);
        board.getSpot(5,5).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpot(5,5).setPiece(null);
        board.getSpot(6,2).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpot(6,2).setPiece(new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));
    }
    @Test
    void isBeatenByKing() {
        board.getSpot(4,3).setPiece(new Rook(PieceColor.White));

        // Check if the spot (4, 3) is attacked by a king at different positions

        // Upper adjacent spot
        board.getSpot(3,3).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Lower adjacent spot
        board.getSpot(5,3).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Left adjacent spot
        board.getSpot(4,2).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Right adjacent spot
        board.getSpot(4,4).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Extreme spots diagonally
        board.getSpot(3,2).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        board.getSpot(5,4).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        board.getSpot(3,4).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        board.getSpot(5,2).setPiece(new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

    }
    @Test
    void isBeatenByRook() {
        board.getSpot(0,0).setPiece(new Rook(PieceColor.White));

        board.getSpot(7,0).setPiece(new Rook(PieceColor.Black));
        assertTrue(board.getSpots()[0][0].isBeaten(board,PieceColor.White));

        board.getSpot(7,0).setPiece(null);
        board.getSpot(0,7).setPiece(new Rook(PieceColor.Black));
        assertTrue(board.getSpots()[0][0].isBeaten(board,PieceColor.White));

        board.getSpot(0,0).setPiece(null);

        board.getSpot(7,7).setPiece(new Rook(PieceColor.White));
        assertTrue(board.getSpots()[7][7].isBeaten(board,PieceColor.White));

        board.getSpot(0,7).setPiece(null);
        board.getSpot(7,0).setPiece(new Rook(PieceColor.Black));
        assertTrue(board.getSpots()[7][7].isBeaten(board,PieceColor.White));

    }
    @Test
    void isBeatenByBishop() {
        board.getSpot(0, 0).setPiece(new Bishop(PieceColor.White));

        board.getSpot(2, 2).setPiece(new Bishop(PieceColor.Black));
        assertTrue(board.getSpot(0,0).isBeaten(board, PieceColor.White));

        board.getSpot(2, 2).setPiece(null);
        board.getSpot(4, 0).setPiece(new Bishop(PieceColor.Black));
        assertFalse(board.getSpots()[0][0].isBeaten(board, PieceColor.White));

        board.getSpot(0, 0).setPiece(null);

        board.getSpot(7, 3).setPiece(new Bishop(PieceColor.White));
        assertTrue(board.getSpots()[7][3].isBeaten(board, PieceColor.White));

        board.getSpot(4, 0).setPiece(null);
        board.getSpot(3, 7).setPiece(new Bishop(PieceColor.Black));
        assertTrue(board.getSpots()[7][3].isBeaten(board, PieceColor.White));
    }
    @Test
    void isBeatenByQueen() {
        board.getSpot(0, 0).setPiece(new Queen(PieceColor.White));

        board.getSpot(7, 7).setPiece(new Queen(PieceColor.Black));
        assertTrue(board.getSpots()[0][0].isBeaten(board, PieceColor.White));

        board.getSpot(7, 7).setPiece(null);
        board.getSpot(7, 0).setPiece(new Queen(PieceColor.Black));
        assertTrue(board.getSpots()[0][0].isBeaten(board, PieceColor.White));

        board.getSpot(0, 0).setPiece(null);

        board.getSpot(7, 7).setPiece(new Queen(PieceColor.White));
        assertTrue(board.getSpots()[7][7].isBeaten(board, PieceColor.White));

        board.getSpot(7, 0).setPiece(null);
        board.getSpot(0, 7).setPiece(new Queen(PieceColor.Black));
        assertTrue(board.getSpots()[7][7].isBeaten(board, PieceColor.White));
    }
    @Test
    void isBeatenByPawn() {
        board.getSpot(1, 1).setPiece(new Pawn(PieceColor.Black));

        board.getSpot(2, 2).setPiece(new Pawn(PieceColor.White));
        assertTrue(board.getSpots()[2][2].isBeaten(board, PieceColor.White));
        assertTrue(board.getSpots()[1][1].isBeaten(board, PieceColor.Black));

        board.getSpot(1, 1).setPiece(null);
        board.getSpot(1, 3).setPiece(new Pawn(PieceColor.Black));
        assertTrue(board.getSpots()[2][2].isBeaten(board, PieceColor.White));
        assertTrue(board.getSpots()[1][3].isBeaten(board, PieceColor.Black));
    }




}
