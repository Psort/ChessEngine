package com.chesstpa.board;

import com.chesstpa.pieces.*;

import java.util.List;

public class Board {
    public final static int SIZE = 8;
    private Piece[][] board = new Piece[SIZE][SIZE];
    public Board(List<Piece> pieces) {
        for (Piece piece:
             pieces) {
            putPiecesOnBoard(piece);
        }
    }
    private void putPiecesOnBoard(Piece piece){
        board[piece.getCoordinates().getX()][piece.getCoordinates().getY()] = piece;
    }

    public Piece getPiece(Coordinates coordinates) {
        return board[coordinates.getX()][coordinates.getY()];
    }

    public void changePositionsPiece(Piece piece) {
            board[piece.getCoordinates().getX()][piece.getCoordinates().getX()] = piece;
    }

    public Piece[][] getboard() {
        return board;
    }

    public void deletePiece(Piece piece) {
        board[piece.getCoordinates().getX()][piece.getCoordinates().getX()] = null;
    }
}
