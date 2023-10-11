package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KnightMoves;
import com.chesstpa.moves.PawnMoves;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private  final PawnMoves pawnMoves = PawnMoves.getInstance();
    private boolean hasMoved = false;
    private boolean isFirstMove = false;

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public void move(Board board,Spot currentSpot,Spot nextSpot) {
        if(isFirstMove){
            isFirstMove = false;
        }
        if(!hasMoved){
            hasMoved = true;
            isFirstMove = true;
        }
        board.getSpots()[nextSpot.getX()][nextSpot.getY()].setPiece(currentSpot.getPiece());
        board.getSpots()[currentSpot.getX()][currentSpot.getY()].setPiece(null);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = pawnMoves.getPossibleMoves(board,spot);
        PieceColor color = spot.getPiece().getColor();

        if (board.getKingSpot(color).isBeaten(board, color)) {
            possibleMoves.removeIf(move -> move.safeKing(board, color,this));
        }
        return possibleMoves;
    }
    public boolean hasMoved(){
        return hasMoved;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

}
