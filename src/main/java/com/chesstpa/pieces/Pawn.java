package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.PawnMoves;

import java.util.List;

public class Pawn extends Piece {
    private  final PawnMoves pawnMoves = new PawnMoves();


    public Pawn(PieceColor color) {
        super(color);
    }


    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = pawnMoves.getPossibleMoves(board,spot);
        return filterMoves(board,possibleMoves, spot);
    }

    @Override
    public List<Spot> getBeatenSpot(Board board, Spot spot) {
        return pawnMoves.getBeatenSpot(board,spot);
    }


}
