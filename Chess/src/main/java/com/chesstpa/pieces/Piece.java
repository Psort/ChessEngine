package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.List;

public abstract class Piece {
    private PieceColor color;
    private Coordinates coordinates;

    public void move(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Piece(PieceColor color, Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public abstract List<Coordinates> getPossibleMoves(Board board);
}
