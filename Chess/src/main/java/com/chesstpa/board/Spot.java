package com.chesstpa.board;

import com.chesstpa.pieces.*;

public class Spot {
    private Piece piece;
    private final int x;
    private final int y;
    public Spot(int x, int y, Piece piece) {
        this.setPiece(piece);
        this.x = x;
        this.y = y;
    }
    public Piece getPiece() {
        return this.piece;
    }
    public void setPiece(Piece p) {
        this.piece = p;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isBeaten(Board board,PieceColor color) {
        // Check attack by queen, bishop, rook, king, knight and pawn
        return isBeatenByQueen(color, board) || isBeatenByBishop(color, board)
                || isBeatenByRook(color, board) || isBeatenByKing(color, board)
                || isBeatenByKnight(color, board) || isBeatenByPawn(color, board);
    }

    private boolean isBeatenByQueen(PieceColor color, Board board) {
        return isBeatenByDirection(color, board, -1, -1) || isBeatenByDirection(color, board, -1, 0)
                || isBeatenByDirection(color, board, -1, 1) || isBeatenByDirection(color, board, 0, -1)
                || isBeatenByDirection(color, board, 0, 1) || isBeatenByDirection(color, board, 1, -1)
                || isBeatenByDirection(color, board, 1, 0) || isBeatenByDirection(color, board, 1, 1);
    }

    private boolean isBeatenByBishop(PieceColor color, Board board) {
        return isBeatenByDirection(color, board, -1, -1) || isBeatenByDirection(color, board, -1, 1)
                || isBeatenByDirection(color, board, 1, -1) || isBeatenByDirection(color, board, 1, 1);
    }

    private boolean isBeatenByRook(PieceColor color, Board board) {
        return isBeatenByDirection(color, board, -1, 0) || isBeatenByDirection(color, board, 0, -1)
                || isBeatenByDirection(color, board, 0, 1) || isBeatenByDirection(color, board, 1, 0);
    }

    private boolean isBeatenByKing(PieceColor color, Board board) {
        int[][] kingMoves = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, /* Obecne pole */ {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] move : kingMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (isValidCoordinate(newX, newY) && isOpponentKing(board.getSpot(newX, newY), color)) {
                return true;
            }
        }

        return false;
    }

    private boolean isBeatenByKnight(PieceColor color, Board board) {
        int[][] knightMoves = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}
        };

        for (int[] move : knightMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (isValidCoordinate(newX, newY) && isOpponentKnight(board.getSpot(newX, newY), color)) {
                return true;
            }
        }

        return false;
    }

    private boolean isBeatenByPawn(PieceColor color, Board board) {
        int direction = (color == PieceColor.Black) ? 1 : -1;
        int[][] pawnMoves = {
                {direction, -1}, {direction, 1}
        };

        for (int[] move : pawnMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (isValidCoordinate(newX, newY) && isOpponentPawn(board.getSpot(newX, newY), color)) {
                return true;
            }
        }

        return false;
    }

    private boolean isBeatenByDirection(PieceColor color, Board board, int rowChange, int colChange) {
        int newX = x + rowChange;
        int newY = y + colChange;

        while (isValidCoordinate(newX, newY)) {
            Spot currentSpot = board.getSpot(newX, newY);
            if (currentSpot.getPiece() != null) {
                if (currentSpot.getPiece().getColor() != color &&
                        ((rowChange == 0 || colChange == 0) && (currentSpot.getPiece() instanceof Rook || currentSpot.getPiece() instanceof Queen) ||
                                (Math.abs(rowChange) == Math.abs(colChange) && (currentSpot.getPiece() instanceof Bishop || currentSpot.getPiece() instanceof Queen)))) {
                    return true;
                }
                break;
            }
            newX += rowChange;
            newY += colChange;
        }

        return false;
    }



    private boolean isOpponentKing(Spot spot, PieceColor color) {
        return spot.getPiece() instanceof King && spot.getPiece().getColor() != color;
    }

    private boolean isOpponentKnight(Spot spot, PieceColor color) {
        return spot.getPiece() instanceof Knight && spot.getPiece().getColor() != color;
    }

    private boolean isOpponentPawn(Spot spot, PieceColor color) {
        return spot.getPiece() instanceof Pawn && spot.getPiece().getColor() != color;
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE;
    }


    public boolean isEmpty() {
        return piece ==null;
    }

    public boolean safeKing(Board board, PieceColor color,Piece piece) {
        Spot kingSpot = board.getKingSpot(color);
        this.piece = piece;
        boolean itSafe = !kingSpot.isBeaten(board,color);
        this.piece = null;
        return !itSafe;
    }
}
