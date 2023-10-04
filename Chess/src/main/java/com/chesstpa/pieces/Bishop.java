package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.List;

public class Bishop extends Piece{
    public Bishop(PieceColor color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public List<Coordinates> getPossibleMoves(Board board) {
        return null;
    }

}
