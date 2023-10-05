package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Pawn;
import com.chesstpa.pieces.Piece;
import com.chesstpa.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;
public class BasicMoves {
    public Spot getPossibleSingleMove(Board board, Spot spot){
        Spot[][] spots = board.getSpots();
        Spot spotToMove;
        Piece piece = spot.getPiece();
        int nextSpotForBlackPiece = spot.getX() + 1;
        int nextSpotForWhitePiece = spot.getX() - 1;

        if (piece.getColor() == PieceColor.Black) {
            spotToMove = spots[nextSpotForBlackPiece][spot.getY()];
        } else {
            spotToMove = spots[nextSpotForWhitePiece][spot.getY()];
        }

        if(spotToMove.getPiece() == null) {
            return spotToMove;
        }
        else return null;
    }

    public Spot getPossibleDoubleMove(Board board, Spot spot){
        Spot[][] spots = board.getSpots();
        Spot spotToMove;
        Pawn pawn = (Pawn) spot.getPiece();
        int nextSpotForBlackPiece = spot.getX() + 2;
        int nextSpotForWhitePiece = spot.getX() - 2;

        if (pawn.getColor() == PieceColor.Black && pawn.doesHasFirstMove()) {
            spotToMove = spots[nextSpotForBlackPiece][spot.getY()];
            return spotToMove;
        } else if (pawn.getColor() == PieceColor.White && pawn.doesHasFirstMove()) {
            spotToMove = spots[nextSpotForWhitePiece][spot.getY()];
            return spotToMove;
        }
        else return null;
    }
    public List<Spot> getPossibleCapture(Board board, Spot spot) {
        Spot[][] spots = board.getSpots();
        Spot rightCaptureSpot;
        Spot leftCaptureSpot;
        Piece piece = spot.getPiece();
        int xForwardPositionForBlackPiece = spot.getX() + 1;
        int xForwardPositionForWhitePiece = spot.getX() - 1;
        int yRightPosition = spot.getY() + 1;
        int yLeftPosition = spot.getY() - 1;

        if (piece.getColor() == PieceColor.Black) {
            rightCaptureSpot = spots[xForwardPositionForBlackPiece][yRightPosition];
            leftCaptureSpot = spots[xForwardPositionForBlackPiece][yLeftPosition];
        } else {
            rightCaptureSpot = spots[xForwardPositionForWhitePiece][yRightPosition];
            leftCaptureSpot = spots[xForwardPositionForWhitePiece][yLeftPosition];
        }

        List<Spot> possibleCaptures = new ArrayList<>(List.of(leftCaptureSpot, rightCaptureSpot));

        return possibleCaptures.stream()
                .filter(s -> s.getPiece() != null)
                .filter(s -> s.getPiece().getColor() != piece.getColor())
                .toList();
    }

}
