package com.chesstpa.pieces;


public abstract class Piece {
    protected final PieceColor color;

    public Piece(PieceColor color){
        this.color = color;
    }
    public PieceColor getColor(){
        return this.color;
    }
}
