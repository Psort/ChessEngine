package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.BishopMoves;
import com.chesstpa.moves.RookMoves;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queen extends Piece {

    private final BishopMoves bishopMoves = new BishopMoves();
    private final RookMoves rookMoves = new RookMoves();
    public Queen(PieceColor color) {
        super(color);
    }
    
    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> rookPossibleMoves = rookMoves.getPossibleMoves(board,spot);
        List<Spot> diagonalMoves = bishopMoves.getPossibleMoves(board,spot);
        List<Spot> possibleMoves = Stream.concat(rookPossibleMoves.stream(), diagonalMoves.stream())
                .collect(Collectors.toList());
        return filterPositionByKingCheck(board,possibleMoves, spot);
    }
}
