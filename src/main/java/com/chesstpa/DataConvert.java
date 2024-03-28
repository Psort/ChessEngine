package com.chesstpa;

import com.chesstpa.board.Position;
import com.chesstpa.pieces.*;

import java.util.Objects;

public class DataConvert {
    public static Position transformPositionToIntList(String position) {
        if (Objects.equals(position, "")){
            return null;
        }
        int x = Integer.parseInt(position.substring(1)) - 1;
        int y = position.toUpperCase().charAt(0) - 'A'; // Przyjmując, że pozycje są w formie "A1", "B2", itp.
        return new Position(x,y);
    }
    public static String transformIntListToPosition(int x, int y) {
        char letter = (char) ('a' + y);
        return letter + Integer.toString(x + 1);
    }
    public static Piece createPieceFromSymbol(char symbol) {
        return switch (symbol) {
            case 'r' -> new Rook(PieceColor.BLACK);
            case 'n' -> new Knight(PieceColor.BLACK);
            case 'b' -> new Bishop(PieceColor.BLACK);
            case 'q' -> new Queen(PieceColor.BLACK);
            case 'k' -> new King(PieceColor.BLACK);
            case 'p' -> new Pawn(PieceColor.BLACK);
            case 'R' -> new Rook(PieceColor.WHITE);
            case 'N' -> new Knight(PieceColor.WHITE);
            case 'B' -> new Bishop(PieceColor.WHITE);
            case 'Q' -> new Queen(PieceColor.WHITE);
            case 'K' -> new King(PieceColor.WHITE);
            case 'P' -> new Pawn(PieceColor.WHITE);
            default -> null;
        };

    }
}
