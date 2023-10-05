package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean hasFirstMove = true;

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        return null;
    }

}
