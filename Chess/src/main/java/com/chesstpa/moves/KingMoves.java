package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.King;
import com.chesstpa.pieces.PieceColor;
import com.chesstpa.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class KingMoves {

    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();

        // Dodaj standardowe ruchy króla
        addStandardKingMoves(board, spot, possibleMoves);

        // Dodaj możliwość roszad
        addCastlingMoves(board, spot, possibleMoves);

        return possibleMoves;
    }

    private void addStandardKingMoves(Board board, Spot spot, List<Spot> possibleMoves) {

        int[][] moves = {
                {-1, -1}, {-1, 0}, {-1, 1}, // Ruchy do góry
                {0, -1}, /* Bieżące pole */ {0, 1}, // Ruchy w lewo i w prawo
                {1, -1}, {1, 0}, {1, 1} // Ruchy w dół
        };

        for (int[] move : moves) {
            int newX = spot.getX() + move[0];
            int newY = spot.getY() + move[1];
            if (isValidMove(newX, newY, board, spot.getPiece().getColor())) {
                possibleMoves.add(board.getSpots()[newX][newY]);
            }
        }
    }

    private void addCastlingMoves(Board board, Spot spot, List<Spot> possibleMoves) {
        if (canCastleKingSide(board, spot)) {
            possibleMoves.add(board.getSpots()[spot.getX()][spot.getY() + 2]);
        }
        if (canCastleQueenSide(board, spot)) {
            possibleMoves.add(board.getSpots()[spot.getX()][spot.getY() - 2]);
        }
    }

    private boolean isValidMove(int x, int y, Board board, PieceColor color) {
        return x >= 0 && x < board.getSpots().length && y >= 0 && y < board.getSpots()[x].length
                && !board.getSpots()[x][y].isBeaten(board,color)
                && (board.getSpots()[x][y].isEmpty()
                || board.getSpots()[x][y].getPiece().getColor() != color);
    }

    private boolean canCastleKingSide(Board board, Spot spot) {
        // Check that the king and rook are in their original positions
        int x = spot.getX();
        int y = spot.getY();
        King king = (King) spot.getPiece();
        return  !king.hasMoved() &&
                board.getSpots()[x][y + 3].getPiece() instanceof Rook &&
                !((Rook) board.getSpots()[x][y +3].getPiece()).isHasMoved() &&
                board.getSpots()[x][y + 1].isEmpty() &&
                !board.getSpots()[x][y + 1].isBeaten(board,spot.getPiece().getColor()) &&
                board.getSpots()[x][y + 2].isEmpty() &&
                !board.getSpots()[x][y + 2].isBeaten(board,spot.getPiece().getColor());
    }

    private boolean canCastleQueenSide(Board board, Spot spot) {
        // Check that the king and rook are in their original positions
        int x = spot.getX();
        int y = spot.getY();
        King king = (King) spot.getPiece();
        return  !king.hasMoved() &&
                board.getSpots()[x][y - 4].getPiece() instanceof Rook &&
                !((Rook) board.getSpots()[x][y - 4].getPiece()).isHasMoved() &&
                board.getSpots()[x][y - 1].isEmpty() &&
                !board.getSpots()[x][y - 1].isBeaten(board,spot.getPiece().getColor()) &&
                board.getSpots()[x][y - 2].isEmpty() &&
                !board.getSpots()[x][y - 2].isBeaten(board,spot.getPiece().getColor()) &&
                board.getSpots()[x][y - 3].isEmpty() &&
                !board.getSpots()[x][y - 3].isBeaten(board,spot.getPiece().getColor());
    }
}
