package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.RookMoves;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rook extends Piece  {
    private final RookMoves rookMoves = new RookMoves();

    private boolean hasMoved = false;
    public Rook(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board,Spot spot){
        List<Spot> verticalMoves = rookMoves.getVerticalPossibleMoves(board,spot);
        List<Spot> horizontalMoves = rookMoves.getHorizontalPossibleMoves(board,spot);
        return Stream.concat(verticalMoves.stream(), horizontalMoves.stream()).collect(Collectors.toList());
    }


}
