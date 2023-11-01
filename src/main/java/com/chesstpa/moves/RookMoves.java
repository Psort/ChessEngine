package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Piece;
import com.chesstpa.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RookMoves {

    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int x = spot.getPosition().getX();
        int y = spot.getPosition().getY();
        PieceColor pieceColor = spot.getPiece().getColor();

        // Check downward moves
        for (int i = x + 1; i <Board.SIZE; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, i, y)) {
                break;
            }
        }

        // Check upward moves
        for (int i = x - 1; i >= 0; i--) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, i, y)) {
                break;
            }
        }

        // Check right moves
        for (int i = y + 1; i < Board.SIZE; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, x, i)) {
                break;
            }
        }

        // Check left moves
        for (int i = y - 1; i >= 0; i--) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, x, i)) {
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
