package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.RookMoves;

import java.util.List;

public class Rook extends Piece  {
    private final char SIMPLENAME = 'r';
    private final RookMoves rookMoves = new RookMoves();

    public Rook(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot){
        List<Spot> possibleMoves = rookMoves.getPossibleMoves(board,spot);
        return filterPositionByKingCheck(board,possibleMoves, spot);
    }

    public char getSimpleName() {
        return SIMPLENAME;
    }
}
