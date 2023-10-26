package board;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class boardTest {
    @Test
    void isCheckMateTest() {
        //initialize Piece
        Board board = new Board();
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
        Board board = new Board();
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
        Board board = new Board();
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
        Board board = new Board();
        board.getSpot(3,4).setPiece(new King(PieceColor.White));
        board.getSpot(5,2).setPiece(new King(PieceColor.Black));

        assertTrue(board.isPat(PieceColor.White));
    }
    @Test
    void isNotPatTest() {
        //initialize Piece
        Board board = new Board();
        board.getSpot(7,6).setPiece(new King(PieceColor.White));
        board.getSpot(0,6).setPiece(new Rook(PieceColor.Black));
        board.getSpot(5,0).setPiece(new Rook(PieceColor.Black));
        //move King
        Spot kingSpot = board.getSpot(7,6);
        Spot nextSpot = board.getSpot(7,7);
        kingSpot.getPiece().move(board, kingSpot,nextSpot);


        assertFalse(board.isPat(PieceColor.White));
    }
    @Test
    void isTest() {
        //initialize Piece
        Board board = new Board();
        board.getSpot(0,0).setPiece(new Rook(PieceColor.Black));
        board.getSpot(0,1).setPiece(new Knight(PieceColor.Black));
        board.getSpot(0,2).setPiece(new Bishop(PieceColor.Black));
        board.getSpot(0,3).setPiece(new Queen(PieceColor.Black));
        board.getSpot(0,4).setPiece(new King(PieceColor.Black));
        board.getSpot(0,5).setPiece(new Bishop(PieceColor.Black));
        board.getSpot(0,6).setPiece(new Knight(PieceColor.Black));
        board.getSpot(0,7).setPiece(new Rook(PieceColor.Black));
        board.getSpot(1,0).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,1).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,2).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,3).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,4).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,5).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,6).setPiece(new Pawn(PieceColor.Black));
        board.getSpot(1,7).setPiece(new Pawn(PieceColor.Black));

        board.getSpot(1,5).setPiece(new Queen(PieceColor.White));
        board.getSpot(2,4).setPiece(new Queen(PieceColor.White));
        assertTrue(board.isCheckMate(PieceColor.Black));
    }

}
