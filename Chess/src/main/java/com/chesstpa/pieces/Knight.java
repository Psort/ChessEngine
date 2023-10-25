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
    public void move(Board board,Spot currentSpot,Spot nextSpot) {
        board.swapSpots(currentSpot, nextSpot);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = knightMoves.getPossibleMoves(board, spot);
        PieceColor color = this.getColor();

        if (board.kingIsCheck(color)) {
            possibleMoves.removeIf(move -> move.safeKing(board, color,this));
        }

        return possibleMoves;
    }

}
