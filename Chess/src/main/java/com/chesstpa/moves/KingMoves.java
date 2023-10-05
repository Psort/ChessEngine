package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.King;
import com.chesstpa.pieces.PieceColor;
import com.chesstpa.pieces.Rook;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class KingMoves {

    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int x = spot.getX();
        int y = spot.getY();

        int[][] moves = {
                {-1, -1}, {-1, 0}, {-1, 1}, // Ruchy do góry
                {0, -1}, /* Obecne pole */ {0, 1}, // Ruchy w lewo i w prawo
                {1, -1}, {1, 0}, {1, 1} // Ruchy w dół
        };

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (isValidMove(newX, newY, board, spot.getPiece().getColor())) {
                possibleMoves.add(board.getSpots()[newX][newY]);
            }
        }

        // Dodaj możliwość roszady
        if (canCastleKingside(board, spot)) {
            possibleMoves.add(board.getSpots()[x][y + 2]);
        }
        if (canCastleQueenside(board, spot)) {
            possibleMoves.add(board.getSpots()[x][y - 2]);
        }

        return possibleMoves;
    }

    private boolean isValidMove(int x, int y, Board board, PieceColor color) {
        return x >= 0 && x < board.getSpots().length && y >= 0 && y < board.getSpots()[x].length
                && (board.getSpots()[x][y].getPiece() == null
                || board.getSpots()[x][y].getPiece().getColor() != color);
    }

    private boolean canCastleKingside(Board board, Spot spot) {
        // Sprawdź, czy król i wieża są na swoich oryginalnych pozycjach
        int x = spot.getX();
        int y = spot.getY();
        King king = (King) spot.getPiece();
        return  !king.hasMoved() &&
                board.getSpots()[x][y + 3].getPiece() instanceof Rook &&
                board.getSpots()[x][y + 1].getPiece() == null &&
                board.getSpots()[x][y + 2].getPiece() == null;
    }

    private boolean canCastleQueenside(Board board, Spot spot) {
        // Sprawdź, czy król i wieża są na swoich oryginalnych pozycjach
        int x = spot.getX();
        int y = spot.getY();
        King king = (King) spot.getPiece();
        return  !king.hasMoved() &&
                board.getSpots()[x][y - 4].getPiece() instanceof Rook &&
                board.getSpots()[x][y - 1].getPiece() == null &&
                board.getSpots()[x][y - 2].getPiece() == null &&
                board.getSpots()[x][y - 3].getPiece() == null;
    }
}
