package com.chesstpa.board;

import com.chesstpa.pieces.*;

public class Spot {
    private Piece piece;
    private final Position position;

    public Spot(Position position, Piece piece) {
        this.piece = piece;
        this.position = position;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isBeaten(Board board, PieceColor color) {
        PieceType pawnColor = (color == PieceColor.White) ? PieceType.WHITEPAWN : PieceType.BLACKPAWN;

        return isBeaten(color, board, PieceType.KNIGHT) || isBeaten(color, board, PieceType.KING)
                || isBeaten(color, board, pawnColor) || isBeaten(color, board);
    }

    private boolean isBeaten(PieceColor color, Board board) {
        return isBeatenByDirection(color, board, -1, 0) || isBeatenByDirection(color, board, 0, -1)
                || isBeatenByDirection(color, board, 0, 1) || isBeatenByDirection(color, board, 1, 0)
                || isBeatenByDirection(color, board, -1, -1) || isBeatenByDirection(color, board, -1, 1)
                || isBeatenByDirection(color, board, 1, -1) || isBeatenByDirection(color, board, 1, 1);
    }

    private boolean isBeatenByDirection(PieceColor color, Board board, int rowChange, int colChange) {
        int newX = position.getX() + rowChange;
        int newY = position.getY() + colChange;

        while (isValidCoordinate(newX, newY)) {
            Spot currentSpot = board.getSpot(newX, newY);

            newX += rowChange;
            newY += colChange;

            if (currentSpot.isEmpty()) {
                continue;
            }

            if (currentSpot.getPiece().getColor() == color) {
                break;
            }

            if (Math.abs(rowChange) == Math.abs(colChange)
                    && (currentSpot.getPiece() instanceof Bishop )){
                return true;
            }

            if (Math.abs(rowChange) != Math.abs(colChange)
                    && (currentSpot.getPiece() instanceof Rook )){
                return true;
            }

            return currentSpot.getPiece() instanceof Queen ;
        }
        return false;
    }

    private boolean isBeaten(PieceColor color, Board board, PieceType pieceType) {
        int[][] moves = pieceType.getMoves();

        for (int[] move : moves) {
            int newX = position.getX() + move[0];
            int newY = position.getY() + move[1];
            if (isValidCoordinate(newX, newY) && isOpponent(board.getSpot(newX, newY), color, pieceType.getaClass())) {
                return true;
            }
        }
        return false;
    }

    private boolean isOpponent(Spot spot, PieceColor color, Class opponent) {
        return spot.getPiece() != null && spot.getPiece().getClass() == opponent && spot.getPiece().getColor() != color;
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean kingIsNotSafe(Board board, Spot spot, PieceColor color, Piece piece) {
        Spot kingSpot = board.getKingSpot(color);
        Piece oldPiece = this.piece;
        this.piece = piece;
        spot.setPiece(null);
        boolean itSafe = kingSpot.isBeaten(board, color);
        spot.setPiece(piece);
        this.piece = oldPiece;
        return itSafe;
    }
}
