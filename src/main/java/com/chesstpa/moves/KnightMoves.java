package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Piece;
import com.chesstpa.pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class KnightMoves {
    private final int[][] knightMoves = PieceType.KNIGHT.getMoves();

    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();

        int x = spot.getPosition().getX();
        int y = spot.getPosition().getY();

        for (int[] move : knightMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            // Check if new positions are within the board boundaries
            if (isValidMove(newX, newY)) {
                Spot destinationSpot = board.getSpots()[newX][newY];
                // Check if the spot is empty or occupied by an opponent's piece
                if (destinationSpot.isEmpty() || destinationSpot.getPiece().getColor() != spot.getPiece().getColor()) {
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