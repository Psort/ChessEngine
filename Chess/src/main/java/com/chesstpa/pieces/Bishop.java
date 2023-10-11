package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.BishopMoves;

import java.util.List;

public class Bishop extends Piece{
    private final BishopMoves bishopMoves = BishopMoves.getInstance();
    public Bishop(PieceColor color) {
        super(color);
    }

    @Override
    public void move(Board board,Spot currentSpot,Spot nextSpot) {
        board.swapSpots(currentSpot, nextSpot);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = bishopMoves.getPossibleMoves(board,spot);
        PieceColor color = this.getColor();

        if (board.kingIsCheck(color)) {
            possibleMoves.removeIf(move -> move.safeKing(board, color,this));
        }
        return possibleMoves;
    }

}
