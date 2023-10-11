package com.chesstpa.pieces;


import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.List;

public abstract class Piece {

    private final PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }
    public abstract void move(Board board,Spot currentSpot,Spot nextSpot);

    public abstract List<Spot> getPossibleMoves(Board board, Spot spot);
}
