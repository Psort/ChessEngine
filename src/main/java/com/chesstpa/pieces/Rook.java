package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.RookMoves;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rook extends Piece  {
    private final RookMoves rookMoves = new RookMoves();

    public Rook(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot){
        List<Spot> possibleMoves = rookMoves.getPossibleMoves(board,spot);
        return filterMoves(board,possibleMoves, spot);
    }

    @Override
    public List<Spot> getBeatenSpot(Board board, Spot spot) {
        return rookMoves.getPossibleMoves(board,spot);
    }


}
