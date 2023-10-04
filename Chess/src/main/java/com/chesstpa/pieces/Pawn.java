package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{


    public Pawn(PieceColor color, Coordinates coordinates, List<Piece> pieces) {
        super(color, coordinates, pieces);
    }

    @Override
    public List<Coordinates> getPossibleMoves(Board board) {
        return new ArrayList<>(List.of(new Coordinates(4,2)));
    }


}
