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

    public abstract List<Spot> getPossibleMoves(Board board, Spot spot);
    public abstract List<Spot> getBeatenSpot(Board board, Spot spot);

    protected List<Spot> filterPositionByKingCheck(Board board,List<Spot> possibleMoves){
        if (board.kingIsCheck(color)) {
            possibleMoves.removeIf(move -> move.safeKing(board, color,this));
        }
        return possibleMoves;
    }
}
