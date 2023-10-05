package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class RookMoves {

    public List<Spot> getVerticalPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int nextPosition = spot.getX() +1;
        int previousPosition = spot.getX() -1;

        // Check for moves to the down
        for (int i = nextPosition; i < board.getSpots().length; i++) {
            if (checkAndUpdateMove(board, possibleMoves, i, spot.getY())) {
                break;
            }
        }

        //Check for moves to the up
        for (int i = previousPosition; i >= 0; i--) {
            if (checkAndUpdateMove(board, possibleMoves, i, spot.getY())) {
                break;
            }
        }

        return possibleMoves;
    }

    public List<Spot> getHorizontalPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int nextPosition = spot.getY() +1;
        int previousPosition = spot.getY() -1;

        // Sprawdź ruchy w right
        for (int i = nextPosition; i < board.getSpots()[spot.getX()].length; i++) {
            if (checkAndUpdateMove(board, possibleMoves, spot.getX(), i)) {
                break;
            }
        }

        // Check the moves to the left
        for (int i = previousPosition; i >= 0; i--) {
            if (checkAndUpdateMove(board, possibleMoves, spot.getX(), i)) {
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
