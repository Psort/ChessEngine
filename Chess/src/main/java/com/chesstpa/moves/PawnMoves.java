package com.chesstpa.moves;


import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Pawn;
import com.chesstpa.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class PawnMoves {


    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int x = spot.getX();
        int y = spot.getY();
        int direction = (spot.getPiece().getColor() == PieceColor.White) ? -1 : 1;

        // Standard pawn move one square forward
        Spot forwardOne = board.getSpots()[x + direction][y];
        if (isValidMove(x + direction, y, board) && forwardOne.isEmpty()) {
            possibleMoves.add(forwardOne);
        }

        // Pawn move two squares forward from the starting position
        if (
                isValidMove(x + direction, y, board) && forwardOne.isEmpty() &&
                spot.getPiece() instanceof Pawn
                && !((Pawn) spot.getPiece()).hasMoved()
        ) {
            Spot forwardTwo = board.getSpots()[x + 2 * direction][y];
            if (isValidMove(x + 2 * direction, y, board) && forwardTwo.isEmpty()) {
                possibleMoves.add(forwardTwo);
            }
        }

        // Pawn captures
        if (isValidAttack(x + direction, y - 1, board)) {
            Spot diagonalLeft = board.getSpots()[x + direction][y - 1];
            possibleMoves.add(diagonalLeft);
        }
        if (isValidAttack(x + direction, y + 1, board)) {
            Spot diagonalRight = board.getSpots()[x + direction][y + 1];
            possibleMoves.add(diagonalRight);
        }

        // Check for en passant capture
        if (isValidEnPassant(x+ direction, y - 1, board,direction)) {
            Spot enPassantLeft = board.getSpots()[x+ direction][y - 1];
            possibleMoves.add(enPassantLeft);
        }
        if (isValidEnPassant(x+ direction, y + 1, board,direction)) {
            Spot enPassantRight = board.getSpots()[x+ direction][y + 1];
            possibleMoves.add(enPassantRight);
        }

        return possibleMoves;
    }

    private boolean isValidEnPassant(int x, int y, Board board,int direction) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE &&
                board.getSpots()[x- direction][y].getPiece() instanceof Pawn &&
                ((Pawn) board.getSpots()[x- direction][y].getPiece()).isFirstMove() &&
                board.getSpots()[x][y].isEmpty();
    }

    private boolean isValidMove(int x, int y, Board board) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE && board.getSpots()[x][y].isEmpty();
    }

    private boolean isValidAttack(int x, int y, Board board) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE && !board.getSpots()[x][y].isEmpty();
    }
}
