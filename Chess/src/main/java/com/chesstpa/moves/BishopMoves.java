package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Piece;
import com.chesstpa.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class BishopMoves {
    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        PieceColor pieceColor = spot.getPiece().getColor();
        int x = spot.getX();
        int y = spot.getY();

        // Check moves to the down-right
        for (int i = 1; x + i < board.getSpots().length && y + i < board.getSpots()[x + i].length; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, x + i, y + i)) {
                break;
            }
        }

        // Check moves to the up-left
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, x - i, y - i)) {
                break;
            }
        }

        // Check moves to the down-left8
        for (int i = 1; x + i < board.getSpots().length && y - i >= 0; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, x + i, y - i)) {
                break;
            }
        }

        // Check moves to the up-right
        for (int i = 1; x - i >= 0 && y + i < board.getSpots()[x - i].length; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, x - i, y + i)) {
                break;
            }
        }

        return possibleMoves;
    }

    private boolean checkAndUpdateMove(Board board, List<Spot> possibleMoves,PieceColor pieceColor, int x, int y) {
        Spot currentSpot = board.getSpots()[x][y];
        Piece pieceChecked = currentSpot.getPiece();

        if (currentSpot.isEmpty()) {
            possibleMoves.add(currentSpot);
            return false;  // Move is possible, continue checking further
        } else if(pieceChecked.getColor() != pieceColor){
            possibleMoves.add(currentSpot);
            return true;
        }
        else {
            return true;  // Stop checking, there's a piece in the way
        }
    }
}
