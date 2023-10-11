package spot;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.King;
import com.chesstpa.pieces.Knight;
import com.chesstpa.pieces.PieceColor;
import com.chesstpa.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpotTest {
    @Test
    void isBeatenByKnight() {
        Board board = getNullBoard();
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
        Board board = getNullBoard();
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
        Board board = getNullBoard();
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


    private Board getNullBoard(){
        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.getSpots()[i][j] = new Spot(i, j, null);
            }
        }
        return board;
    }

}
