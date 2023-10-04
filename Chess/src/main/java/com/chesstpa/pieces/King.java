package com.chesstpa.pieces;

import com.chesstpa.board.Board;

import java.util.List;

public class King extends Piece {

    private boolean hasCastling = true;

    public King(PieceColor color, Coordinates coordinates, List<Piece> pieces) {
        super(color, coordinates, pieces);


    @Override
    public void move(Coordinates coordinates) {
        if (hasCastling){
            hasCastling = false;
        }
        this.coordinates = coordinates;
    }
    @Override
    public List<Coordinates> getPossibleMoves(Board board) {
        return null;
    }


}
