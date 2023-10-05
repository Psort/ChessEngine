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

        if (pawn.getColor() == PieceColor.Black && pawn.doesHasFirstMove() && isFirstSpotEmpty(board, spot, pawn)) {
            spotToMove = spots[nextSpotForBlackPiece][spot.getY()];
            return spotToMove;
        } else if (pawn.getColor() == PieceColor.White && pawn.doesHasFirstMove() && isFirstSpotEmpty(board, spot, pawn)) {
            spotToMove = spots[nextSpotForWhitePiece][spot.getY()];
            return spotToMove;
        }
        else return null;
    }
    public List<Spot> getPossibleCapture(Board board, Spot spot) {
        Spot[][] spots = board.getSpots();
        Piece piece = spot.getPiece();
        int xForwardPosition = piece.getColor() == PieceColor.Black ? spot.getX() + 1 : spot.getX() - 1;
        int yRightPosition = spot.getY() + 1;
        int yLeftPosition = spot.getY() - 1;

        List<Spot> possibleCaptures = new ArrayList<>();

        if (isRightCaptureValid(yRightPosition)) {
            Spot rightCaptureSpot = spots[xForwardPosition][yRightPosition];
            if (isCaptureValid(rightCaptureSpot, piece)) {
                possibleCaptures.add(rightCaptureSpot);
            }
        }

        if (isLeftCaptureValid(yLeftPosition)) {
            Spot leftCaptureSpot = spots[xForwardPosition][yLeftPosition];
            if (isCaptureValid(leftCaptureSpot, piece)) {
                possibleCaptures.add(leftCaptureSpot);
            }
        }

        return possibleCaptures;
    }

    private boolean isRightCaptureValid(int y) {
        return y <= 6;
    }

    private boolean isLeftCaptureValid(int y) {
        return y >= 1;
    }

    private boolean isCaptureValid(Spot spot, Piece piece) {
        return spot != null && spot.getPiece() != null && spot.getPiece().getColor() != piece.getColor();
    }
    private boolean isFirstSpotEmpty(Board board, Spot spot, Piece piece){
        Spot firstSpot;
        if(piece.getColor().equals(PieceColor.Black)) {
            firstSpot = board.getSpot(spot.getX() + 1, spot.getY());
        } else firstSpot = board.getSpot(spot.getX() - 1, spot.getY());
        return firstSpot.getPiece() == null;
    }
}
