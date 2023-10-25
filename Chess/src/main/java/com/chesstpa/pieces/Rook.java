package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.RookMoves;

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
    public void move(Board board,Spot currentSpot,Spot nextSpot) {
        if(!hasMoved){
            hasMoved = true;
        }
        board.swapSpots(currentSpot, nextSpot);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board,Spot spot){
        List<Spot> verticalMoves = rookMoves.getVerticalPossibleMoves(board,spot);
        List<Spot> horizontalMoves = rookMoves.getHorizontalPossibleMoves(board,spot);
        List<Spot> possibleMoves = Stream.concat(verticalMoves.stream(), horizontalMoves.stream()).collect(Collectors.toList());
        PieceColor color = this.getColor();

        if (board.kingIsCheck(color)) {
            possibleMoves.removeIf(move -> move.safeKing(board, color,this));
        }
        return possibleMoves;
    }


    public boolean isHasMoved() {
        return hasMoved;
    }
}
