package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KnightMoves;

import java.util.List;

public class Knight extends Piece{
    private final char SIMPLENAME = 'n';
    private final KnightMoves knightMoves = new KnightMoves();

    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = knightMoves.getPossibleMoves(board, spot);
        return filterPositionByKingCheck(board,possibleMoves, spot);
    }

    public char getSimpleName() {
        return SIMPLENAME;
    }
}
