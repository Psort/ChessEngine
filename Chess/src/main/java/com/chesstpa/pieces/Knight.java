package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KnightMoves;

import java.util.List;

public class Knight extends Piece{
    private final KnightMoves knightMoves = KnightMoves.getInstance();

    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public void move(Board board,Spot currentSpot,Spot nextSpot) {
        board.getSpots()[nextSpot.getX()][nextSpot.getY()].setPiece(currentSpot.getPiece());
        board.getSpots()[currentSpot.getX()][currentSpot.getY()].setPiece(null);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = knightMoves.getPossibleMoves(board, spot);
        PieceColor color = spot.getPiece().getColor();

        if (board.getKingSpot(color).isBeaten(board, color)) {
            possibleMoves.removeIf(move -> move.safeKing(board, color,this));
        }

        return possibleMoves;
    }

}
