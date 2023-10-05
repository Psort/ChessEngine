package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.List;

public class King extends Piece {

    private boolean hasCastling = true;

    public King(PieceColor color) {
        super(color);
    }
}
