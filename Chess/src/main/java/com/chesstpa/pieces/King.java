package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KingMoves;
import com.chesstpa.moves.KnightMoves;

import java.util.List;

public class King extends Piece {

    KingMoves kingMoves = new KingMoves();

    private boolean hasMoved = false;

    public King(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        return kingMoves.getPossibleMoves(board,spot);
    }

    public boolean hasMoved() {
        return this.hasMoved;
    }
}
