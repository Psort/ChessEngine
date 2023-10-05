package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean hasFirstMove = true;

    public Pawn(PieceColor color) {
        super(color);
    }

}
