package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.List;

public class King extends Piece {

    public King(PieceColor color, Coordinates coordinates, List<Piece> pieces) {
        super(color, coordinates, pieces);
    }

    @Override
    public List<Coordinates> getPossibleMoves(Board board) {
        return null;
    }


}
