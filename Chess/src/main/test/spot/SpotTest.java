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
        board.getSpots()[4][3] = new Spot(4, 3,new Rook(PieceColor.White));
        board.getSpots()[2][2] = new Spot(2, 2,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpots()[2][2] = new Spot(2, 2,null);
        board.getSpots()[2][4] = new Spot(2, 4,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpots()[2][4] = new Spot(2, 4,null);
        board.getSpots()[3][1] = new Spot(3, 1,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpots()[3][1] = new Spot(3, 1,null);
        board.getSpots()[3][5] = new Spot(3, 5,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpots()[3][5] = new Spot(3, 5,null);
        board.getSpots()[5][1] = new Spot(5, 1,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpots()[5][1] = new Spot(5, 1,null);
        board.getSpots()[5][5] = new Spot(5, 5,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpots()[5][5] = new Spot(5, 5,null);
        board.getSpots()[6][2] = new Spot(6, 2,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));

        board.getSpots()[6][2] = new Spot(6, 2,null);
        board.getSpots()[6][4] = new Spot(6, 4,new Knight(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board, PieceColor.White));
    }
    @Test
    void isBeatenByKing() {
        Board board = getNullBoard();
        board.getSpots()[4][3] = new Spot(4, 3, new Rook(PieceColor.White));

        // Check if the spot (4, 3) is attacked by a king at different positions

        // Upper adjacent spot
        board.getSpots()[3][3] = new Spot(3, 3, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Lower adjacent spot
        board.getSpots()[5][3] = new Spot(5, 3, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Left adjacent spot
        board.getSpots()[4][2] = new Spot(4, 2, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Right adjacent spot
        board.getSpots()[4][4] = new Spot(4, 4, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        // Extreme spots diagonally
        board.getSpots()[3][2] = new Spot(3, 2, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        board.getSpots()[5][4] = new Spot(5, 4, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        board.getSpots()[3][4] = new Spot(3, 4, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

        board.getSpots()[5][2] = new Spot(5, 2, new King(PieceColor.Black));
        assertTrue(board.getSpots()[4][3].isBeaten(board,PieceColor.White));

    }
    @Test
    void isBeatenByRook() {
        Board board = getNullBoard();
        board.getSpots()[0][0] = new Spot(0, 0, new Rook(PieceColor.White));

        board.getSpots()[7][0] = new Spot(7, 0, new Rook(PieceColor.Black));
        assertTrue(board.getSpots()[0][0].isBeaten(board,PieceColor.White));

        board.getSpots()[7][0] = new Spot(7, 0, null);
        board.getSpots()[0][7] = new Spot(0, 7, new Rook(PieceColor.Black));
        assertTrue(board.getSpots()[0][0].isBeaten(board,PieceColor.White));

        board.getSpots()[0][0] = new Spot(0, 0, null);

        board.getSpots()[7][7] = new Spot(7, 7, new Rook(PieceColor.White));
        assertTrue(board.getSpots()[7][7].isBeaten(board,PieceColor.White));

        board.getSpots()[0][7] = new Spot(0, 7, null);
        board.getSpots()[7][0] = new Spot(7, 0, new Rook(PieceColor.Black));
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
