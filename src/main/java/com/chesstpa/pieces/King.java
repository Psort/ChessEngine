package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.KingMoves;

import java.util.List;

public class King extends Piece {

    KingMoves kingMoves = new KingMoves();

    private boolean shortCastle ;
    private boolean longCastle ;


    public King(PieceColor color) {
        super(color);
    }


    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = kingMoves.getPossibleMoves(board,spot);
        return filterPositionByKingCheck(board,possibleMoves,spot);
    }

    public boolean hasShortCastle() {
        return shortCastle;
    }

    public void setShortCastle(boolean shortCastle) {
        this.shortCastle = shortCastle;
    }

    public boolean hasLongCastle() {
        return longCastle;
    }

    public void setLongCastle(boolean longCastle) {
        this.longCastle = longCastle;
    }
}
