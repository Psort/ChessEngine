package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KnightMoves;

import java.util.List;

public class Knight extends Piece{
    private final KnightMoves knightMoves = new KnightMoves();

    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = knightMoves.getPossibleMoves(board, spot);
        return filterMoves(board,possibleMoves, spot);
    }

    @Override
    public List<Spot> getBeatenSpot(Board board, Spot spot) {
        return knightMoves.getPossibleMoves(board, spot);
    }

}
