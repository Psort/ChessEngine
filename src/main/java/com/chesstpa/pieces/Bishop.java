package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.BishopMoves;

import java.util.List;

public class Bishop extends Piece{
    private final char SIMPLENAME = 'b';
    private final BishopMoves bishopMoves =new BishopMoves();
    public Bishop(PieceColor color) {
        super(color);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = bishopMoves.getPossibleMoves(board,spot);
        return filterPositionByKingCheck(board,possibleMoves, spot);
    }
    public char getSimpleName(){
        return SIMPLENAME;
    }
}
