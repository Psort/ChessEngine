package board;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class boardTest {
    @Test
    void isCheckMateTest() {
        //initialize Piece
        Board board = getNullBoard();
        board.getSpot(7,6).setPiece(new King(PieceColor.White));
        board.getSpot(0,6).setPiece(new Rook(PieceColor.Black));
        board.getSpot(0,7).setPiece(new Rook(PieceColor.Black));
        //move King
        Spot kingSpot = board.getSpot(7,6);
        Spot nextSpot = board.getSpot(7,7);
        kingSpot.getPiece().move(board, kingSpot,nextSpot);

        assertTrue(board.isCheckMate(PieceColor.White));
    }
    @Test
    void isNotCheckMateTest() {
        //initialize Piece
        Board board = getNullBoard();
        board.getSpot(7,6).setPiece(new King(PieceColor.White));
        board.getSpot(0,6).setPiece(new Rook(PieceColor.Black));
        //move King
        Spot kingSpot = board.getSpot(7,6);
        Spot nextSpot = board.getSpot(7,7);
        kingSpot.getPiece().move(board, kingSpot,nextSpot);

        assertFalse(board.isCheckMate(PieceColor.White));
    }
    @Test
    void isPatTest() {
        //initialize Piece
        Board board = getNullBoard();
        board.getSpot(7,6).setPiece(new King(PieceColor.White));
        board.getSpot(0,6).setPiece(new Rook(PieceColor.Black));
        board.getSpot(6,0).setPiece(new Rook(PieceColor.Black));
        //move King
        Spot kingSpot = board.getSpot(7,6);
        Spot nextSpot = board.getSpot(7,7);
        kingSpot.getPiece().move(board, kingSpot,nextSpot);

        assertTrue(board.isPat(PieceColor.White));
    }
    @Test
    void isPatWithTwoKingsTest() {
        //initialize Piece
        Board board = getNullBoard();
        board.getSpot(3,4).setPiece(new King(PieceColor.White));
        board.getSpot(5,2).setPiece(new King(PieceColor.Black));

        assertTrue(board.isPat(PieceColor.White));
    }
    @Test
    void isNotPatTest() {
        //initialize Piece
        Board board = getNullBoard();
        board.getSpot(7,6).setPiece(new King(PieceColor.White));
        board.getSpot(0,6).setPiece(new Rook(PieceColor.Black));
        board.getSpot(5,0).setPiece(new Rook(PieceColor.Black));
        //move King
        Spot kingSpot = board.getSpot(7,6);
        Spot nextSpot = board.getSpot(7,7);
        kingSpot.getPiece().move(board, kingSpot,nextSpot);


        assertFalse(board.isPat(PieceColor.White));
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
