package com.chesstpa.moves;


import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class PawnMoves {

    public List<Spot> getPossibleMoves(Board board, Spot spot) {
        int direction = (spot.getPiece().getColor() == PieceColor.White) ? -1 : 1;
        PieceColor color = spot.getPiece().getColor();
        List<Spot> possibleMoves = new ArrayList<>();
        int startSpot = color == PieceColor.White ? 6:1;
        int x = spot.getPosition().getX();
        int y = spot.getPosition().getY();

        if (isValidMove(x + direction, y, board)){
            // Standard pawn move one square forward
            Spot forwardOne = board.getSpots()[x + direction][y];
            if (forwardOne.isEmpty()){
                possibleMoves.add(forwardOne);
            }
            // Pawn move two squares forward from the starting position
            if (x == startSpot){
                Spot forwardTwo = board.getSpots()[x + 2 * direction][y];
                if (isValidMove(x + 2 * direction, y, board) && forwardTwo.isEmpty()) {
                    possibleMoves.add(forwardTwo);
                }
            }
        }


        // Pawn captures
        if (isValidAttack(x + direction, y - 1, board,color)) {
            Spot diagonalLeft = board.getSpots()[x + direction][y - 1];
            possibleMoves.add(diagonalLeft);
        }

        if (isValidAttack(x + direction, y + 1, board,color)) {
            Spot diagonalRight = board.getSpots()[x + direction][y + 1];
            possibleMoves.add(diagonalRight);
        }
        return possibleMoves;
    }
    private boolean isValidMove(int x, int y, Board board) {
        return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE && board.getSpots()[x][y].isEmpty();
    }

    private boolean isValidAttack(int x, int y, Board board,PieceColor color) {
        return x>= 0 &&
                x < Board.SIZE &&
                y >= 0 &&
                y < Board.SIZE &&
                !board.getSpots()[x][y].isEmpty() &&
                board.getSpots()[x][y].getPiece().getColor() != color;
    }
}
