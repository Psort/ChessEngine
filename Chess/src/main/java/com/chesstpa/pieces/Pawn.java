package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KnightMoves;
import com.chesstpa.moves.PawnMoves;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private  final PawnMoves pawnMoves = new PawnMoves();
    private boolean hasMoved = false;
    private boolean isFirstMove = false;

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        return pawnMoves.getPossibleMoves(board,spot);
    }
    public boolean hasMoved(){
        return hasMoved;
    }
//    public void setHasMoved(){
//        hasMoved = false;
//    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }
}
