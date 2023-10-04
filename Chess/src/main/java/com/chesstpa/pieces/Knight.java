package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.List;

public class Knight extends Piece{

    public Knight(PieceColor color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public List<Coordinates> getPossibleMoves(Board board) {
        return null;
    }


}
