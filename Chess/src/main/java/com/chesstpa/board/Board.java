package com.chesstpa.board;

import com.chesstpa.pieces.Piece;

import java.util.List;

public class Board {
    private final int SIZE = 8;
    private Piece[][] board = new Piece[SIZE][SIZE];
    public Board(List<Piece> pieces) {
        putPiecesOnBoard(pieces);
    }
    private void putPiecesOnBoard(List<Piece> pieces){
        for(Piece piece: pieces){
            board[piece.getCoordinates().getX()][piece.getCoordinates().getY()] = piece;
        }
    }
}
