package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.List;

public class Queen extends Piece{

    public Queen(PieceColor color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public List<Coordinates> getPossibleMoves(Board board) {
        return null;
    }


}
