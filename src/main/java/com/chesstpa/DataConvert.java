package com.chesstpa;

import com.chesstpa.board.Position;
import com.chesstpa.pieces.*;

public class DataConvert {
    public static Position transformPositionToIntList(String position) {
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
            case 'r' -> new Rook(PieceColor.Black);
            case 'n' -> new Knight(PieceColor.Black);
            case 'b' -> new Bishop(PieceColor.Black);
            case 'q' -> new Queen(PieceColor.Black);
            case 'k' -> new King(PieceColor.Black);
            case 'p' -> new Pawn(PieceColor.Black);
            case 'R' -> new Rook(PieceColor.White);
            case 'N' -> new Knight(PieceColor.White);
            case 'B' -> new Bishop(PieceColor.White);
            case 'Q' -> new Queen(PieceColor.White);
            case 'K' -> new King(PieceColor.White);
            case 'P' -> new Pawn(PieceColor.White);
            default -> null;
        };

    }
}
