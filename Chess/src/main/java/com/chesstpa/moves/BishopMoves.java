package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class BishopMoves {
    public List<Spot> getDiagonalPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int x = spot.getX();
        int y = spot.getY();

        // Check moves to the down-right
        for (int i = 1; x + i < board.getSpots().length && y + i < board.getSpots()[x + i].length; i++) {
            if (checkAndUpdateMove(board, possibleMoves, x + i, y + i)) {
                break;
            }
        }

        // Check moves to the up-left
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (checkAndUpdateMove(board, possibleMoves, x - i, y - i)) {
                break;
            }
        }

        // Check moves to the down-left
        for (int i = 1; x + i < board.getSpots().length && y - i >= 0; i++) {
            if (checkAndUpdateMove(board, possibleMoves, x + i, y - i)) {
                break;
            }
        }

        // Check moves to the up-right
        for (int i = 1; x - i >= 0 && y + i < board.getSpots()[x - i].length; i++) {
            if (checkAndUpdateMove(board, possibleMoves, x - i, y + i)) {
                break;
            }
        }

        return possibleMoves;
    }
    private boolean checkAndUpdateMove(Board board, List<Spot> possibleMoves, int x, int y) {
        Spot currentSpot = board.getSpots()[x][y];
        Piece pieceChecked = currentSpot.getPiece();

        if (pieceChecked == null) {
            possibleMoves.add(currentSpot);
            return false;  // Possible move, but continue checking further
        } else if (pieceChecked.getColor() != currentSpot.getPiece().getColor()) {
            possibleMoves.add(currentSpot);
        }

        return true;
    }
}
