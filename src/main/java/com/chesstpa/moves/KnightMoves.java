package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class KnightMoves {

    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();

        int x = spot.getPosition().getX();
        int y = spot.getPosition().getY();

        int[][] knightMoves = {
                {-2, -1}, {-2, 1}, // Moves upper left and upper right
                {-1, -2}, {-1, 2}, // Moves left upper and right upper
                {1, -2}, {1, 2},   // Moves left lower and right lower
                {2, -1}, {2, 1}    // Moves lower left and lower right
        };

        for (int[] move : knightMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            // Check if new positions are within the board boundaries
            if (isValidMove(newX, newY)) {
                Spot destinationSpot = board.getSpots()[newX][newY];
                Piece piece = destinationSpot.getPiece();

                // Check if the spot is empty or occupied by an opponent's piece
                if (destinationSpot.isEmpty() || piece.getColor() != spot.getPiece().getColor()) {
                    possibleMoves.add(destinationSpot);
                }
            }
        }

        return possibleMoves;
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE;
    }
}