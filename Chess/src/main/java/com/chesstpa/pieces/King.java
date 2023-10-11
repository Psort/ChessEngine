package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KingMoves;
import com.chesstpa.moves.KnightMoves;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    KingMoves kingMoves = KingMoves.getInstance();

    private boolean hasMoved = false;

    public King(PieceColor color) {
        super(color);
    }

    @Override
    public void move(Board board,Spot currentSpot,Spot nextSpot) {
        if(!hasMoved){
            hasMoved = true;
        }
        board.getSpots()[nextSpot.getX()][nextSpot.getY()].setPiece(currentSpot.getPiece());
        board.getSpots()[currentSpot.getX()][currentSpot.getY()].setPiece(null);
        board.setKingSpot(nextSpot);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        return kingMoves.getPossibleMoves(board,spot);
    }

    public boolean hasMoved() {
        return this.hasMoved;
    }
}
