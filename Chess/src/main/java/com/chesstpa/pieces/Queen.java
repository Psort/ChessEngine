package com.chesstpa.pieces;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.moves.BishopMoves;
import com.chesstpa.moves.RookMoves;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queen extends Piece {

    private final BishopMoves bishopMoves = BishopMoves.getInstance();
    private final RookMoves rookMoves = RookMoves.getInstance();
    public Queen(PieceColor color) {
        super(color);
    }

    @Override
    public void move(Board board,Spot currentSpot,Spot nextSpot) {
        board.getSpots()[nextSpot.getX()][nextSpot.getY()].setPiece(currentSpot.getPiece());
        board.getSpots()[currentSpot.getX()][currentSpot.getY()].setPiece(null);
    }

    @Override
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> verticalMoves = rookMoves.getVerticalPossibleMoves(board,spot);
        List<Spot> horizontalMoves = rookMoves.getHorizontalPossibleMoves(board,spot);
        List<Spot> diagonalMoves = bishopMoves.getPossibleMoves(board,spot);
        List<Spot> possibleMoves = Stream.concat(Stream.concat(verticalMoves.stream(), horizontalMoves.stream()), diagonalMoves.stream())
                .collect(Collectors.toList());
        PieceColor color = spot.getPiece().getColor();

        if (board.getKingSpot(color).isBeaten(board, color)) {
            possibleMoves.removeIf(move -> move.safeKing(board, color,this));
        }
        return possibleMoves;
    }

}
