package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.List;

public class King extends Piece {

    private boolean hasCastling = true;

    public King(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        return null;
    }
}
