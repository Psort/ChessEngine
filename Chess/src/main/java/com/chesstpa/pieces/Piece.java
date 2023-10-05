package com.chesstpa.pieces;


import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.List;

public abstract class Piece {
    protected final PieceColor color;

    public Piece(PieceColor color){
        this.color = color;
    }
    public PieceColor getColor(){
        return this.color;
    }
    public abstract List<Spot> getPossibleMoves(Board board, Spot spot);
}
