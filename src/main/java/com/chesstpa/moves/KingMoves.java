package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.King;
import com.chesstpa.pieces.PieceColor;
import com.chesstpa.pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class KingMoves {
    private final int[][] moves = PieceType.KING.getMoves();

    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();

        //Add standard king moves
        addStandardKingMoves(board, spot, possibleMoves);

        // Add the possibility of castling
        addCastlingMoves(board, spot, possibleMoves);

        return possibleMoves;
    }

    private void addStandardKingMoves(Board board, Spot spot, List<Spot> possibleMoves) {
        for (int[] move : moves) {
            int newX = spot.getPosition().getX() + move[0];
            int newY = spot.getPosition().getY() + move[1];
            if (isValidMove(newX, newY, board, spot.getPiece().getColor())) {
                possibleMoves.add(board.getSpots()[newX][newY]);
            }
        }
    }

    private void addCastlingMoves(Board board, Spot spot, List<Spot> possibleMoves) {
        int x = spot.getPosition().getX();
        int y = spot.getPosition().getY() ;
        if (canCastleKingSide(board, spot)) {
            possibleMoves.add(board.getSpots()[x][y + 2]);
        }
        if (canCastleQueenSide(board, spot)) {
            possibleMoves.add(board.getSpots()[x][y - 2]);
        }
    }

    private boolean isValidMove(int x, int y, Board board, PieceColor color) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE
                && !board.getSpots()[x][y].isBeaten(board,color)
                && (board.getSpots()[x][y].isEmpty()
                || board.getSpots()[x][y].getPiece().getColor() != color);
    }

    private boolean canCastleKingSide(Board board, Spot spot) {
        // Check that the king and rook are in their original positions
        int x = spot.getPosition().getX();
        int y = spot.getPosition().getY() ;
        King king = (King) spot.getPiece();
        return king.hasShortCastle() &&
                board.getSpots()[x][y + 1].isEmpty() &&
                !board.getSpots()[x][y + 1].isBeaten(board,spot.getPiece().getColor()) &&
                board.getSpots()[x][y + 2].isEmpty() &&
                !board.getSpots()[x][y + 2].isBeaten(board,spot.getPiece().getColor());
    }
//
    private boolean canCastleQueenSide(Board board, Spot spot) {
        // Check that the king and rook are in their original positions
        int x = spot.getPosition().getX();
        int y = spot.getPosition().getY() ;
        King king = (King) spot.getPiece();
        return king.hasLongCastle() &&
                board.getSpots()[x][y - 1].isEmpty() &&
                !board.getSpots()[x][y - 1].isBeaten(board,spot.getPiece().getColor()) &&
                board.getSpots()[x][y - 2].isEmpty() &&
                !board.getSpots()[x][y - 2].isBeaten(board,spot.getPiece().getColor()) &&
                board.getSpots()[x][y - 3].isEmpty() &&
                !board.getSpots()[x][y - 3].isBeaten(board,spot.getPiece().getColor());
    }

}
